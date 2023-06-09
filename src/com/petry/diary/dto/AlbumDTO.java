package com.petry.diary.dto;

import java.io.File;
import java.sql.Timestamp;

public class AlbumDTO {
    private int aId;
    private int dId;
    private int uId;
    private String aName;
    private String aOriName;
    private String aPath;
    private String aType;
    private long aSize;
    private Timestamp aUploadTime;
    private int aThumbnail;
    private File aImg;


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

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
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

    public File getaImg() {
        return aImg;
    }

    public void setaImg(File aImg) {
        this.aImg = aImg;
    }
}
