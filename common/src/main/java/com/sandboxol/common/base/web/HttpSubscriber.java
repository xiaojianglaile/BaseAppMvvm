package com.sandboxol.common.base.web;

import com.sandboxol.common.config.HttpCode;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class HttpSubscriber<T, R extends HttpResponse<T>> extends Subscriber<R> {

    private OnResponseListener<T> listener;

    public HttpSubscriber(OnResponseListener<T> listener) {
        this.listener = listener;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (listener != null) {
            if (e instanceof HttpException) {
                int error = ((HttpException) e).code();
                if (error == HttpCode.AUTH_FAILED) {
                    //TODO 处理认证失败操作
                } else {
                    listener.onServerError(error);
                }
            }
        }
    }

    @Override
    public void onNext(R response) {
        if (listener != null) {
            if (response.getCode() == HttpCode.SUCCESS) {
                listener.onSuccess(response.getData());
            } else {
                listener.onError(response.getCode(), response.getMsg());
            }
        }
    }

}
