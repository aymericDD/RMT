package com.supinfo.rmt.ejb.services;

import com.supinfo.rmt.ejb.dao.WorkTimeDao;
import com.supinfo.rmt.ejb.entity.WorkTime;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by Rico on 19/11/15.
 */
@Stateless
public class WorkTimeService {

    @EJB
    private WorkTimeDao workTimeDao;

    public void addWorkTime(WorkTime workTime) {
        workTimeDao.addWorkTime(workTime);
    }

    public void removeWorkTime(WorkTime workTime) {
        workTimeDao.removeWorkTime(workTime);
    }

}
