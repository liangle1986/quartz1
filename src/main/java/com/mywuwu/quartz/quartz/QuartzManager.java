package com.mywuwu.quartz.quartz;

import com.mywuwu.quartz.dto.QuartzDto;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author:梁乐乐
 * @Description: 定时任务实现类型
 * @Date: 2018/5/5 15:37
 */
@Component
public class QuartzManager {

//    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    @Autowired
    private Scheduler scheduler;
    /**
     * @param quartzDto 定时任务对象
     * @Description: 添加一个定时任务
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void addJob(QuartzDto quartzDto, Map<String, Object> jobMap) {
        try {
//            Scheduler sched = schedulerFactory.getScheduler();
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder.newJob(quartzDto.getClassName()).withIdentity(quartzDto.getJobName(), quartzDto.getGroupName()).build();

            //私有参数
            if (jobMap != null && jobMap.isEmpty() == false) {
                for (String key : jobMap.keySet()) {
                    jobDetail.getJobDataMap().put(key, jobMap.get(key));
                }
            }

            // 触发器  
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组  
            triggerBuilder.withIdentity(quartzDto.getTriggerName(), quartzDto.getGroupName());
            triggerBuilder.startNow();
            // 触发器时间设定  
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(quartzDto.getCron()));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);

            // 启动  
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param quartzDto 定时任务对象
     * @Description: 修改一个任务的触发时间
     */
    public  void modifyJobTime(QuartzDto quartzDto) {
        try {
//            Scheduler sched = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(quartzDto.getTriggerName(), quartzDto.getGroupName());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }

            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(quartzDto.getCron())) {
                /** 方式一 ：调用 rescheduleJob 开始 */
                // 触发器  
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组  
                triggerBuilder.withIdentity(quartzDto.getTriggerName(), quartzDto.getGroupName());
                triggerBuilder.startNow();
                // 触发器时间设定  
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(quartzDto.getCron()));
                // 创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                scheduler.rescheduleJob(triggerKey, trigger);
                /** 方式一 ：调用 rescheduleJob 结束 */

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param quartzDto 定时任务对象
     * @Description: 移除一个任务
     */
    public  void removeJob(QuartzDto quartzDto) {
        try {
//            Scheduler sched = schedulerFactory.getScheduler();

            TriggerKey triggerKey = TriggerKey.triggerKey(quartzDto.getTriggerName(), quartzDto.getGroupName());

            scheduler.pauseTrigger(triggerKey);// 停止触发器
            scheduler.unscheduleJob(triggerKey);// 移除触发器
            scheduler.deleteJob(JobKey.jobKey(quartzDto.getJobName(), quartzDto.getGroupName()));// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:启动所有定时任务
     */
    public  void startJobs() {
        try {
//            Scheduler sched = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:关闭所有定时任务
     */
    public  void shutdownJobs() {
        try {
//            Scheduler sched = schedulerFactory.getScheduler();
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}