package com.supinfo.rmt.ejb.services;

import com.supinfo.rmt.ejb.dao.UserDao;
import com.supinfo.rmt.ejb.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by Rico on 12/11/15.
 */
@Stateless
public class UserService {

    @EJB
    private UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserByPassword(String userName, String userPassword) {
        return userDao.getUserByPassword(userName, userPassword);
    }

}
