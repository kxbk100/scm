package com.scm.repository;

import com.scm.entity.TeamsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepo extends JpaRepository<TeamsEntity,Integer> {
}
