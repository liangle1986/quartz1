package com.mywuwu.quartz.service.impl;

import com.mywuwu.quartz.dao.QuartzMapper;
import com.mywuwu.quartz.entity.Quartz;
import com.mywuwu.quartz.service.IQuartzTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Service
public class QuartzTaskServiceImpl implements IQuartzTaskService {

    @Autowired
    private QuartzMapper quartzMapper;

    @Override
    public int insertQuartzTask(Quartz quartz){
        return quartzMapper.insertQuartzTask(quartz);
    }


    @Override
    public List<Quartz> selectQuartzTaskAll() {
        return quartzMapper.selectQuartzTaskAll();
    }
}
