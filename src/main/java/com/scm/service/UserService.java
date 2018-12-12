package com.scm.service;

import com.scm.model.UserModel;
import org.springframework.stereotype.Service;


public interface UserService {
    UserModel findUserByUserName(String userName);
}
