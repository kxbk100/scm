package com.scm.repository;

import java.sql.Date;

public class PointModel {
    private int id;
    private String content;
    private Float now;
    private Float goal;
    private Date deadline;
    private Float nextgoal;
    private Date nextdeadline;
    private Integer targetid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getNow() {
        return now;
    }

    public void setNow(Float now) {
        this.now = now;
    }

    public Float getGoal() {
        return goal;
    }

    public void setGoal(Float goal) {
        this.goal = goal;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Float getNextgoal() {
        return nextgoal;
    }

    public void setNextgoal(Float nextgoal) {
        this.nextgoal = nextgoal;
    }

    public Date getNextdeadline() {
        return nextdeadline;
    }

    public void setNextdeadline(Date nextdeadline) {
        this.nextdeadline = nextdeadline;
    }

    public Integer getTargetid() {
        return targetid;
    }

    public void setTargetid(Integer targetid) {
        this.targetid = targetid;
    }
}
