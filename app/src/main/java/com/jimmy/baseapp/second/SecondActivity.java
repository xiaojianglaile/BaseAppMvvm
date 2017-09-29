package com.jimmy.baseapp.second;

import android.databinding.DataBindingUtil;

import com.jimmy.baseapp.R;
import com.jimmy.baseapp.databinding.ActivitySecondBinding;
import com.sandboxol.common.base.app.BaseActivity;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class SecondActivity extends BaseActivity {

    @Override
    protected void bindView() {
        ActivitySecondBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        binding.setSecondModel(new SecondListModel(this, R.string.app_name));
    }
}
