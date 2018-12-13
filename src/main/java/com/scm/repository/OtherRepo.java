package com.scm.repository;

import com.scm.entity.OtherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherRepo extends JpaRepository<OtherEntity,Integer> {
    OtherEntity getById(int id);
}
