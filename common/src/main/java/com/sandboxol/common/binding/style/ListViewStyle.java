package com.sandboxol.common.binding.style;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.sandboxol.common.BR;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class ListViewStyle extends BaseObservable {

    private boolean isRefreshing;
    private boolean isLoadingMore;
    private boolean isShowEmptyView;
    private String emptyText;

    @Bindable
    public boolean isRefreshing() {
        return isRefreshing;
    }

    public void setRefreshing(boolean refreshing) {
        isRefreshing = refreshing;
        notifyPropertyChanged(BR.refreshing);
    }

    @Bindable
    public boolean isLoadingMore() {
        return isLoadingMore;
    }

    public void setLoadingMore(boolean loadingMore) {
        isLoadingMore = loadingMore;
        notifyPropertyChanged(BR.loadingMore);
    }

    @Bindable
    public boolean isShowEmptyView() {
        return isShowEmptyView;
    }

    public void setShowEmptyView(boolean showEmptyView) {
        isShowEmptyView = showEmptyView;
        notifyPropertyChanged(BR.showEmptyView);
    }

    @Bindable
    public String getEmptyText() {
        return emptyText;
    }

    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
        notifyPropertyChanged(BR.emptyText);
    }
}
