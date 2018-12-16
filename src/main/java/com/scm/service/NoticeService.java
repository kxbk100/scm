package com.scm.service;

import com.scm.model.NoticeModel;

import java.util.List;

public interface NoticeService {
    List<NoticeModel> getAllNotice();
    void save(NoticeModel model);
    void deleteById(int id);
}
