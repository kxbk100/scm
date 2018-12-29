package com.scm.repository;

import com.scm.entity.PointsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointsRepo extends JpaRepository<PointsEntity,Integer> {
    PointsEntity getById(int id);
}
