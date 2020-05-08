package com.hc.activityweb.service;
import com.hc.activityweb.dao.ActivityDAO;
import com.hc.activityweb.domain.Activity;
import com.hc.activityweb.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityDAO activityDAO;
    /*
    查询所有活动
     */
    public List<Activity> listAll(){
        return activityDAO.findAll();
    }


    /*
    查询活动通过活动名字
     */

    public List<Activity> findByAcName(String acName){
        return activityDAO.findByAcName(acName);
    }
    /*
    删除活动通过id
     */

    public Integer deleteActivity(Integer id){
        return activityDAO.deleteActivityById(id);
    }

    /*
    分页
     */
    public Page<Activity> findAll(Pageable pageable){
        Page<Activity> page1 = activityDAO.findAll(pageable);
//        List<Activity> activityList = new ArrayList<Activity>();
//        page1.forEach(activity -> {
//            activityList.add(activity);
//        });
        return page1;


    }


    /*
    管理员登录
     */
    public List<Admin> login(String loginName,String password){
        return activityDAO.findByLoginNameAndPassword(loginName,password);
    }
}
