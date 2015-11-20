package com.supinfo.rmt.ejb.dao.jpa;

import com.supinfo.rmt.ejb.dao.WorkTimeDao;
import com.supinfo.rmt.ejb.entity.WorkTime;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Rico on 19/11/15.
 */
@Stateless
public class JpaWorkTimeDao implements WorkTimeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addWorkTime(WorkTime workTime) {
        em.persist(workTime);
    }

    @Override
    public void removeWorkTime(WorkTime workTime) {
        // Remove workTime in list employee and client
        workTime.getClient().getWorkTimes().remove(workTime);
        workTime.getEmployee().getWorkTimes().remove(workTime);
        workTime = em.getReference(WorkTime.class, workTime.getId());
        em.remove(workTime);
    }
}
