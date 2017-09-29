package com.sandboxol.common.base.app;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * Created by Jimmy on 2016/7/31.
 */
public abstract class BaseFragment<D extends ViewDataBinding> extends RxFragment {

    protected Activity activity;
    protected Context context;
    protected D binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        initView();
        initViewModel(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        bindView();
    }

    protected abstract int getLayoutId();

    protected void initView() {

    }

    protected void bindView() {

    }

    protected abstract void initViewModel(BaseFragment fragment);

}
