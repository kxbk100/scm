package com.scm.service.impl;

import com.scm.entity.PointsEntity;
import com.scm.entity.TargetsEntity;
import com.scm.model.ContentGetModel;
import com.scm.model.ContentPostModel;
import com.scm.model.IndexGetModel;
import com.scm.repository.PointsRepo;
import com.scm.repository.TargetsRepo;
import com.scm.service.ContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@Repository
public class ContentServiceImpl implements ContentService {
    private final PointsRepo pointsRepo;
    private final TargetsRepo targetsRepo;

    @Autowired
    public ContentServiceImpl(PointsRepo pointsRepo, TargetsRepo targetsRepo) {
        this.pointsRepo = pointsRepo;
        this.targetsRepo = targetsRepo;
    }


    public List<ContentGetModel> GetContentlistByFirst(String first) {
        List<ContentGetModel> contentGetModelList = new ArrayList<>();
        List<TargetsEntity> targetsEntityList = targetsRepo.findByFirst(first);
           for (TargetsEntity one:targetsEntityList) {
               List<PointsEntity> pointsEntityList = one.getPointsEntityList();
               for (PointsEntity pointsEntity:pointsEntityList){
                   ContentGetModel contentGetModel = new ContentGetModel();
                   BeanUtils.copyProperties(pointsEntity,contentGetModel);

                   contentGetModel.setSecond(one.getSecond());
                   contentGetModel.setPointsId(pointsEntity.getId());
                   contentGetModel.setTargetId(one.getId());

                   contentGetModelList.add(contentGetModel);
               }
           }

        return contentGetModelList;
    }

    @Override
    public List<ContentPostModel> UpdateContent(List<ContentPostModel> contentPostModelList) {
        for (ContentPostModel one:contentPostModelList){
            if(pointsRepo.findById(one.getId()).isPresent()){
                PointsEntity pointsEntity = pointsRepo.findById(one.getId()).get();
                BeanUtils.copyProperties(one,pointsEntity);
                pointsRepo.save(pointsEntity);
            }
        }
        return contentPostModelList;
    }


    @Override
    public IndexGetModel GetIndexData() {
        IndexGetModel indexGetModel = new IndexGetModel();
        List<ContentGetModel> contentGetModelList = new ArrayList<>();
        List<TargetsEntity> targetsEntityList = targetsRepo.findAll();
        for (TargetsEntity one:targetsEntityList) {
            List<PointsEntity> pointsEntityList = one.getPointsEntityList();
            for (PointsEntity pointsEntity:pointsEntityList){
                ContentGetModel contentGetModel = new ContentGetModel();
                BeanUtils.copyProperties(pointsEntity,contentGetModel);

                contentGetModel.setSecond(one.getSecond());
                contentGetModel.setPointsId(pointsEntity.getId());
                contentGetModel.setTargetId(one.getId());

                contentGetModelList.add(contentGetModel);
            }
        }
        indexGetModel.setContentGetModelList(contentGetModelList);

        return indexGetModel;
    }
}
