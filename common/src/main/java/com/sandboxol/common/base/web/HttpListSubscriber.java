package com.sandboxol.common.base.web;

import com.sandboxol.common.config.HttpCode;

import java.util.List;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public class HttpListSubscriber<R extends HttpResponse<List<D>>, D> extends Subscriber<R> {

    private OnResponseListener<R> listener;

    public HttpListSubscriber(OnResponseListener<R> listener) {
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
            } else {
                listener.onServerError(0);
            }
        }
    }

    @Override
    public void onNext(R response) {
        if (listener != null) {
            listener.onSuccess(response);
        }
    }

}
