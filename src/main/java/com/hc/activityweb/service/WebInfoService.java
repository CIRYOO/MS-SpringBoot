package com.hc.activityweb.service;

import com.hc.activityweb.dao.WebInfoDAO;
import com.hc.activityweb.domain.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebInfoService {

    @Autowired
    WebInfoDAO webInfoDAO;

    public List<WebInfo> findAllWebInfo(){
        return webInfoDAO.findAll();
    }
}
