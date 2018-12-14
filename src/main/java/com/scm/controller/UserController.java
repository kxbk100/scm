package com.scm.controller;
/*
用户查看 /scm/users/show
用户修改 /scm/users/modify
用户增加 /scm/users/add
密码重置 /scm/users/reset
用户删除 /scm/users/delete
 */
import com.scm.model.UserModel;
import com.scm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/scm/users/show",method = RequestMethod.GET)
    @ResponseBody
    public List<UserModel> GetShowUser(){
        return userService.findAllUser();
    }
    @RequestMapping(value = "/scm/users/modify",method = RequestMethod.POST)
    public void PostModifyUser(@RequestBody UserModel userModel){
        userService.ModifyUser(userModel);
    }

    @RequestMapping(value = "/scm/users/add",method = RequestMethod.POST)
    public void PostAddUser(@RequestBody UserModel userModel){
        userService.AddUser(userModel);
    }

    @RequestMapping(value = "/scm/users/reset",method = RequestMethod.POST)
    public void PostResetUser(@RequestParam Integer userId){
        userService.ResetUser(userId);
    }

    @RequestMapping(value = "/scm/users/delete",method = RequestMethod.POST)
    public void PostDeleteUser(@RequestParam Integer userId){
        userService.DeleteUser(userId);
    }

}
