package com.jimmy.baseapp.entity;

import java.util.HashMap;

/**
 * Created by luoweiyi on 15/12/25.
 */
public class Poster {
    private long id;
    private long time;
    private String url;
    private boolean isOpen;

    private HashMap<String, String> imgs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public HashMap<String, String> getImgs() {
        return imgs;
    }

    public void setImgs(HashMap<String, String> imgs) {
        this.imgs = imgs;
    }
}
