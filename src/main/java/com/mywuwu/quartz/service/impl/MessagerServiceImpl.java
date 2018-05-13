package com.mywuwu.quartz.service.impl;

import com.mywuwu.quartz.common.ManagerResult;
import com.mywuwu.quartz.dao.MessagerMapper;
import com.mywuwu.quartz.dto.ManagerDto;
import com.mywuwu.quartz.entity.Messager;
import com.mywuwu.quartz.service.IMailManagerService;
import com.mywuwu.quartz.service.IMessagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Author:梁乐乐
* @Description: 消息类处理类
* @Date: 2018/5/13 22:43
*/
@Service
public class MessagerServiceImpl implements IMessagerService{

    @Autowired
    private MessagerMapper messagerMapper;

    @Override
    public int insertMessager(Messager messager) {
        return messagerMapper.insertMessager(messager);
    }

    @Override
    public List<Messager> selectMessagerAll() {
       return messagerMapper.selectMessagerAll();
    }
}
