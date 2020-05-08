package com.hc.activityweb.controller;

import com.hc.activityweb.common.RespCode;
import com.hc.activityweb.common.ResponseEntity;
import com.hc.activityweb.dao.ActivityDAO;
import com.hc.activityweb.dao.FuzerenDAO;
import com.hc.activityweb.dao.UserDAO;
import com.hc.activityweb.domain.*;
import com.hc.activityweb.service.ActivityService;
import com.hc.activityweb.service.FuzerenService;
import com.hc.activityweb.service.UserService;
import com.hc.activityweb.service.WebInfoService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/*
响应实体
 */

@RestController
@RequestMapping("/activity")
public class ActivityContronller {

    @Autowired
    ActivityService activityService;
    @Autowired
    UserService userService;
    @Autowired
    FuzerenService fuzerenService;

    @Autowired
    WebInfoService webInfoService;

    @Autowired
    ActivityDAO activityDAO2;
    @Autowired
    UserDAO userDAO2;
    @Autowired
    FuzerenDAO fuzerenDAO2;

    /*
    查询所有
     */
    @RequestMapping("/listAll")
    public ResponseEntity list(){
        List<Activity> activityList = activityService.listAll();
        return new ResponseEntity(RespCode.SUCCESS,activityList);
    }

    /*
    添加活动
     */


    @RequestMapping("/addActivity")
    public Activity addActivity(@RequestParam("img") String img,@RequestParam("acName") String acName, @RequestParam("acContent") String acContent
            , @RequestParam("acFuzeren") String acFuzeren, @RequestParam("editTime") Date editTime,@RequestParam("editUser") String editUser){
        Activity activity = new Activity();

        activity.setImg(img);
        activity.setAcName(acName);
        activity.setAcContent(acContent);
        activity.setAcFuzeren(acFuzeren);
        activity.setEditTime(editTime);
        activity.setEditUser(editUser);
        return activityDAO2.save(activity);
    }

    /*
    查询活动通过活动名字
     */
    @RequestMapping("/list/acName/{acName}")
    public ResponseEntity findByAcName(@RequestParam("acName") String acName){
        List<Activity> activityList = activityService.findByAcName(acName);
        return new ResponseEntity(RespCode.SUCCESS,activityList);
    }

    /*
    删除通过id
     */
    @RequestMapping("/list/{id}")
    public ResponseEntity delActivityById(@RequestParam("id") Integer id){
        Integer delNum = activityService.deleteActivity(id);
        return new ResponseEntity(RespCode.SUCCESS,delNum);
    }

    /*
    修改活动通过Id
     */
    @RequestMapping("/list/edit/{id}")
    public Activity updateActivityById(@RequestParam("id") Integer id,@RequestParam("img") String img,@RequestParam("acName") String acName,@RequestParam("acContent") String acContent
            , @RequestParam("acFuzeren") String acFuzeren, @RequestParam("editTime") Date editTime,@RequestParam("editUser") String editUser){
        Activity activity = new Activity();

        activity.setId(id);
        activity.setImg(img);
        activity.setAcName(acName);
        activity.setAcContent(acContent);
        activity.setAcFuzeren(acFuzeren);
        activity.setEditTime(editTime);
        activity.setEditUser(editUser);
        return activityDAO2.save(activity);
    }

    /*
    查询所有用户
     */
    @RequestMapping("/userList")
    public ResponseEntity userListAll(){
        List<User> userList = userService.findAllUser();
        return new ResponseEntity(RespCode.SUCCESS,userList);
    }

    /*
    查询用户通过名字
     */
    @RequestMapping("/userList/realName/{realName}")
    public ResponseEntity findUserByRealName(@RequestParam("realName") String realName){
        List<User> userList = userService.findByName(realName);
        return new ResponseEntity(RespCode.SUCCESS,userList);
    }

    /*
    修改用户状态
     */

    @RequestMapping("/user/change/{id}")
    public ResponseEntity changeById(@RequestParam("state") boolean state,@RequestParam("id") Integer id){

        int changeNum = userService.changeById(state,id);

        return new ResponseEntity(RespCode.SUCCESS,changeNum);
    }


