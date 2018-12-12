package com.scm.repository;

import com.scm.entity.PointsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PointsRepo extends JpaRepository<PointsEntity,Integer> {
    PointsEntity findByTargetid(Integer targetid);
}
