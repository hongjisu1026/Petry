package com.petry.diary.dto;

import java.sql.Timestamp;

public class AlbumDTO {
    int aId;
    int dId;
    String aName;
    String aOriName;
    String aPath;
    String aType;
    long aSize;
    Timestamp aUploadTime;
    int aThumbnail;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaOriName() {
        return aOriName;
    }

    public void setaOriName(String aOriName) {
        this.aOriName = aOriName;
    }

    public String getaPath() {
        return aPath;
    }

    public void setaPath(String aPath) {
        this.aPath = aPath;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public long getaSize() {
        return aSize;
    }

    public void setaSize(long aSize) {
        this.aSize = aSize;
    }

    public Timestamp getaUploadTime() {
        return aUploadTime;
    }

    public void setaUploadTime(Timestamp aUploadTime) {
        this.aUploadTime = aUploadTime;
    }

    public int getaThumbnail() {
        return aThumbnail;
    }

    public void setaThumbnail(int aThumbnail) {
        this.aThumbnail = aThumbnail;
    }
}
