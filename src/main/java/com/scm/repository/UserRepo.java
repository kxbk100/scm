package com.scm.repository;

import com.scm.entity.UsersEntity;
import com.scm.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UsersEntity,Integer> {
    UsersEntity findByUsername(String userName);
}
