package com.mywuwu.quartz.controller;

import com.mywuwu.quartz.common.ManagerResult;
import com.mywuwu.quartz.common.myenum.SendType;
import com.mywuwu.quartz.dto.ManagerDto;
import com.mywuwu.quartz.service.IMailManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* @Author:梁乐乐
* @Description: 信息发送控制器
* @Date: 2018/5/6 10:36
*/
@RequestMapping("/manager")
@CrossOrigin
@RestController
public class ManagerController {

    /**
     * 邮件发送类
     */
    @Autowired
    private IMailManagerService mailManagerServer;

    @PostMapping("sendManager")
    public ManagerResult sendManager(@RequestBody ManagerDto managerDto){
        ManagerResult result = new ManagerResult();
        if(managerDto.getSendType() == SendType.MAIL){
            if(managerDto.getManagerType() == 0){
                result = mailManagerServer.sendManager(managerDto);
            } else if(managerDto.getManagerType() == 1){
                result = mailManagerServer.sendManagerHtml(managerDto);
            } else if(managerDto.getManagerType() == 2){
                result = mailManagerServer.sendAttachmentsMail(managerDto);
            }

        } else if(managerDto.getSendType() == SendType.QQ){

        } else if(managerDto.getSendType() == SendType.WECHAT){

        } else if(managerDto.getSendType() == SendType.IPHONE){

        } else if(managerDto.getSendType() == SendType.OTHER){

        }

        return result;
    }

    @PostMapping("sendManager2")
    public ManagerResult sendManager(){
        ManagerResult result = new ManagerResult();

        return result;
    }
}
