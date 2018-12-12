package com.scm.service;

import com.scm.model.ContentGetModel;

import java.util.List;

public interface ContentService {
    List<ContentGetModel> GetContentlistByFirst(String first);
}
