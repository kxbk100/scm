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

import java.util.ArrayList;
import java.util.List;

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
               Integer targetId = one.getId();
               PointsEntity pointsEntity = pointsRepo.findByTargetid(targetId);
               ContentGetModel contentGetModel = new ContentGetModel();

               contentGetModel.setPointsId(pointsEntity.getId());
               contentGetModel.setNextgoal(pointsEntity.getNextgoal());
               contentGetModel.setSecond(one.getSecond());
               contentGetModel.setContent(pointsEntity.getContent());
               contentGetModel.setNextgoal(pointsEntity.getNextgoal());
               contentGetModel.setNextdeadline(pointsEntity.getNextdeadline());
               contentGetModel.setGoal(pointsEntity.getGoal());
               contentGetModel.setNextgoal(pointsEntity.getNextgoal());

               contentGetModelList.add(contentGetModel);
           }

        return contentGetModelList;
    }

    @Override
    public List<ContentPostModel> UpdateContent(List<ContentPostModel> contentPostModelList) {
        for (ContentPostModel one:contentPostModelList){
            PointsEntity pointsEntity = pointsRepo.findById(one.getId()).get();
            BeanUtils.copyProperties(pointsEntity,one);
            pointsRepo.save(pointsEntity);
        }
        return contentPostModelList;
    }


    @Override
    public IndexGetModel GetIndexData() {
        IndexGetModel indexGetModel = new IndexGetModel();

        return null;
    }
}
