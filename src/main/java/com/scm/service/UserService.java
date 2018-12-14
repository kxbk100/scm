package com.scm.service;

import com.scm.model.UserModel;

import java.util.List;


public interface UserService {
    UserModel findUserByUserName(String userName);
    List<UserModel> findAllUser();
    void ModifyUser(UserModel userModel);

    void ResetUser(Integer userId);

    void DeleteUser(Integer userId);

    void AddUser(UserModel userModel);
}
