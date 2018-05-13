package com.mywuwu.quartz.controller;

import com.mywuwu.quartz.dto.QuartzDto;
import com.mywuwu.quartz.quartz.MyJob;
import com.mywuwu.quartz.quartz.QuartzManager;
import com.mywuwu.quartz.service.IMailManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/quartz")
public class MyController {

    @Autowired
    private IMailManagerService mailManagerServer;

    @Autowired
    private QuartzManager quartzManager;
//    @GetMapping("myNewQuartz")
    @PostMapping("myNewQuartz")
    public void myNewQuartz(){
        for (int i = 0; i < 3; i++) {
            QuartzDto quartzDto = new QuartzDto();
//                秒 分 时 日 月 周 年
//                   *  *  *  *  *  *  *
            quartzDto.setCron("* 0/1 * * * ?");
            quartzDto.setClassName(MyJob.class);
            quartzDto.setGroupName("groupName" + i);
            quartzDto.setJobName("jobName" + i);
            quartzDto.setTriggerName("triggerName" + i);
            Map<String, Object> jobMap = new HashMap<>();
            jobMap.put("may","给我一个支点我要翘起二郎腿····");
            jobMap.put("love","最大的幸福，娶了一个你····");
            jobMap.put("back","努力工作，好好生活····享受人生");
            quartzManager.modifyJobTime(quartzDto);

//            mailManagerServer.sendManager();
        }
    }
}
