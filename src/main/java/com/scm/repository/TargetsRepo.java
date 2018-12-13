package com.scm.repository;

import com.scm.entity.TargetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TargetsRepo extends JpaRepository<TargetsEntity,Integer> {
    List<TargetsEntity> findByFirst(String first);
}
