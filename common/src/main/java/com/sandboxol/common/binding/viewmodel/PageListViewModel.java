package com.sandboxol.common.binding.viewmodel;

import android.content.Context;

import com.sandboxol.common.R;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.binding.model.pagerv.IPageModel;
import com.sandboxol.common.binding.model.pagerv.PageListModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.HttpCode;
import com.sandboxol.common.config.PageConfig;

import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;
import rx.Observable;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class PageListViewModel<T> extends IListViewModel {

    private int page = PageConfig.DEFAULT_PAGE;
    private int size = PageConfig.DEFAULT_SIZE;
    private int defaultPage = 0;
    private boolean isMore;

    protected IPageModel model;
    private PageListModel pageListModel = new PageListModel();

    public PageListViewModel(Context context, IPageModel model, int defaultPage, int pageSize) {
        super(context, model);
        this.defaultPage = defaultPage;
        this.size = pageSize;
        this.model = model;
        onRefresh();
    }

    public ReplyCommand onRefreshCommand = new ReplyCommand(this::onRefresh);

    public ReplyCommand<Integer> onLoadMoreCommand = new ReplyCommand<>(count -> onLoadMore());

    protected void onRefresh() {
        isMore = true;
        page = defaultPage;
        loadData(page, true);
    }

    protected void onLoadMore() {
        if (isMore) {
            page++;
            loadData(page, false);
        }
    }

    protected void loadData(int page, boolean isRefresh) {
        showEmptyView(context.getResources().getString(R.string.loading));
        pageListModel.loadData(model, page, size, new OnResponseListener<HttpResponse<List<T>>>() {
            @Override
            public void onSuccess(HttpResponse<List<T>> data) {
                if (isRefresh)
                    clearItems();
                Observable.just(data)
                        .filter(d -> HttpCode.SUCCESS == d.getCode())
                        .filter(d -> d.getData() != null)
                        .doOnNext(d -> isMore = d.getData().size() >= size)
                        .subscribe(d -> addItems(d.getData()));
                hideEmptyView();
                setRefreshing(false);
            }

            @Override
            public void onError(int code, String msg) {
                setRefreshing(false);
                showEmptyView(null);
            }

            @Override
            public void onServerError(int error) {
                setRefreshing(false);
                showEmptyView(null);
            }
        });

    }

    protected void bindView(ItemView itemView, int position, IListItemViewModel item) {
        pageListModel.bindView(model, itemView, position, item);
    }

}
