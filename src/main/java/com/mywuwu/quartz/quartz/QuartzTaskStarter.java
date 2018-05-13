package com.mywuwu.quartz.quartz;

import com.mywuwu.quartz.dto.QuartzDto;
import com.mywuwu.quartz.entity.Quartz;
import com.mywuwu.quartz.service.IQuartzTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:梁乐乐
 * @Description: 定时器任务
 * @Date: 2018/5/5 15:14
 */
@Component
public class QuartzTaskStarter implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzTaskStarter.class);

 /*   @Autowired
    private TaskSchedule taskSchedule;
    @Autowired
    private QuartzTaskService quartzTaskService;*/

    @Autowired
    private QuartzManager quartzManager;

    @Autowired
    private IQuartzTaskService quartzTaskService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {

            List<Quartz> taskList = quartzTaskService.selectQuartzTaskAll();

            if(taskList != null && taskList.size() > 0){
                for (Quartz quartz : taskList){
                    QuartzDto quartzDto = new QuartzDto();
//                秒 分 时 日 月 周 年
//                   *  *  *  *  *  *  *
                    quartzDto.setCron(quartz.getCron());
                    quartzDto.setClassName(Class.forName(quartz.getClassname()));
                    quartzDto.setGroupName(quartz.getGroupname());
                    quartzDto.setJobName(quartz.getJobname());
                    quartzDto.setTriggerName(quartz.getTriggername());
                    Map<String, Object> jobMap = new HashMap<>();
                    jobMap.put("may", "给我一个支点我要翘起二郎腿····");
                    jobMap.put("love", "最大的幸福，娶了一个你····");
                    jobMap.put("back", "努力工作，好好生活····享受人生");
                    jobMap.put("id", quartz.getId());
                    quartzManager.addJob(quartzDto, jobMap);
                }
            }


        } catch (Exception e) {
            LOGGER.error("Start all valid task fail.", e);
        }
    }
}