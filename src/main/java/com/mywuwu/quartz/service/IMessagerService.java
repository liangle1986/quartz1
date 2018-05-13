package com.mywuwu.quartz.service;

import com.mywuwu.quartz.entity.Messager;

import java.util.List;

/**
* @Author:梁乐乐
* @Description: 消息处理接口
* @Date: 2018/5/13 22:44
*/
public interface IMessagerService {

    /**
     * 新增信息
     * @param messager 信息
     * @return 信息id
     */
    int insertMessager(Messager messager);

    /**
     * 查询所有的信息
     * @return 信息
     */
    List<Messager> selectMessagerAll();
}
