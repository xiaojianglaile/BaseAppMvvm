package com.jimmy.baseapp.web;

import android.content.Context;

import com.jimmy.baseapp.entity.AppConfig;
import com.jimmy.baseapp.entity.Friend;
import com.jimmy.baseapp.entity.ItemData;
import com.sandboxol.common.base.web.HttpListSubscriber;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.ActivityLifecycleProvider;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class Ols {

    private static final OlsApi api = RetrofitFactory.create("http://ols.sandboxol.cn:9000", OlsApi.class);

    public static void getAppConfig(Context context, OnResponseListener<AppConfig> listener) {
        api.getAppConfig()
                .compose(((ActivityLifecycleProvider) context).bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpSubscriber<>(listener));
    }

    public static void getFriends(OnResponseListener<List<Friend>> listener) {
        api.getFriends(11l, 0l, "22222").subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpSubscriber<>(listener));
    }

    public static void getItemData(OnResponseListener<HttpResponse<List<ItemData>>> listener) {
        api.getItemData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpListSubscriber<>(listener));
    }

}
