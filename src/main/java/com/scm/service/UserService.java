package com.scm.service;

import com.scm.model.PageUserModel;
import com.scm.model.UserModel;

import java.util.List;


public interface UserService {
    UserModel findUserByUserName(String userName);
    List<PageUserModel> findAllUser();
    Integer ModifyUser(UserModel userModel);
    Integer ResetUser(Integer userId);
    Integer DeleteUser(Integer userId);
    Integer AddUser(UserModel userModel);
    Integer UserPasswordModify(Integer userId,String OldPassword,String NewPassword);
    PageUserModel findUsersById(Integer id);
}
