package com.sandboxol.common.binding.viewmodel;

import android.content.Context;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public abstract class IListItemViewModel<T> implements ViewModel {

    protected Context context;
    protected T item;

    public IListItemViewModel(Context context, T item) {
        this.context = context;
        this.item = item;
    }

    protected T getItem() {
        return item;
    }

}
