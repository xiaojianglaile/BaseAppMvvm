package com.jimmy.baseapp.main;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.jimmy.baseapp.config.MessageToken;
import com.jimmy.baseapp.entity.ItemData;
import com.jimmy.baseapp.second.SecondActivity;
import com.sandboxol.common.binding.model.msg.InsertMsg;
import com.sandboxol.common.binding.viewmodel.IListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class MainListItemViewModel extends IListItemViewModel<ItemData> {

    public MainListItemViewModel(Context context, ItemData item) {
        super(context, item);
    }

    @Override
    public ItemData getItem() {
        return item;
    }

    public ReplyCommand onItemClickCommand = new ReplyCommand(this::onClick);

    protected void onClick() {
        Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, SecondActivity.class));
        List<ItemData> items = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ItemData item = new ItemData();
            item.setTitle("MainItem:" + i);
            items.add(item);
        }
        Messenger.getDefault().send(InsertMsg.createIndex(items, 2), MessageToken.MAIN_ITEM_INSERT_TOKEN);
    }
}
