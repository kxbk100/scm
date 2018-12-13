package com.scm.model;

import java.util.Date;

/*{[
Record->id:?,//在record的id
date:?,//上传日期
type:?//表的类型

recordId:?,//类型表中的id(下面有了)
name:?,//表中的name(下面有了)
src:?,//文件位置(下面有了)
status:?,//材料提交状态(下面有了)

[title:?,
Author:?,
]/[]/[]/[src]
]
}

 */
public class TMaterialGetModel {
    private Integer id;
    private Date date;
    private Integer type;
    private Object typeModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getTypeModel() {
        return typeModel;
    }

    public void setTypeModel(Object typeModel) {
        this.typeModel = typeModel;
    }

}
