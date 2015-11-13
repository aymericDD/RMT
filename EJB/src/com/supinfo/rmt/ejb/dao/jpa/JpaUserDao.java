package com.supinfo.rmt.ejb.dao.jpa;

import com.supinfo.rmt.ejb.dao.UserDao;
import com.supinfo.rmt.ejb.entity.User;

import javax.ejb.Stateless;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Rico on 12/11/15.
 */
@Stateless
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUserByPassword(String userName, String userPassword) {
        Query q = em.createQuery("SELECT u from User u WHERE u.userName like :un AND u.password like :up");
        q.setParameter("un", userName).setParameter("up", userPassword).setMaxResults(1);

        List results = q.getResultList();
        User foundEntity = null;
        if(!results.isEmpty()){
            // ignores multiple results
            return  (User)results.get(0);
        }

        return null;
    }
}
