package com.scm.repository;

import com.scm.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UsersEntity,Integer> {
    UsersEntity findByUsername(String userName);
}
