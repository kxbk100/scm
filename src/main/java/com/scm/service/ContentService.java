package com.scm.service;

import com.scm.model.ContentGetModel;
import com.scm.model.ContentPostModel;
import com.scm.model.IndexGetModel;

import java.util.List;

public interface ContentService {
    IndexGetModel GetIndexData();
    List<ContentGetModel> GetContentlistByFirst(String first);
    List<ContentPostModel> UpdateContent(List<ContentPostModel> contentPostModelList);
}
