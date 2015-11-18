package com.supinfo.rmt.ejb.dao.jpa;

import com.supinfo.rmt.ejb.dao.ManagerDao;
import com.supinfo.rmt.ejb.entity.Manager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Rico on 13/11/15.
 */
@Stateless
public class JpaManagerDao implements ManagerDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void updateManager(Manager manager) {
        em.merge(manager);
    }

}
