package com.sandboxol.common.binding.adapter;

import android.databinding.BindingAdapter;
import android.view.MotionEvent;
import android.view.View;

import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.command.ResponseCommand;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class ViewBindingAdapters {

    @BindingAdapter({"clickCommand"})
    public static void clickCommand(View view, final ReplyCommand clickCommand) {
        view.setOnClickListener(v -> {
            if (clickCommand != null) {
                clickCommand.execute();
            }
        });
    }

    @BindingAdapter({"requestFocus"})
    public static void requestFocusCommand(View view, final Boolean needRequestFocus) {
        if (needRequestFocus) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } else {
            view.clearFocus();
        }
    }

    @BindingAdapter({"onFocusChangeCommand"})
    public static void onFocusChangeCommand(View view, final ReplyCommand<Boolean> onFocusChangeCommand) {
        view.setOnFocusChangeListener((v, hasFocus) -> {
            if (onFocusChangeCommand != null) {
                onFocusChangeCommand.execute(hasFocus);
            }
        });
    }

    @BindingAdapter({"onTouchCommand"})
    public static void onTouchCommand(View view, final ResponseCommand<MotionEvent, Boolean> onTouchCommand) {
        view.setOnTouchListener((v, event) -> {
            if (onTouchCommand != null) {
                return onTouchCommand.execute(event);
            }
            return false;
        });
    }

}
