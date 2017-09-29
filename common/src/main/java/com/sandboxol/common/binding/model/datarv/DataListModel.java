package com.sandboxol.common.binding.model.datarv;

import com.sandboxol.common.binding.viewmodel.IListItemViewModel;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;

import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public class DataListModel<T> implements IDataListModel<T> {

    @Override
    public void loadData(IDataModel model, OnResponseListener<HttpResponse<List<T>>> listener) {
        if (model != null) {
            model.onLoad(listener);
        }
    }

    @Override
    public void bindView(IDataModel model, ItemView itemView, int position, IListItemViewModel<T> item) {
        if (model != null) {
            model.onBind(itemView, position, item);
        }
    }
}
