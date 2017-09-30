package com.sandboxol.common.binding.model.msg;

import java.util.List;

/**
 * Created by Jimmy on 2017/9/30 0030.
 */
public class RemoveMsg {

    public enum REMOVE_MODE {
        CLEAR,
        ITEM,
        LIST,
        INDEX
    }

    private int index;
    private REMOVE_MODE mode;
    private Object data;

    public static RemoveMsg createClear() {
        return create(null, 0, REMOVE_MODE.CLEAR);
    }

    public static RemoveMsg createItem(Object data) {
        return create(data, 0, REMOVE_MODE.ITEM);
    }

    public static RemoveMsg createIndex(int index) {
        return create(null, index, REMOVE_MODE.INDEX);
    }

    public static RemoveMsg createList(List<Object> list) {
        return create(list, 0, REMOVE_MODE.LIST);
    }

    public static RemoveMsg create(Object data, int index, REMOVE_MODE mode) {
        RemoveMsg msg = new RemoveMsg();
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

    public REMOVE_MODE getMode() {
        return mode;
    }

    public void setMode(REMOVE_MODE mode) {
        this.mode = mode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
