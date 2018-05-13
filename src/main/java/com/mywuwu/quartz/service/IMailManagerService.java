package com.mywuwu.quartz.service;


import com.mywuwu.quartz.common.ManagerResult;
import com.mywuwu.quartz.dto.ManagerDto;

/**
* @Author:梁乐乐
* @Description: 邮件发送接口
* @Date: 2018/5/6 11:20
*/

public interface IMailManagerService {

    /**
     * 发送信息
     * @param managerDto 信息
     * @return
     */
    ManagerResult sendManager(ManagerDto managerDto);

    /**
     * 发送html信息
     * @param managerDto 信息
     * @return
     */
    ManagerResult sendManagerHtml(ManagerDto managerDto);

    /**
     * 发送带附件的邮件
     * @param managerDto
     * @return
     */
    ManagerResult sendAttachmentsMail(ManagerDto managerDto);
}
