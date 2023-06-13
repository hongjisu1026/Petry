package com.petry.profile.dto;

public class ProfileDTO {
    private int pId;
    private int uId;
    private int piId;
    private String pName;
    private String pBirth;
    private String pSex;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getPiId() {
        return piId;
    }

    public void setPiId(int piId) {
        this.piId = piId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpBirth() {
        return pBirth;
    }

    public void setpBirth(String pBirth) {
        this.pBirth = pBirth;
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex;
    }
}
