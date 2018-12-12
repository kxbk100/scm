package com.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.TargetsEntity;

public interface TargetsRepo extends JpaRepository<TargetsEntity,Integer> {

}
