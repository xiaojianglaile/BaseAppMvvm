package com.sandboxol.common.binding.adapter;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

import com.sandboxol.common.command.ReplyCommand;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class SwipeRefreshLayoutBindingAdapters {

    @BindingAdapter({"onRefreshCommand"})
    public static void onRefreshCommand(SwipeRefreshLayout swipeRefreshLayout, final ReplyCommand onRefreshCommand) {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (onRefreshCommand != null) {
                onRefreshCommand.execute();
            }
        });
    }

    @BindingAdapter({"setRefreshing"})
    public static void setRefreshing(SwipeRefreshLayout swipeRefreshLayout, boolean isRefreshing) {
        swipeRefreshLayout.setRefreshing(isRefreshing);
    }

}
