package com.sandboxol.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.sandboxol.common.R;
import com.sandboxol.common.binding.model.pagerv.IPageModel;
import com.sandboxol.common.binding.viewmodel.PageListViewModel;
import com.sandboxol.common.config.PageConfig;
import com.sandboxol.common.databinding.PageListViewBinding;

import me.tatarka.bindingcollectionadapter.LayoutManagers;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class PageRecyclerView extends FrameLayout {

    private PageListViewBinding binding;
    private Context context;
    private int page, size;

    public PageRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public PageRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PageRecyclerView);
        page = array.getInteger(R.styleable.PageRecyclerView_page, PageConfig.DEFAULT_PAGE);
        size = array.getInteger(R.styleable.PageRecyclerView_size, PageConfig.DEFAULT_SIZE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.page_list_view, this, true);
        array.recycle();
    }

    public void setModel(IPageModel model) {
        binding.setViewModel(new PageListViewModel(context, model, page, size));
    }

    public void setLayoutFactory(LayoutManagers.LayoutManagerFactory layoutFactory) {
        binding.rvData.setLayoutManager(layoutFactory.create(binding.rvData));
    }

}
