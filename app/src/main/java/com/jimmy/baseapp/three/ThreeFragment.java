package com.jimmy.baseapp.three;

import com.jimmy.baseapp.R;
import com.jimmy.baseapp.databinding.FragmentThreeBinding;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.base.app.TemplateFragment;

/**
 * Created by Jimmy on 2017/9/29 0029.
 */
public class ThreeFragment extends TemplateFragment<FragmentThreeBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_three;
    }

    @Override
    protected void initViewModel(BaseFragment fragment) {
        binding.setThreeViewModel(new ThreeViewModel(fragment.getClass().getName()));
    }
}
