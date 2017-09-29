package com.jimmy.baseapp.entity;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class Friend {

    private long userId;
    private long charm;
    private String cupId;
    private String picUrl;
    private String details;
    private String nickName;

    private boolean black;
    private boolean follow;
    private boolean isFriend;
    private boolean isVip;
    private boolean isSpecial;

    private String alias;
    private String vipExpiredAt;

    private int lv;
    private int vip;
    private int sex;
    private int level;
    private int status;
    private int honorNum;

    private boolean isChecked;

    private int isManager;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCharm() {
        return charm;
    }

    public void setCharm(long charm) {
        this.charm = charm;
    }

    public String getCupId() {
        return cupId;
    }

    public void setCupId(String cupId) {
        this.cupId = cupId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getVipExpiredAt() {
        return vipExpiredAt;
    }

    public void setVipExpiredAt(String vipExpiredAt) {
        this.vipExpiredAt = vipExpiredAt;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHonorNum() {
        return honorNum;
    }

    public void setHonorNum(int honorNum) {
        this.honorNum = honorNum;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getIsManager() {
        return isManager;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
    }
}
