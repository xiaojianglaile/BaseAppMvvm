package com.jimmy.baseapp.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 2017/3/16.
 */
public class ActivitiesConfig {
    private int activityId;
    private int distance;
    private boolean isLogin;
    private String url;
    private int level;
    private int versionSwitch;
    private List<String> country;
    private List<String> unShowCountry;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean getLogin() {
        return isLogin;
    }

    public void setLogin(Boolean login) {
        isLogin = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getVersionSwitch() {
        return versionSwitch;
    }

    public void setVersionSwitch(int versionSwitch) {
        this.versionSwitch = versionSwitch;
    }

    private boolean versionSwitch() {
        return false;
    }

    private List<String> getCountry() {
        if (country == null)
            country = new ArrayList<>();
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    private List<String> getUnShowCountry() {
        if (unShowCountry == null)
            unShowCountry = new ArrayList<>();
        return unShowCountry;
    }

    public void setUnShowCountry(List<String> unShowCountry) {
        this.unShowCountry = unShowCountry;
    }

    public boolean isCountryShow() {
        return false;
    }

    public boolean isVisitorShow() {
        return isCountryShow() && getLogin() && versionSwitch() && getUrl() != null;
    }
}
