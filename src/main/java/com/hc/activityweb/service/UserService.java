package com.hc.activityweb.service;

import com.hc.activityweb.dao.UserDAO;
import com.hc.activityweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

 /*
    查询用户通过名字
     */

    public List<User> findByName(String realName){
        return userDAO.findUsersByRealName(realName);
    }
    /*
    删除活动通过id
     */

    public Integer deleteUser(Integer id){
        return userDAO.deleteUserById(id);
    }

    /*
    更改用户状态
     */

    public int changeById(boolean state,Integer id){
        return userDAO.changeById(state,id);
    }


    /*
    查找全部用户
     */

    public List<User> findAllUser(){
        return userDAO.findAll();
    }

}
