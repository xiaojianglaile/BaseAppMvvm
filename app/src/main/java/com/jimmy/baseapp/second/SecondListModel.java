package com.jimmy.baseapp.second;

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
import com.sandboxol.common.binding.model.datarv.IDataModel;
import com.sandboxol.common.utils.ResponseUtils;

import java.util.ArrayList;
import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class SecondListModel extends IDataModel<ItemData> {

    public SecondListModel(Context context, int errorResId) {
        super(context, errorResId);
    }

    @Override
    public void onLoad(OnResponseListener<HttpResponse<List<ItemData>>> listener) {
        Ols.getAppConfig(context, new OnResponseListener<AppConfig>() {
            @Override
            public void onSuccess(AppConfig data) {
                List<ItemData> data1 = new ArrayList<>();
                for (int i = 1; i < 21; i++) {
                    ItemData item = new ItemData();
                    item.setTitle("ItemData:" + i);
                    data1.add(item);
                }
                listener.onSuccess(ResponseUtils.success(data1));
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
        itemView.set(BR.secondItem, R.layout.list_item_second);
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public IListItemViewModel<ItemData> getItemViewModel(ItemData item) {
        return new SecondListItemViewModel(context, item);
    }

    @Override
    public String getRemoveToken() {
        return MessageToken.SECOND_ITEM_REMOVE_TOKEN;
    }

    @Override
    public Class getItemViewModelClass() {
        return SecondListItemViewModel.class;
    }
}
