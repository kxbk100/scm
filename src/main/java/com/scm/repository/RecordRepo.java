package com.scm.repository;

import com.scm.entity.RecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RecordRepo extends JpaRepository<RecordsEntity,Integer> {
    List<RecordsEntity> findAllByOrderByDateDesc();
    
    @Query(value = "SELECT * FROM records WHERE userId=?1",nativeQuery = true)
    List<RecordsEntity> findByUserId(int id);

    @Modifying
    @Query(value = "UPDATE records SET date=?1 WHERE id=?2",nativeQuery = true)
    void updateDate(Date date,int id);
}
