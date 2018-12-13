package com.scm.model;

import java.util.Date;

/*
{
[
Record->id:?,//提交记录id
Type:? //提交类型
realName:?//userId(session里面的)->users->name
date:?,//上传日期

recordId:?,//表中的id(下面有了)
name:?,//提交类型表中的name(下面有了)
status:?,//审核状态(下面有了)
src:?,//文件地址(下面有了)
[title:?,
Author:?,
]/[]/[]/[src]
]}
 */
public class AMaterialGetModel {
    private Integer id;
    private Integer type;
    private String realName;
    private Date date;
    private Object typeModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object getTypeModel() {
        return typeModel;
    }

    public void setTypeModel(Object typeModel) {
        this.typeModel = typeModel;
    }
}
