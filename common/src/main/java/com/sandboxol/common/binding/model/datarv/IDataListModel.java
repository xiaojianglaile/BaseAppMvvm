package com.sandboxol.common.binding.model.datarv;

import com.sandboxol.common.binding.viewmodel.IListItemViewModel;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;

import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public interface IDataListModel<T> {
    void loadData(IDataModel model, OnResponseListener<HttpResponse<List<T>>> listener);

    void bindView(IDataModel model, ItemView itemView, int position, IListItemViewModel<T> item);
}
