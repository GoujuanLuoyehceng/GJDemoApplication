package com.luobo.dao;

import com.luobo.model.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface  IUserDao extends JpaRepository<UserPO,Long> {
    @Query("select b from UserPO b where b.uid = ?1")
    UserPO findUserByUid(String uid);
}
