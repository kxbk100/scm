package com.scm.repository;

import com.scm.entity.TeachersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TeacherRepo extends JpaRepository<TeachersEntity,Integer> {
    TeachersEntity getById(int id);

    @Query(nativeQuery = true,value = "SELECT COUNT(*) FROM teachers")
    int countAll();

    int countByEdu(int edu);

    @Query(nativeQuery = true,value = "SELECT COUNT(*) FROM teachers WHERE birthday<?1")
    int countByAge(Date date);
}
