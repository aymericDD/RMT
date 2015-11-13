package com.supinfo.rmt.ejb.dao;

import com.supinfo.rmt.ejb.entity.User;

import javax.ejb.Local;

/**
 * Created by Rico on 12/11/15.
 */
@Local
public interface UserDao {

    public void addUser(User user);

    public User getUserByPassword(String userName, String userPassword);

}
