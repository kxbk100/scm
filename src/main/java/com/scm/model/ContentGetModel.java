package com.scm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/*
{
[points->id：？，
second:？中文，
content：？中文，
now：？，
goal：？，
nextgoal:?,
deadline:?,
nextdeadline:?],…
}
 */
public class ContentGetModel {
    private Integer targetId;//为了与欢迎页中返回的数据结构相同添加了此属性
    private Integer pointsId;
    private String second;
    private String content;
    private Float now;
    private Float goal;
    private Float nextgoal;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date deadline;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date nextdeadline;

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getPointsId() {
        return pointsId;
    }

    public void setPointsId(Integer pointsId) {
        this.pointsId = pointsId;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
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

    public Float getNextgoal() {
        return nextgoal;
    }

    public void setNextgoal(Float nextgoal) {
        this.nextgoal = nextgoal;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getNextdeadline() {
        return nextdeadline;
    }

    public void setNextdeadline(Date nextdeadline) {
        this.nextdeadline = nextdeadline;
    }
}
