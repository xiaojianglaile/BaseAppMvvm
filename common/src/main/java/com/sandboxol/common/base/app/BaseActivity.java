package com.sandboxol.common.base.app;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindData();
    }

    protected abstract void bindView();

    /**
     * 请求动态数据
     */
    protected void initData() {

    }

    /**
     * 绑定静态数据
     */
    protected void bindData() {

    }

}
