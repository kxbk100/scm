package com.scm.service.impl;

import com.scm.entity.UsersEntity;
import com.scm.model.PageUserModel;
import com.scm.model.UserModel;
import com.scm.repository.UserRepo;
import com.scm.service.UserService;
import com.scm.utils.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userDao;

    private final static String InitPassword = MD5Util.MD5Encode("111111","utf-8");
    private final static Integer ADMIN = 0;
    private final static Integer USER = 1;
    private final static Integer SUCCESS = 1;
    private final static Integer FAIL = 0;
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
    public List<PageUserModel> findAllUser() {
        List<PageUserModel> pageUserModelList = new ArrayList<>();
        List<UsersEntity> usersEntityList = userDao.findAll();
        for (UsersEntity one:usersEntityList){
            if (one.getType() == ADMIN){
                continue;
            }
            PageUserModel PageUserModel = new PageUserModel();
            BeanUtils.copyProperties(one,PageUserModel);
            pageUserModelList.add(PageUserModel);
        }
        return pageUserModelList;
    }


    @Override//管理员的修改工号和用户名
    public Integer ModifyUser(UserModel userModel) {
        UsersEntity usersEntity = userDao.findById(userModel.getId()).get();
        usersEntity.setUsername(userModel.getUsername());
        usersEntity.setName(userModel.getName());
        try{
            userDao.save(usersEntity);
            return SUCCESS;
        }catch (Exception e){
            return FAIL;
        }
    }

    @Override
    public Integer ResetUser(Integer userId) {
        UsersEntity usersEntity = userDao.findById(userId).get();
        usersEntity.setPassword(InitPassword);//默认密码
        try{
            userDao.save(usersEntity);
            return SUCCESS;
        }catch (Exception e){
            return FAIL;
        }
    }

    @Override
    public Integer DeleteUser(Integer userId) {
        //规定无法删除管理员
        UsersEntity usersEntity = userDao.findById(userId).get();
        try {
            if(usersEntity.getType()!=ADMIN)
            {
                userDao.delete(usersEntity);
            }
            return SUCCESS;
        }catch (Exception e){
            return FAIL;
        }

    }

    @Override
    public Integer AddUser(UserModel userModel) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUsername(userModel.getUsername());
        usersEntity.setName(userModel.getName());
        usersEntity.setPassword(InitPassword);
        usersEntity.setType(USER);//0是管理员 1是用户
        try{
            userDao.save(usersEntity);
            return SUCCESS;
        }catch (Exception e){
            return FAIL;
        }
    }

    @Override
    public Integer UserPasswordModify(Integer userId,String OldPassword,String NewPassword) {
        UsersEntity usersEntity =  userDao.findById(userId).get();
        String password = usersEntity.getPassword();
        try{
            if(password.equals(MD5Util.MD5Encode(OldPassword,"utf-8"))){
                password= MD5Util.MD5Encode(NewPassword,"utf-8");
                usersEntity.setPassword(password);
                userDao.save(usersEntity);
                return SUCCESS;
            }else{
                return FAIL;
            }
        }catch (Exception e ){
            return FAIL;
        }
    }
}
