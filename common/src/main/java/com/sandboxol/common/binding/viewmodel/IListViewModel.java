package com.sandboxol.common.binding.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.text.TextUtils;

import com.sandboxol.common.binding.model.IListModel;
import com.sandboxol.common.binding.model.msg.InsertMsg;
import com.sandboxol.common.binding.style.ListViewStyle;
import com.sandboxol.common.messenger.Messenger;

import me.tatarka.bindingcollectionadapter.BaseItemViewSelector;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public abstract class IListViewModel<T> implements ViewModel {

    protected Context context;
    protected IListModel model;
    public ListViewStyle viewStyle = new ListViewStyle();

    public IListViewModel(Context context, IListModel model) {
        this.context = context;
        this.model = model;
    }

    public final ObservableList<IListItemViewModel<T>> itemViewModel = new ObservableArrayList<>();

    public final ItemViewSelector<IListItemViewModel<T>> itemView = new BaseItemViewSelector<IListItemViewModel<T>>() {
        @Override
        public void select(ItemView itemView, int position, IListItemViewModel<T> item) {
            bindView(itemView, position, item);
        }

        @Override
        public int viewTypeCount() {
            return IListViewModel.this.getViewTypeCount();
        }
    };

    public void setRefreshing(boolean refreshing) {
        viewStyle.setRefreshing(refreshing);
    }

    protected void addItemViewModel(IListItemViewModel<T> item) {
        itemViewModel.add(item);
    }

    protected void addItemViewModel(IListItemViewModel<T> item, int index, InsertMsg.INSERT_MODE mode) {
        if (mode == InsertMsg.INSERT_MODE.END) {
            addItemViewModel(item);
        } else if (mode == InsertMsg.INSERT_MODE.FIRST) {
            itemViewModel.add(0, item);
        } else {
            itemViewModel.add(index, item);
        }
    }

    protected void clearItemViewModel() {
        itemViewModel.clear();
    }

    protected void removeItemViewModel(Object item) {
        if (item instanceof IListItemViewModel)
            itemViewModel.remove(item);
    }

    protected void hideEmptyView() {
        if (!itemViewModel.isEmpty()) {
            viewStyle.setShowEmptyView(false);
        } else {
            showEmptyView(null);
        }
    }

    protected void showEmptyView(String error) {
        if (itemViewModel.isEmpty()) {
            viewStyle.setShowEmptyView(true);
            if (!TextUtils.isEmpty(error)) {
                viewStyle.setEmptyText(error);
            } else {
                viewStyle.setEmptyText(model != null ? model.getErrorHint() : "No data");
            }
        }
    }

    protected void bindView(ItemView itemView, int position, IListItemViewModel<T> item) {

    }

    protected int getViewTypeCount() {
        return model != null ? model.getViewTypeCount() : 1;
    }

    protected void registerMessenger() {
        if (model.getRemoveToken() != null) {
            Messenger.getDefault().register(this, model.getRemoveToken(), model.getItemViewModelClass(), this::removeItemViewModel);
        }
        if (model.getInsertToken() != null) {
            Messenger.getDefault().register(this, model.getInsertToken(), InsertMsg.class,
                    item -> addItemViewModel(model.getItemViewModel(item.getData()), item.getIndex(), item.getMode()));
        }
    }

}
