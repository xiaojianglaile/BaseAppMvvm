package com.sandboxol.common.utils;

import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.config.HttpCode;

/**
 * Created by Jimmy on 2017/9/29 0029.
 */
public class ResponseUtils {

    public static <D> HttpResponse<D> success(D data) {
        return create(HttpCode.SUCCESS, null, data);
    }

    public static <D> HttpResponse<D> failed(String msg) {
        return create(HttpCode.FAILED, msg, null);
    }

    public static <D> HttpResponse<D> create(int code, String msg, D data) {
        HttpResponse<D> response = new HttpResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

}
