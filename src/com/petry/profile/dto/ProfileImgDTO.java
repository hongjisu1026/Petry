package com.petry.profile.dto;

import java.io.File;

public class ProfileImgDTO {
    private int piId;
    private String piName;
    private String piOriName;
    private String piPath;
    private String piType;
    private long piSize;
    private File piImg;


    public int getPiId() {
        return piId;
    }

    public void setPiId(int piId) {
        this.piId = piId;
    }

    public String getPiName() {
        return piName;
    }

    public void setPiName(String piName) {
        this.piName = piName;
    }

    public String getPiOriName() {
        return piOriName;
    }

    public void setPiOriName(String piOriName) {
        this.piOriName = piOriName;
    }

    public String getPiPath() {
        return piPath;
    }

    public void setPiPath(String piPath) {
        this.piPath = piPath;
    }

    public String getPiType() {
        return piType;
    }

    public void setPiType(String piType) {
        this.piType = piType;
    }

    public long getPiSize() {
        return piSize;
    }

    public void setPiSize(long piSize) {
        this.piSize = piSize;
    }

    public File getPiImg() {
        return piImg;
    }

    public void setPiImg(File piImg) {
        this.piImg = piImg;
    }
}
