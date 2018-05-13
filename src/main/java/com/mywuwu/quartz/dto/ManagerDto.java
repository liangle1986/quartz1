package com.mywuwu.quartz.dto;

import com.mywuwu.quartz.common.myenum.SendType;

import java.io.File;
import java.io.Serializable;

/**
* @Author:梁乐乐
* @Description: 消息接收实体
* @Date: 2018/5/6 11:22
*/
public class ManagerDto implements Serializable {

    private static final long serialVersionUID = 1307044188318906776L;

    /**
     * 信息
     */
    private String meanage;

    /**
     * 发送类型
     */
    private SendType sendType;

    /**
     * 发送账号
     */
    private String account;

    /**
     * 信息头
     */
    private String title;

    /**
     * 文件
     */
    private File file;

    /**
     * 0：正常类型， 1：html类型， 2:带附件
     */
    private int managerType;

    /**
     * 获取信息
     * @return 信息
     */
    public String getMeanage() {
        return meanage;
    }

    /**
     * 设置信息
     * @param meanage 信息
     */
    public void setMeanage(String meanage) {
        this.meanage = meanage;
    }

    /**
     * 账号
     * @return 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 抬头
     * @return 抬头
     */
    public String getTitle() {
        return title;
    }

    /**
     * 抬头
     * @param title 抬头
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 发送类型
     * @return 发送类型
     */
    public SendType getSendType() {
        return sendType;
    }

    /**
     * 发送类型
     * @param sendType 发送类型
     */
    public void setSendType(SendType sendType) {
        this.sendType = sendType;
    }

    /**
     * 文件
     * @return 文件
     */
    public File getFile() {
        return file;
    }

    /**
     * 文件
     * @param file 设置文件
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * 消息类型
     * @return 消息类型
     */
    public int getManagerType() {
        return managerType;
    }

    /**
     * 消息类型
     * @param managerType 消息类型
     */
    public void setManagerType(int managerType) {
        this.managerType = managerType;
    }

    /**
     * 带参构造方法
     * @param meanage 信息
     * @param sendType 发送类型
     * @param account 账号
     * @param title 抬头
     * @param file 文件
     * @param managerType 发送类型
     */
    public ManagerDto(String meanage, SendType sendType, String account, String title, File file, int managerType) {
        this.meanage = meanage;
        this.sendType = sendType;
        this.account = account;
        this.title = title;
        this.file = file;
        this.managerType = managerType;
    }

    /**
     * 无参构造方法
     */
    public ManagerDto() {
    }
}
