package com.sandboxol.common.base.app;

import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.TextView;

import com.sandboxol.common.R;

/**
 * Created by Jimmy on 2016/10/19 0019.
 */
public abstract class TemplateFragment<D extends ViewDataBinding> extends BaseFragment<D> {

    public void onLeftButtonClick(View v) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void onRightButtonClick(View v) {

    }

    public void changeActionBarTitle(String title) {
        if (activity != null && activity instanceof TemplateActivity) {
            TextView tvTemplateTitle = activity.findViewById(R.id.tvTemplateTitle);
            tvTemplateTitle.setText(title);
        }
    }

    public void hideLeftButton() {
        if (activity != null && activity instanceof TemplateActivity) {
            activity.findViewById(R.id.ibTemplateLeft).setVisibility(View.GONE);
        }
    }

}
