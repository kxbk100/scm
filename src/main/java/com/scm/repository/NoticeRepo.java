package com.scm.repository;

import com.scm.entity.NoticesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepo extends JpaRepository<NoticesEntity,Integer> {
    List<NoticesEntity> findAllByOrderByDateDesc();
    void deleteById(int id);
}
