package com.sandboxol.common.binding.adapter;

import android.databinding.BindingAdapter;

import com.sandboxol.common.binding.model.pagerv.IPageModel;
import com.sandboxol.common.widget.PageRecyclerView;

import me.tatarka.bindingcollectionadapter.LayoutManagers;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class PageRecyclerViewBindingAdapters {

    @BindingAdapter(value = {"model", "layoutFactory"}, requireAll = false)
    public static void setModelAndLayoutFactory(PageRecyclerView pageRecyclerView, IPageModel model, LayoutManagers.LayoutManagerFactory layoutFactory) {
        pageRecyclerView.setModel(model);
        if (layoutFactory == null) {
            pageRecyclerView.setLayoutFactory(LayoutManagers.linear());
        } else {
            pageRecyclerView.setLayoutFactory(layoutFactory);
        }
    }
}
