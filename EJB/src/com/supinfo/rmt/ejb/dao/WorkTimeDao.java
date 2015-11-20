package com.supinfo.rmt.ejb.dao;

import com.supinfo.rmt.ejb.entity.WorkTime;

import javax.ejb.Local;

/**
 * Created by Rico on 19/11/15.
 */
@Local
public interface WorkTimeDao {

    public void addWorkTime(WorkTime workTime);

    public void removeWorkTime(WorkTime workTime);

}
