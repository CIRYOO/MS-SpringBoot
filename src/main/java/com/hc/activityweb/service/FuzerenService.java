package com.hc.activityweb.service;

import com.hc.activityweb.dao.FuzerenDAO;
import com.hc.activityweb.domain.Fuzeren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuzerenService {

    @Autowired
    FuzerenDAO fuzerenDAO;

    /*
    查询所有负责人
     */
    public List<Fuzeren> listAll(){
        return fuzerenDAO.findAll();
    }


    /*
    查询负责人通过名字
     */

    public List<Fuzeren> findFuzerensByFuName(String fuName){
        return fuzerenDAO.findFuzerensByFuName(fuName);
    }
    /*
    删除负责人通过id
     */

    public Integer deleteFuzeren(Integer id){
        return fuzerenDAO.deleteFuzerenById(id);
    }
}
