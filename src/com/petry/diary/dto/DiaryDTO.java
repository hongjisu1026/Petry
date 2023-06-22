package com.petry.diary.dto;

import java.sql.Timestamp;

public class DiaryDTO {
    int dId;
    int uId;
    String dTitle;
    String dContent;
    Timestamp dUploadTime;

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getdTitle() {
        return dTitle;
    }

    public void setdTitle(String dTitle) {
        this.dTitle = dTitle;
    }

    public String getdContent() {
        return dContent;
    }

    public void setdContent(String dContent) {
        this.dContent = dContent;
    }

    public Timestamp getdUploadTime() {
        return dUploadTime;
    }

    public void setdUploadTime(Timestamp dUploadTime) {
        this.dUploadTime = dUploadTime;
    }
}
