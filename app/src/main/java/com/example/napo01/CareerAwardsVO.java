package com.example.napo01;

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.TextView;


public class CareerAwardsVO {

    private Drawable award_img;
    private String name;
    private String inst;
    private String date;



    public CareerAwardsVO(Drawable award_img, String name, String inst, String date) {
        this.award_img = award_img;
        this.name = name;
        this.inst = inst;
        this.date = date;
    }

    public Drawable getAward_img() {
        return award_img;
    }

    public void setAward_img(Drawable award_img) {
        this.award_img = award_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
