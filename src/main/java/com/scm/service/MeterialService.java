package com.scm.service;

import com.scm.model.*;

import java.util.List;

public interface MeterialService {
    List<RecordModel> findAllRecord();
    OtherModel findOtherById(int id);
    PaperModel findPaperById(int id);
    TeacherModel findTeacherById(int id);
    ItemModel findItemById(int id);
}
