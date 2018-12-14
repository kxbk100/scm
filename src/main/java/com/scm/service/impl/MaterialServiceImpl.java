package com.scm.service.impl;

import com.scm.entity.*;
import com.scm.model.*;
import com.scm.repository.*;
import com.scm.service.MaterialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    RecordRepo recordDao;
    @Autowired
    OtherRepo otherDao;
    @Autowired
    PaperRepo paperDao;
    @Autowired
    TeacherRepo teacherDao;
    @Autowired
    ItemRepo itemDao;

    @Override
    public List<RecordModel> findAllRecord() {
        List<RecordsEntity> entities=recordDao.findAll();
        List<RecordModel> recordModels=new ArrayList<>();
        for(RecordsEntity entity:entities){
            RecordModel model=new RecordModel();
            BeanUtils.copyProperties(entity,model);
            model.setRealName(entity.getUsersEntity().getName());
            recordModels.add(model);
        }
        return recordModels;
    }

    @Override
    public List<RecordModel> findByUserId(int id) {
        List<RecordsEntity> entities=recordDao.findByUserId(id);
        List<RecordModel> recordModels=new ArrayList<>();
        for(RecordsEntity entity:entities){
            RecordModel model=new RecordModel();
            BeanUtils.copyProperties(entity,model);
            recordModels.add(model);
        }
        return recordModels;
    }


    @Override
    public OtherModel findOtherById(int id) {
        OtherEntity entity=otherDao.getById(id);
        OtherModel otherModel=new OtherModel();
        PointModel pointModel=new PointModel();
        BeanUtils.copyProperties(entity.getPointsEntity(),pointModel);
        BeanUtils.copyProperties(entity,otherModel);
        otherModel.setPointModel(pointModel);
        return otherModel;
    }

    @Override
    public PaperModel findPaperById(int id) {
        PapersEntity entity=paperDao.getById(id);
        PaperModel model=new PaperModel();
        BeanUtils.copyProperties(entity,model);
        return model;
    }

    @Override
    public TeacherModel findTeacherById(int id) {
        TeachersEntity entity=teacherDao.getById(id);
        TeacherModel model=new TeacherModel();
        BeanUtils.copyProperties(entity,model);
        return model;
    }

    @Override
    public ItemModel findItemById(int id) {
        ItemsEntity entity=itemDao.getById(id);
        ItemModel model=new ItemModel();
        BeanUtils.copyProperties(entity,model);
        return model;
    }

}
