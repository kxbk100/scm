package com.scm.service.impl;

import com.scm.entity.*;
import com.scm.model.*;
import com.scm.repository.*;
import com.scm.service.MaterialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    PointsRepo pointDao;

    @Override
    public List<RecordModel> findAllRecord() {
        List<RecordsEntity> entities=recordDao.findAllByOrderByDateDesc();
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

    @Override
    public int saveOther(OtherModel model) {
        OtherEntity otherEntity=new OtherEntity();
        PointsEntity pointsEntity=new PointsEntity();
        pointsEntity.setId(model.getPointModel().getId());
        BeanUtils.copyProperties(model,otherEntity);
        otherEntity.setPointsEntity(pointsEntity);
        return otherDao.saveAndFlush(otherEntity).getId();
    }

    @Override
    public int saveTeacher(TeacherModel model) {
        TeachersEntity teachersEntity=new TeachersEntity();
        BeanUtils.copyProperties(model,teachersEntity);
        return teacherDao.saveAndFlush(teachersEntity).getId();
    }

    @Override
    public int saveItem(ItemModel model) {
        ItemsEntity itemsEntity=new ItemsEntity();
        BeanUtils.copyProperties(model,itemsEntity);
        return itemDao.saveAndFlush(itemsEntity).getId();
    }

    @Override
    public int savePaper(PaperModel model) {
        PapersEntity papersEntity=new PapersEntity();
        BeanUtils.copyProperties(model,papersEntity);
        return paperDao.saveAndFlush(papersEntity).getId();
    }

    @Override
    public void saveRecord(int userId,int type,int recordId) {
        RecordsEntity recordsEntity=new RecordsEntity();
        UsersEntity usersEntity=new UsersEntity();
        usersEntity.setId(userId);
        recordsEntity.setUsersEntity(usersEntity);
        recordsEntity.setDate(new Date(System.currentTimeMillis()));
        recordsEntity.setType(type);
        recordsEntity.setRecordId(recordId);
        recordDao.save(recordsEntity);
    }

    @Override
    public void updateRecordDate(int id) {
        recordDao.updateDate(new Date(System.currentTimeMillis()),id);
    }

    /**
     *
     * @param id 对象在各自表中的id
     * @param type 对应的对象的类型Other 0，Teacher 1，Item 2，Paper 3
     * @param status 修改的状态
     */
    @Override
    public void updateStatus(int id, int type, int status) {
        switch (type){
            case 0:
                OtherEntity otherEntity=otherDao.getById(id);
                otherEntity.setStatus(status);
                otherDao.save(otherEntity);
                break;
            case 1:
                TeachersEntity teachersEntity=teacherDao.getById(id);
                teachersEntity.setStatus(status);
                teacherDao.save(teachersEntity);
                break;
            case 2:
                ItemsEntity itemsEntity=itemDao.getById(id);
                itemsEntity.setStatus(status);
                itemDao.save(itemsEntity);
                break;
            case 3:
                PapersEntity papersEntity=paperDao.getById(id);
                papersEntity.setStatus(status);
                paperDao.save(papersEntity);
                break;
        }
    }

    /**
     * 更新观测点
     * 对应的对象的类型Other 0，Teacher 1，Item 2，Paper 3
     * @param type
     */
    @Override
    public void updateContent(int type,int id) {
        switch (type){
            case 0:
                OtherEntity otherEntity=otherDao.getById(id);
                update(otherEntity.getPointsEntity().getId(),otherEntity.getValue());
                break;
            case 1:
                TeachersEntity teachersEntity=teacherDao.getById(id);
                int teacherCount=teacherDao.countAll();

                //教师总人数
                update(1);

                //博士占比
                float eduPc=((float) teacherDao.countByEdu(0))/teacherCount;
                update(4,eduPc);

                //35周岁以下占比
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date=format.parse("1983-1-1");
                    float birthPc=((float)teacherDao.countByAge(date))/teacherCount;
                    update(5,birthPc);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //国家级
                if(teachersEntity.getRank()==0){
                    update(2);
                    //省级
                } else if(teachersEntity.getRank()==1){
                    update(3);
                }
                //重要学术机构担任职位人数
                if(teachersEntity.getIsImportant()==1){
                    update(46);
                }
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    /**
     * 只需+1的数据更新方法
     * @param id
     */
    private void update(int id){
        update(id,-1);
    }

    /**
     * 直接更新数据的更新方法
     * @param id
     * @param data
     */
    private void update(int id,float data){
        PointsEntity pointsEntity;
        if(data==-1){
            pointsEntity=pointDao.getById(id);
            pointsEntity.updateNow();
            pointDao.saveAndFlush(pointsEntity);
        }else {
            pointsEntity=pointDao.getById(id);
            pointsEntity.updateNowWithData(data);
            pointDao.saveAndFlush(pointsEntity);
        }
    }
}
