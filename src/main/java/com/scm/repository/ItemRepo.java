package com.scm.repository;

import com.scm.entity.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<ItemsEntity,Integer> {
    ItemsEntity getById(int id);
}
