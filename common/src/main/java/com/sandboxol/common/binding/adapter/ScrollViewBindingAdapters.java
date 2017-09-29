package com.sandboxol.common.binding.adapter;

import android.databinding.BindingAdapter;
import android.support.v4.widget.NestedScrollView;
import android.widget.ScrollView;

import com.sandboxol.common.command.ReplyCommand;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class ScrollViewBindingAdapters {

    @BindingAdapter({"onScrollChangeCommand"})
    public static void onScrollChangeCommand(final NestedScrollView nestedScrollView, final ReplyCommand<NestScrollDataWrapper> onScrollChangeCommand) {
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (onScrollChangeCommand != null) {
                    onScrollChangeCommand.execute(new NestScrollDataWrapper(scrollX, scrollY, oldScrollX, oldScrollY));
                }
            }
        });
    }

    @BindingAdapter({"onScrollChangeCommand"})
    public static void onScrollChangeCommand(final ScrollView scrollView, final ReplyCommand<ScrollDataWrapper> onScrollChangeCommand) {
        scrollView.getViewTreeObserver().addOnScrollChangedListener(() -> {
            if (onScrollChangeCommand != null) {
                onScrollChangeCommand.execute(new ScrollDataWrapper(scrollView.getScaleX(), scrollView.getScrollY()));
            }
        });

    }

    public static class ScrollDataWrapper {
        public float scrollX;
        public float scrollY;

        public ScrollDataWrapper(float scrollX, float scrollY) {
            this.scrollX = scrollX;
            this.scrollY = scrollY;
        }
    }

    public static class NestScrollDataWrapper {
        public int scrollX;
        public int scrollY;
        public int oldScrollX;
        public int oldScrollY;

        public NestScrollDataWrapper(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            this.scrollX = scrollX;
            this.scrollY = scrollY;
            this.oldScrollX = oldScrollX;
            this.oldScrollY = oldScrollY;
        }
    }

}
