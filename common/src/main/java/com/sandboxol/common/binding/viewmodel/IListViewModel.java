package com.sandboxol.common.binding.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.text.TextUtils;

import com.sandboxol.common.R;
import com.sandboxol.common.binding.model.IListModel;
import com.sandboxol.common.binding.model.msg.InsertMsg;
import com.sandboxol.common.binding.model.msg.RemoveMsg;
import com.sandboxol.common.binding.model.msg.ReplaceMsg;
import com.sandboxol.common.binding.style.ListViewStyle;
import com.sandboxol.common.messenger.Messenger;

import java.util.ArrayList;
import java.util.List;

import me.tatarka.bindingcollectionadapter.BaseItemViewSelector;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.ItemViewSelector;
import rx.Observable;

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
        registerMessenger();
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

    protected void addItem(Object item) {
        addItem(item, 0, InsertMsg.INSERT_MODE.END);
    }

    protected void addItem(Object item, int index, InsertMsg.INSERT_MODE mode) {
        if (mode == InsertMsg.INSERT_MODE.END) {
            itemViewModel.add(model.getItemViewModel(item));
        } else if (mode == InsertMsg.INSERT_MODE.FIRST) {
            itemViewModel.add(0, model.getItemViewModel(item));
        } else {
            itemViewModel.add(index, model.getItemViewModel(item));
        }
    }

    protected void addItems(List<Object> items) {
        addItems(items, 0, InsertMsg.INSERT_MODE.END);
    }

    protected void addItems(List<Object> items, int index, InsertMsg.INSERT_MODE mode) {
        List<IListItemViewModel<T>> itemViewModels = new ArrayList<>();
        Observable.from(items).subscribe(item -> itemViewModels.add(model.getItemViewModel(item)));
        if (mode == InsertMsg.INSERT_MODE.END) {
            itemViewModel.addAll(itemViewModels);
        } else if (mode == InsertMsg.INSERT_MODE.FIRST) {
            itemViewModel.addAll(0, itemViewModels);
        } else {
            itemViewModel.addAll(index, itemViewModels);
        }
    }

    protected void clearItems() {
        itemViewModel.clear();
    }

    protected void removeItem(Object item) {
        if (item instanceof IListItemViewModel) {
            itemViewModel.remove(item);
        }
    }

    protected void removeItems(Object items) {
        if (items instanceof List) {
            List<Object> removeItems = (List<Object>) items;
            List<IListItemViewModel> viewModels = new ArrayList<>();
            if (removeItems.size() > 0) {
                Observable.from(removeItems).subscribe((item) -> {
                    if (item instanceof IListItemViewModel) {
                        viewModels.add((IListItemViewModel) item);
                    }
                });
                itemViewModel.removeAll(viewModels);
            }
        }
    }

    protected void removeIndex(int index) {
        itemViewModel.remove(index);
    }

    protected void remove(Object data, int index, RemoveMsg.REMOVE_MODE mode) {
        switch (mode) {
            case CLEAR:
                clearItems();
                break;
            case ITEM:
                removeItem(data);
                break;
            case LIST:
                removeItems(data);
                break;
            case INDEX:
                removeIndex(index);
                break;
        }
    }

    protected void add(Object data, int index, InsertMsg.INSERT_MODE mode) {
        if (data instanceof List) {
            addItems((List<Object>) data, index, mode);
        } else {
            addItem(data, index, mode);
        }
    }

    protected void replaceAll(List<Object> data) {
        clearItems();
        addItems(data);
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
                viewStyle.setEmptyText(model != null ? model.getErrorHint() : context.getResources().getString(R.string.no_data));
            }
        }
    }

    protected void bindView(ItemView itemView, int position, IListItemViewModel<T> item) {

    }

    protected int getViewTypeCount() {
        return model != null ? model.getViewTypeCount() : 1;
    }

    protected void registerMessenger() {
        if (model != null) {
            if (model.getRemoveToken() != null) {
                Messenger.getDefault().register(this, model.getRemoveToken(), RemoveMsg.class, msg -> remove(msg.getData(), msg.getIndex(), msg.getMode()));
            }
            if (model.getInsertToken() != null) {
                Messenger.getDefault().register(this, model.getInsertToken(), InsertMsg.class, msg -> add(msg.getData(), msg.getIndex(), msg.getMode()));
            }
            if (model.getReplaceToken() != null) {
                Messenger.getDefault().register(this, model.getReplaceToken(), ReplaceMsg.class, msg -> replaceAll(msg.getData()));
            }
        }
    }

}
