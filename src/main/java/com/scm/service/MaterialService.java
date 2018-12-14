package com.scm.service;

import com.scm.model.*;

import java.util.List;

public interface MaterialService {
    List<RecordModel> findAllRecord();
    List<RecordModel> findByUserId(int id);
    OtherModel findOtherById(int id);
    PaperModel findPaperById(int id);
    TeacherModel findTeacherById(int id);
    ItemModel findItemById(int id);
}
