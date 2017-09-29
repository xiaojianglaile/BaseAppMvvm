package com.sandboxol.common.binding.model.msg;

/**
 * Created by Jimmy on 2017/9/28 0028.
 */
public class InsertMsg {

    public enum INSERT_MODE {
        FIRST,
        END,
        INDEX
    }

    private int index = 0;
    private Object data;
    private INSERT_MODE mode;

    public static InsertMsg createFirst(Object data) {
        return InsertMsg.create(data, 0, INSERT_MODE.FIRST);
    }

    public static InsertMsg createEnd(Object data) {
        return InsertMsg.create(data, 0, INSERT_MODE.END);
    }

    public static InsertMsg createIndex(Object data, int index) {
        return InsertMsg.create(data, index, INSERT_MODE.INDEX);
    }

    private static InsertMsg create(Object data, int index, INSERT_MODE mode) {
        InsertMsg msg = new InsertMsg();
        msg.setData(data);
        msg.setIndex(index);
        msg.setMode(mode);
        return msg;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public INSERT_MODE getMode() {
        return mode;
    }

    public void setMode(INSERT_MODE mode) {
        this.mode = mode;
    }
}
