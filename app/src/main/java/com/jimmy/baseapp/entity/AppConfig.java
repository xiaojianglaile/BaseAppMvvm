package com.jimmy.baseapp.entity;

import java.util.List;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class AppConfig {


    private Poster poster;
    private Notice notice;
    private int videoAdTimes;
    private long antiCheatingLimitTime;
    private boolean isShow3thAd;
    private boolean isShow12thAd;
    private boolean openDiamondBox;
    private boolean isStatisticsAPI;
    private boolean isShowAllHonorWall;
    private boolean isOpenAntiCheating;
    private boolean isShowAppUpdateDialog;
    private boolean isOpenEmergenciesMechanism;

    private String playIntroduceUrl;
    private List<GameVersionItem> gameVersion;
    private List<String> supportFloatWindowGameVersions;
    private ActivitiesConfig activitiesConfig;
    private List<String> payMethods;
    private boolean isShowAd;
    private boolean subscribe;

    public List<String> getPayMethods() {
        return this.payMethods;
    }

    public void setPayMethods(List<String> methods) {
        this.payMethods = methods;
    }

    public Poster getPoster() {
        return poster;
    }

    public Notice getNotice() {
        return notice;
    }

    public boolean isShowAppUpdateDialog() {
        return isShowAppUpdateDialog;
    }

    public List<GameVersionItem> getGameVersion() {
        return gameVersion;
    }

    public boolean isShow3thAd() {
        return isShow3thAd;
    }

    public boolean isShow12thAd() {
        return isShow12thAd;
    }

    public int getVideoAdTimes() {
        return videoAdTimes == 0 ? 1 : videoAdTimes;
    }

    public void setVideoAdTimes(int videoAdTimes) {
        this.videoAdTimes = videoAdTimes;
    }

    public boolean getOpenDiamondBox() {
        return openDiamondBox;
    }

//    public int getShowDiamondBoxTimes() {
//        return showDiamondBoxTimes;
//    }

    public String getPlayIntroduceUrl() {
        return playIntroduceUrl;
    }

    public boolean isOpenAntiCheating() {
        return isOpenAntiCheating;
    }

    public boolean isStatisticsAPI() {
        return isStatisticsAPI;
    }

    public long getAntiCheatingLimitTime() {
        return antiCheatingLimitTime;
    }

    public List<String> getSupportFloatWindowGameVersions() {
        return supportFloatWindowGameVersions;
    }

    public boolean isOpenEmergenciesMechanism() {
        return isOpenEmergenciesMechanism;
    }

    public ActivitiesConfig getActivitiesConfig() {
        return activitiesConfig;
    }

    public boolean isShowAllHonorWall() {
        return isShowAllHonorWall;
    }

    public boolean isShowAd() {
        return isShowAd;
    }

    public void setShowAd(boolean showAd) {
        isShowAd = showAd;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }
}
