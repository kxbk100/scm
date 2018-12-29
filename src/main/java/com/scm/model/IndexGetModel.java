package com.scm.model;

import java.util.Date;
import java.util.List;

/*
{[user->name
],
[target->id:?,
points->id:?,
second:?中文,
content:?中文
,now:?,
goal:?,
nextgoal:?,
deadline:?,
nextdeadline:?],
...
}

 */
public class IndexGetModel {
    private List<ContentGetModel> contentGetModelList;
    public List<ContentGetModel> getContentGetModelList() {
        return contentGetModelList;
    }

    public void setContentGetModelList(List<ContentGetModel> contentGetModelList) {
        this.contentGetModelList = contentGetModelList;
    }
}
