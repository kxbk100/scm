package com.scm.controller;
/*
用户查看 /scm/users/show
用户修改 /scm/users/modify
用户增加 /scm/users/add
密码重置 /scm/users/reset
用户删除 /scm/users/delete
用户自己密码修改 /scm/users/password
 */
import com.scm.entity.UsersEntity;
import com.scm.model.PageUserModel;
import com.scm.model.UserModel;
import com.scm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public List<PageUserModel> GetShowUser(){
        return userService.findAllUser();
    }
    @RequestMapping(value = "/scm/users/modify",method = RequestMethod.POST)
    @ResponseBody
    public Integer PostModifyUser(@RequestBody UserModel userModel){
       return userService.ModifyUser(userModel);
    }

    @RequestMapping(value = "/scm/users/add",method = RequestMethod.POST)
    @ResponseBody
    public Integer PostAddUser(@RequestBody UserModel userModel){
        return userService.AddUser(userModel);
    }

    @RequestMapping(value = "/scm/users/reset",method = RequestMethod.POST)
    @ResponseBody
    public Integer PostResetUser(@RequestParam Integer userId){
        return userService.ResetUser(userId);
    }

    @RequestMapping(value = "/scm/users/delete",method = RequestMethod.POST)
    @ResponseBody
    public Integer PostDeleteUser(@RequestParam Integer userId){
       return userService.DeleteUser(userId);
    }

    @RequestMapping(value = "/scm/users/password",method = RequestMethod.POST)
    @ResponseBody
    public Integer PostChangePassword(@RequestParam String OldPassword, @RequestParam String NewPassword, HttpSession session)
    {
        if(session.getAttribute("user")!=null){
            UsersEntity usersEntity = (UsersEntity) session.getAttribute("user");
            return userService.UserPasswordModify(usersEntity.getId(),OldPassword,NewPassword);
        }else{
            return 1;
        }
    }

    @RequestMapping(value = "/scm/users/id/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public PageUserModel GetUsersInfo(@PathVariable Integer userId){
        return userService.findUsersById(userId);
    }
}
