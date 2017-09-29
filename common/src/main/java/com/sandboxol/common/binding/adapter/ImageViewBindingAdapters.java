package com.sandboxol.common.binding.adapter;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.sandboxol.common.command.ReplyCommand;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class ImageViewBindingAdapters {

    @BindingAdapter(value = {"uri", "placeImageRes", "failedImageRes", "onSuccessCommand"}, requireAll = false)
    public static void loadImage(final ImageView iv, String uri,
                                 int placeImageRes,
                                 int failedImageRes,
                                 final ReplyCommand<GlideDrawable> onSuccessCommand) {
        if (placeImageRes != 0)
            iv.setImageResource(placeImageRes);
        if (!TextUtils.isEmpty(uri)) {
            if (failedImageRes == 0 && placeImageRes != 0)
                failedImageRes = placeImageRes;
            int finalFailedImageRes = failedImageRes;
            Glide.with(iv.getContext()).load(uri).crossFade().listener(new RequestListener<String, GlideDrawable>() {

                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    if (finalFailedImageRes != 0)
                        iv.setImageResource(finalFailedImageRes);
                    return true;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    if (onSuccessCommand != null)
                        onSuccessCommand.execute(resource);
                    return false;
                }
            }).into(iv);
        }
    }


}
