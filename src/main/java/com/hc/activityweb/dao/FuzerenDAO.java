package com.hc.activityweb.dao;

import com.hc.activityweb.domain.Fuzeren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface FuzerenDAO extends JpaRepository<Fuzeren,Integer> {


    /*
    通过id删除负责人信息
     */
    @Transactional
    @Modifying
    Integer deleteFuzerenById(Integer id);

//    /*
//    修改负责人信息
//     */
//    @Transactional
//    @Modifying
//    @Query("update Fuzeren f set f.fName=?1,f.phoneNum=?2,f.address=?3,f.editTime=?4,f.editUser=?5 where f.id=?6")
//    void updateFuzerenById(String fName, String phoneNum, String address, Date editTime, String editUser, Integer id);

    /*
    通过姓名查询
     */
    List<Fuzeren> findFuzerensByFuName(String fuName);


}
