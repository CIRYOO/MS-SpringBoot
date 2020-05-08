package com.hc.activityweb.dao;

import com.hc.activityweb.domain.Activity;
import com.hc.activityweb.domain.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public interface ActivityDAO extends JpaRepository<Activity,Integer> {

    /**
     * 用于登录名和密码 进行登录
     * @param loginName
     * @param password
     * @return
     */
    @Query("select a from Admin a where loginName=?1 and password=?2")
    List<Admin> findByLoginNameAndPassword(String loginName, String password);

    /*
    删除活动通过Id
     */
    @Transactional
    @Modifying
    Integer deleteActivityById(Integer id);

    /*
    修改活动通过Id
     */
    @Transactional
    @Modifying
    @Query("update Activity a set a.img=?1,a.acName=?2,a.acContent=?3,a.acFuzeren=?4,a.editTime=?5,a.editUser=?6 where a.id=?7")
    void updateById(String img, String acName, String acContent, String acFuzeren, Date editTime,String editUser,Integer id);


    /*
    查询活动通过活动名字
     */

    List<Activity> findByAcName(String acName);

    /*
    分页
     */
    Page<Activity> findAll(Pageable pageable);
}
