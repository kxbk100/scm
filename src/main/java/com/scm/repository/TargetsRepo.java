package com.scm.repository;

import com.scm.entity.TargetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TargetsRepo extends JpaRepository<TargetsEntity,Integer> {
    List<TargetsEntity> findByFirst(String first);
}
