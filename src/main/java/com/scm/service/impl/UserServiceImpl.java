package com.scm.service.impl;

import com.scm.entity.UsersEntity;
import com.scm.model.UserModel;
import com.scm.repository.UserRepo;
import com.scm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userDao;

    private final static String InitPassword = "111111";
    private final static Integer ADMIN = 0;
    private final static Integer USER = 1;
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

    @Override
    public List<UserModel> findAllUser() {
        List<UserModel> userModelList = new ArrayList<>();
        List<UsersEntity> usersEntityList = userDao.findAll();
        for (UsersEntity one:usersEntityList){
            UserModel userModel = new UserModel();
            BeanUtils.copyProperties(one,userModel);
            userModelList.add(userModel);
        }
        return userModelList;
    }


    @Override
    public void ModifyUser(UserModel userModel) {
        UsersEntity usersEntity = userDao.findById(userModel.getId()).get();
        usersEntity.setUsername(userModel.getUsername());
        usersEntity.setName(userModel.getName());
        usersEntity.setPassword(userModel.getPassword());
        userDao.save(usersEntity);
    }

    @Override
    public void ResetUser(Integer userId) {
        UsersEntity usersEntity = userDao.findById(userId).get();
        usersEntity.setPassword(InitPassword);//默认密码
        userDao.save(usersEntity);
    }

    @Override
    public void DeleteUser(Integer userId) {
        //规定无法删除管理员
        UsersEntity usersEntity = userDao.findById(userId).get();
        if(usersEntity.getType()!=ADMIN)
        {
            userDao.delete(usersEntity);
        }

    }

    @Override
    public void AddUser(UserModel userModel) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUsername(userModel.getUsername());
        usersEntity.setName(userModel.getName());
        usersEntity.setPassword(InitPassword);
        usersEntity.setType(USER);//0是管理员 1是用户
        userDao.save(usersEntity);
    }
}
