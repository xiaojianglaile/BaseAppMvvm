package com.jimmy.baseapp.main;

import android.content.Context;

import com.jimmy.baseapp.BR;
import com.jimmy.baseapp.R;
import com.jimmy.baseapp.config.MessageToken;
import com.jimmy.baseapp.entity.AppConfig;
import com.jimmy.baseapp.entity.ItemData;
import com.jimmy.baseapp.web.Ols;
import com.sandboxol.common.binding.viewmodel.IListItemViewModel;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.binding.model.pagerv.IPageModel;

import java.util.ArrayList;
import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class MainListModel extends IPageModel<ItemData> {

    public MainListModel(Context context, int errorResId) {
        super(context, errorResId);
    }

    @Override
    public void onLoad(int page, int size, OnResponseListener<HttpResponse<List<ItemData>>> listener) {
        Ols.getAppConfig(context, new OnResponseListener<AppConfig>() { // 为了延迟而已
            @Override
            public void onSuccess(AppConfig data1) {
                int index = 1;
                List<ItemData> data = new ArrayList<>();
                for (int i = page * size; i < (page + 1) * size; i++) {
                    ItemData item = new ItemData();
                    item.setTitle("ItemData:" + (page * size + index));
                    data.add(item);
                    index++;
                }
                HttpResponse<List<ItemData>> response = new HttpResponse();
                response.setCode(1);
                response.setData(data);
                listener.onSuccess(response);
            }

            @Override
            public void onError(int code, String msg) {

            }

            @Override
            public void onServerError(int error) {

            }
        });
    }

    @Override
    public void onBind(ItemView itemView, int position, IListItemViewModel<ItemData> item) {
        itemView.set(BR.mainItem, R.layout.list_item_main);
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public IListItemViewModel<ItemData> getItemViewModel(ItemData item) {
        return new MainListItemViewModel(context, item);
    }

    @Override
    public String getInsertToken() {
        return MessageToken.MAIN_ITEM_INSERT_TOKEN;
    }

}
