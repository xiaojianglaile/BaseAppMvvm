package com.sandboxol.common.binding.model.msg;

import java.util.List;

/**
 * Created by Jimmy on 2017/9/30 0030.
 */
public class ReplaceMsg {

    public static ReplaceMsg create(List<Object> data) {
        ReplaceMsg msg = new ReplaceMsg();
        msg.setData(data);
        return msg;
    }

    private List<Object> data;

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
