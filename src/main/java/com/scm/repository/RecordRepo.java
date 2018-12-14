package com.scm.repository;

import com.scm.entity.RecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepo extends JpaRepository<RecordsEntity,Integer> {
    List<RecordsEntity> findAll();
    
    @Query(value = "SELECT * FROM records WHERE userId=?1",nativeQuery = true)
    List<RecordsEntity> findByUserId(int id);
}
