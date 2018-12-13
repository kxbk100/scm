package com.scm.repository;

import com.scm.entity.TeachersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<TeachersEntity,Integer> {
    TeachersEntity getById(int id);
}
