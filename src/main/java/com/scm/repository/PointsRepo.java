package com.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.PointsEntity;
public interface PointsRepo extends JpaRepository<PointsEntity,Integer> {

}
