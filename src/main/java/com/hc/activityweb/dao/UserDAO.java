package com.hc.activityweb.dao;

import com.hc.activityweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {


    /*
    删除用户
     */
    @Transactional
    @Modifying
    Integer deleteUserById(Integer id);

    /*
    更改用户状态
     */
    @Transactional
    @Modifying
    @Query("update User u set u.state = ?1 where u.id =?2")
    int changeById(boolean state,Integer id);

    /*
    通过姓名查找用户
     */
    List<User> findUsersByRealName(String realName);
}
