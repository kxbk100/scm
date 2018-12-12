package com.scm.service.impl;

import com.scm.entity.UsersEntity;
import com.scm.model.UserModel;
import com.scm.repository.UserRepo;
import com.scm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userDao;

    @Override
    public UserModel findUserByUserName(String userName) {
        UsersEntity usersEntity= userDao.findByUsername(userName);
        if (usersEntity==null){
            return null;
        }
        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(usersEntity,userModel);
        return userModel;
    }
}
