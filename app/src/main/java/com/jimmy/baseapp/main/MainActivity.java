package com.jimmy.baseapp.main;

import android.databinding.DataBindingUtil;

import com.jimmy.baseapp.R;
import com.jimmy.baseapp.databinding.ActivityMainBinding;
import com.sandboxol.common.base.app.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void bindView() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainModel(new MainListModel(this, R.string.app_name));
    }
}
