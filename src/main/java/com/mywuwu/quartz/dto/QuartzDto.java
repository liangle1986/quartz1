package com.mywuwu.quartz.dto;

/**
 *
 *
 *
 *
 */
public class QuartzDto {

    /**
     * job名称
     */
    private String jobName;

    /**
     * trig 名
     */
    private String triggerName;

    /**
     * 组名
     */
    private String groupName;

    /**
     * 类名
     */
    private Class className;

    /**
     * 时间
     */
    private String cron;

    /**
     * 获取job名
     * @return 返回job名称
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置job名称
     * @param jobName 名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 设置控制器名
     * @return 控制器名
     */
    public String getTriggerName() {
        return triggerName;
    }

    /**
     * 设置控制器名
     * @param triggerName 控制器名
     */
    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    /**
     * 获取组名
     * @return 组名
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置组名
     * @param groupName 组名
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 类名
     * @return 类名
     */
    public Class getClassName() {
        return className;
    }

    /**
     * 设置类名
     * @param className 类名
     */
    public void setClassName(Class className) {
        this.className = className;
    }

    /**
     * 时间
     * @return 时间
     */
    public String getCron() {
        return cron;
    }

    /**
     * 设置时间
     * @param cron 时间
     */
    public void setCron(String cron) {
        this.cron = cron;
    }
}
