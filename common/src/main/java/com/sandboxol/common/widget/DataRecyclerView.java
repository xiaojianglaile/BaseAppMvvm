package com.sandboxol.common.widget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.sandboxol.common.R;
import com.sandboxol.common.binding.model.datarv.IDataModel;
import com.sandboxol.common.binding.viewmodel.DataListViewModel;
import com.sandboxol.common.databinding.DataListViewBinding;

import me.tatarka.bindingcollectionadapter.LayoutManagers;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class DataRecyclerView extends FrameLayout {

    private DataListViewBinding binding;
    private Context context;

    public DataRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public DataRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DataRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.data_list_view, this, true);
    }

    public void setModel(IDataModel model) {
        binding.setViewModel(new DataListViewModel(context, model));
    }

    public void setLayoutFactory(LayoutManagers.LayoutManagerFactory layoutFactory) {
        binding.rvData.setLayoutManager(layoutFactory.create(binding.rvData));
    }
}
