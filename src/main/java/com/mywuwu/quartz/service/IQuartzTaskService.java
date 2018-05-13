package com.mywuwu.quartz.service;

import com.mywuwu.quartz.entity.Quartz;

import java.util.List;

/**
* @Author:梁乐乐
* @Description: 定期处理接口
* @Date: 2018/5/13 11:19
*/
public interface IQuartzTaskService {

    /**
     * 新增定时任务
     * @param quartz 任务信息
     * @return id
     */
    int insertQuartzTask(Quartz quartz);


    /**
     * 查询所有定时器任务
     * @return 定时器
     */
    List<Quartz> selectQuartzTaskAll();
}
