package com.sandboxol.common.binding.model.datarv;

import android.content.Context;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.binding.model.IListModel;

import java.util.List;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public abstract class IDataModel<T> implements IListModel<T> {

    protected Context context;
    private String errorHint;

    public IDataModel(Context context, int errorResId) {
        this.context = context;
        this.errorHint = context.getResources().getString(errorResId);
    }

    public abstract void onLoad(OnResponseListener<HttpResponse<List<T>>> listener);

    @Override
    public String getRemoveToken() {
        return null;
    }

    @Override
    public String getInsertToken() {
        return null;
    }

    @Override
    public String getReplaceToken() {
        return null;
    }

    public String getErrorHint() {
        if (errorHint == null || "".equals(errorHint))
            return "No data";
        return errorHint;
    }
}

