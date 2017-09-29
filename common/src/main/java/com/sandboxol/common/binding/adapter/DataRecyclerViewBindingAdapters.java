package com.sandboxol.common.binding.adapter;

import android.databinding.BindingAdapter;

import com.sandboxol.common.binding.model.datarv.IDataModel;
import com.sandboxol.common.widget.DataRecyclerView;

import me.tatarka.bindingcollectionadapter.LayoutManagers;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class DataRecyclerViewBindingAdapters {

    @BindingAdapter(value = {"model", "layoutFactory"}, requireAll = false)
    public static void setModelAndLayoutFactory(DataRecyclerView dataRecyclerView, IDataModel model, LayoutManagers.LayoutManagerFactory layoutFactory) {
        dataRecyclerView.setModel(model);
        if (layoutFactory == null) {
            dataRecyclerView.setLayoutFactory(LayoutManagers.linear());
        } else {
            dataRecyclerView.setLayoutFactory(layoutFactory);
        }
    }

}
