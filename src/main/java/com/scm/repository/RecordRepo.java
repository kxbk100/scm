package com.scm.repository;

import com.scm.entity.RecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepo extends JpaRepository<RecordsEntity,Integer> {
    List<RecordsEntity> findAll();
}
