package com.sandboxol.common.binding.model.pagerv;

import com.sandboxol.common.binding.viewmodel.IListItemViewModel;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;

import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public class PageListModel<T> implements IPageListModel<T> {

    @Override
    public void loadData(IPageModel model, int page, int size, OnResponseListener<HttpResponse<List<T>>> listener) {
        if (model != null) {
            model.onLoad(page, size, listener);
        }
    }

    @Override
    public void bindView(IPageModel model, ItemView itemView, int position, IListItemViewModel<T> item) {
        if (model != null) {
            model.onBind(itemView, position, item);
        }
    }

}
