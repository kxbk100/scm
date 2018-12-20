package com.scm.model;


public class OtherModel {
    private int id;
    private float value;
    private int status;
    private String src;

    private PointModel pointModel;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }


    public PointModel getPointModel() {
        return pointModel;
    }

    public void setPointModel(PointModel pointModel) {
        this.pointModel = pointModel;
    }

}
