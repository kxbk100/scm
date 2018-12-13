package com.scm.repository;

import com.scm.entity.PapersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepo extends JpaRepository<PapersEntity,Integer> {
    PapersEntity getById(int id);
}
