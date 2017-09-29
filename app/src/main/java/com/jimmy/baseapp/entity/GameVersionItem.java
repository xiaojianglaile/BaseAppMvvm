package com.jimmy.baseapp.entity;

/**
 * Created by luoweiyi on 16/2/19.
 */
public class GameVersionItem {

    private String verName;
    private String ver;
    private int id;

    public GameVersionItem(String verName, String ver, int id) {
        this.verName = verName;
        this.ver = ver;
        this.id = id;
    }

    public String getVerName() {
        return verName;
    }

    public void setVerName(String verName) {
        this.verName = verName;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
