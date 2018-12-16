package com.scm.service.impl;

import com.scm.entity.NoticesEntity;
import com.scm.model.NoticeModel;
import com.scm.repository.NoticeRepo;
import com.scm.service.NoticeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeRepo noticeDao;
    @Override
    public List<NoticeModel> getAllNotice() {
        List<NoticeModel> models=new ArrayList<>();
        List<NoticesEntity> entities=noticeDao.findAllOrOrderByDate();
        for (NoticesEntity entity:entities){
            NoticeModel model=new NoticeModel();
            BeanUtils.copyProperties(entity,model);
            models.add(model);
        }
        return models;
    }

    @Override
    public void save(NoticeModel model) {
        NoticesEntity entity=new NoticesEntity();
        BeanUtils.copyProperties(model,entity);
        noticeDao.save(entity);
    }

    @Override
    public void deleteById(int id) {
        noticeDao.deleteById(id);
    }
}
