package com.sandboxol.common.binding.viewmodel;

import android.content.Context;

import com.sandboxol.common.R;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.binding.model.datarv.DataListModel;
import com.sandboxol.common.binding.model.datarv.IDataModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.config.HttpCode;

import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;
import rx.Observable;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class DataListViewModel<T> extends IListViewModel {

    private IDataModel model;
    private DataListModel dataListModel = new DataListModel();

    public DataListViewModel(Context context, IDataModel model) {
        super(context, model);
        this.model = model;
        loadData();
    }

    public ReplyCommand onRefreshCommand = new ReplyCommand(this::onRefresh);

    protected void onRefresh() {
        loadData();
    }

    protected void loadData() {
        showEmptyView(context.getResources().getString(R.string.loading));
        dataListModel.loadData(model, new OnResponseListener<HttpResponse<List<T>>>() {
            @Override
            public void onSuccess(HttpResponse<List<T>> data) {
                clearItems();
                Observable.just(data)
                        .filter(d -> HttpCode.SUCCESS == d.getCode())
                        .filter(d -> d.getData() != null)
                        .subscribe(d -> addItems(d.getData()));
                hideEmptyView();
                setRefreshing(false);
            }

            @Override
            public void onError(int code, String msg) {
                showEmptyView(null);
                setRefreshing(false);
            }

            @Override
            public void onServerError(int error) {
                showEmptyView(null);
                setRefreshing(false);
            }
        });
    }

    protected void bindView(ItemView itemView, int position, IListItemViewModel item) {
        dataListModel.bindView(model, itemView, position, item);
    }

}
