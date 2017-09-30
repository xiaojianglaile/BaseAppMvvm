package com.sandboxol.common.binding.model;

import com.sandboxol.common.binding.viewmodel.IListItemViewModel;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public interface IListModel<T> extends IModel {

    void onBind(ItemView itemView, int position, IListItemViewModel<T> item);

    /**
     * Item类型的数量
     *
     * @return view type count
     */
    int getViewTypeCount();

    IListItemViewModel<T> getItemViewModel(T item);

    /**
     * 删除item/items的唯一标示，如果需要删除item/items，必须实现该方法并使用Messenger发送RemoveMsg类型的消息
     * RemoveMsg data use IListItemViewModel or List<IListItemViewModel>
     *
     * @return remove token
     */
    String getRemoveToken();

    /**
     * 插入item/items的唯一标示，如果需要插入item/items，必须实现该方法并使用Messenger发送InsertMsg类型的消息
     * InsertMsg data use T or List<T>
     *
     * @return insert token
     */
    String getInsertToken();

    /**
     * 替换items的唯一标示，如果需要插入items，必须实现该方法并使用Messenger发送ReplaceMsg类型的消息
     * ReplaceMsg data use List<T>
     *
     * @return replace token
     */
    String getReplaceToken();

    /**
     * 错误提示，比如网络错误或者空列表
     *
     * @return empty list hint
     */
    String getErrorHint();

}
