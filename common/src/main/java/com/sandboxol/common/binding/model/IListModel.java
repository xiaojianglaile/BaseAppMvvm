package com.sandboxol.common.binding.model;

import com.sandboxol.common.binding.viewmodel.IListItemViewModel;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public interface IListModel<T> extends IModel {
    void onBind(ItemView itemView, int position, IListItemViewModel<T> item);

    int getViewTypeCount();

    IListItemViewModel<T> getItemViewModel(T item);

    // 删除item的唯一标示，如果需要删除item，必须实现该方法
    String getRemoveToken();

    // 删除item的类型，如果需要删除item，必须实现该方法
    Class getItemViewModelClass();

    // 插入item的唯一标示，如果需要插入item，必须实现该方法并使用Messenger发送InsertMsg类型的消息
    String getInsertToken();

    String getErrorHint();

}
