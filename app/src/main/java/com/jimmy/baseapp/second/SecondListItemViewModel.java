package com.jimmy.baseapp.second;

import android.content.Context;

import com.jimmy.baseapp.config.MessageToken;
import com.jimmy.baseapp.entity.ItemData;
import com.jimmy.baseapp.three.ThreeFragment;
import com.sandboxol.common.binding.model.msg.RemoveMsg;
import com.sandboxol.common.binding.model.msg.ReplaceMsg;
import com.sandboxol.common.binding.viewmodel.IListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.TemplateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class SecondListItemViewModel extends IListItemViewModel<ItemData> {

    public SecondListItemViewModel(Context context, ItemData item) {
        super(context, item);
    }

    @Override
    public ItemData getItem() {
        return item;
    }

    public ReplyCommand onItemClickCommand = new ReplyCommand(this::onClick);

    protected void onClick() {
        item.setTitle("change");
//        Messenger.getDefault().send(RemoveMsg.createItem(this), MessageToken.SECOND_ITEM_REMOVE_TOKEN); // 删除操作
//        Messenger.getDefault().send(RemoveMsg.createIndex(0), MessageToken.SECOND_ITEM_REMOVE_TOKEN); // 删除操作
        List<Object> models = new ArrayList<>();
        models.add(item);
        Messenger.getDefault().send(ReplaceMsg.create(models), MessageToken.SECOND_ITEM_REPLACE_TOKEN);
        TemplateUtils.startTemplate(context, ThreeFragment.class, "Three");
    }
}
