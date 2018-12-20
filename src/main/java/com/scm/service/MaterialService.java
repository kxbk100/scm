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
    int saveOther(OtherModel model);
    int saveTeacher(TeacherModel model);
    int saveItem(ItemModel model);
    int savePaper(PaperModel model);
    void saveRecord(int userId,int type,int recordId);
    void updateRecordDate(int id);
    void updateStatus(int id,int type,int status);
    void updateContent(int type,int id);
}