    /*
  删除用户通过id
   */
    @RequestMapping("/userList/{id}")
    public ResponseEntity delUserById(@RequestParam("id") Integer id){
        Integer delNum = userService.deleteUser(id);
        return new ResponseEntity(RespCode.SUCCESS,delNum);
    }

       /*
    添加用户
     */
    @RequestMapping("/addUser")
    public User addUser(@RequestParam("phoneNum") String phoneNum, @RequestParam("realName") String realName,@RequestParam("addTime") Date addTime,@RequestParam("state") boolean state){
        User user = new User();

        user.setPhoneNum(phoneNum);
        user.setRealName(realName);
        user.setAddTime(addTime);
        user.setState(state);
        return userDAO2.save(user);
    }


    /*
        添加负责人
     */
    @RequestMapping("/addFuzeren")
    public Fuzeren addFuzeren(@RequestParam("fuName") String fuName, @RequestParam("phoneNum") String phoneNum, @RequestParam("address") String address
            ,  @RequestParam("editTime") Date editTime, @RequestParam("editUser") String editUser){
        Fuzeren fuzeren = new Fuzeren();

        fuzeren.setFuName(fuName);
        fuzeren.setPhoneNum(phoneNum);
        fuzeren.setAddress(address);
        fuzeren.setEditTime(editTime);
        fuzeren.setEditUser(editUser);
        return fuzerenDAO2.save(fuzeren);
    }
    /*
  删除负责人通过id
   */
    @RequestMapping("/fuzerenList/{id}")
    public ResponseEntity delFuzerenById(@RequestParam("id") Integer id){
        Integer delNum = fuzerenService.deleteFuzeren(id);
        return new ResponseEntity(RespCode.SUCCESS,delNum);
    }

    /*
      修改负责人通过Id
       */
    @RequestMapping("/fuzerenList/edit/{id}")
    public Fuzeren updateFuzerenById(@RequestParam("id") Integer id,@RequestParam("fuName") String fuName, @RequestParam("phoneNum") String phoneNum, @RequestParam("address") String address
            , @RequestParam("editTime") Date editTime, @RequestParam("editUser") String editUser){
        Fuzeren fuzeren = new Fuzeren();

        fuzeren.setId(id);
        fuzeren.setFuName(fuName);
        fuzeren.setPhoneNum(phoneNum);
        fuzeren.setAddress(address);
        fuzeren.setEditTime(editTime);
        fuzeren.setEditUser(editUser);
        return fuzerenDAO2.save(fuzeren);
    }
    /*
       查询所有负责人
        */
    @RequestMapping("/fuzerenList")
    public ResponseEntity fuzerenListAll(){
        List<Fuzeren> fuzerenList = fuzerenService.listAll();
        return new ResponseEntity(RespCode.SUCCESS,fuzerenList);
    }
    /*
       查询负责人通过名字
        */
    @RequestMapping("/fuzerenList/fuName/{fuName}")
    public ResponseEntity findFuzerenByFuName(@RequestParam("fuName") String fuName){
        List<Fuzeren> fuzerenList = fuzerenService.findFuzerensByFuName(fuName);
        return new ResponseEntity(RespCode.SUCCESS,fuzerenList);
    }

    @RequestMapping("/webInfo")
    public ResponseEntity webInfoListAll(){
        List<WebInfo> webInfoList = webInfoService.findAllWebInfo();
        return new ResponseEntity(RespCode.SUCCESS,webInfoList);
    }

    /*
    分页
     */
    @RequestMapping("/list/fenye")
    public Page<Activity> findAll(@RequestParam("page") int page, @RequestParam("size") int size){

        Sort.Order sort = new Sort.Order(Sort.Direction.ASC,"id");
        PageRequest pageRequest = PageRequest.of(page-1,size,Sort.by(sort));
        Page<Activity> activityPage = activityService.findAll(pageRequest);

        return activityPage;
    }
    /*
    登录
     */

    @RequestMapping("/login")
    public ResponseEntity login(@RequestParam("loginName") String loginName,@RequestParam("password") String password){
        List<Admin> adminList = activityService.login(loginName,password);
        return new ResponseEntity(RespCode.SUCCESS,adminList);
    }


}
