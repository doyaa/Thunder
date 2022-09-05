package com.example.napo01;

import android.graphics.drawable.Drawable;

public class CareerInternVO {

    private Drawable intern_img;
    private String internName;
    private String internPer;
    private String internAct;

    public CareerInternVO(Drawable intern_img,String internName, String internPer, String internAct) {
        this.intern_img = intern_img;
        this.internName = internName;
        this.internPer = internPer;
        this.internAct = internAct;
    }

    public Drawable getIntern_img() {
        return intern_img;
    }

    public void setIntern_img(Drawable intern_img) {
        this.intern_img = intern_img;
    }

    public String getInternName() {
        return internName;
    }

    public void setInternName(String internName) {
        this.internName = internName;
    }

    public String getInternPer() {
        return internPer;
    }

    public void setInternPer(String internPer) {
        this.internPer = internPer;
    }

    public String getInternAct() {
        return internAct;
    }

    public void setInternAct(String internAct) {
        this.internAct = internAct;
    }
}
