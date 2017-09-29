package com.jimmy.baseapp.entity;

import java.util.Map;

/**
 * Created by luoweiyi on 16/1/5.
 */
public class Notice {

    private String msg;
    private String title;

    private long stopTime;
    private long sendTime;
    private long startTime;
    private boolean isLook;

    private String notice;
    //version code 455支持
    private Map<String, String> langMap;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public boolean isLook() {
        return isLook;
    }

    public void setIsLook(boolean isLook) {
        this.isLook = isLook;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
