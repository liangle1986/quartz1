package com.mywuwu.quartz.quartz;

import com.mywuwu.quartz.common.myenum.SendType;
import com.mywuwu.quartz.controller.ManagerController;
import com.mywuwu.quartz.dto.ManagerDto;
import com.mywuwu.quartz.service.IMailManagerService;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 *
 *
 */
// 在Job被执行结束后，将会更新JobDataMap，这样下次Job执行后就会使用新的值而不是初始值
@PersistJobDataAfterExecution
// 同一时间将只有一个Job实例被执行, 为了避免并发问题导致数据紊乱,建议这两个注解一起使用
@DisallowConcurrentExecution
public class MyJob implements Job {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Autowired
    private IMailManagerService managerServer;

    @Autowired
    private  ManagerController controller;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {


        JobDetail jobDetail = context.getJobDetail();


        if (jobDetail.getJobDataMap() != null && jobDetail.getJobDataMap().isEmpty() == false) {
            for (String key : jobDetail.getJobDataMap().getKeys()) {
                System.out.println(key + " ======== " + jobDetail.getJobDataMap().get(key) + "======== new Date" + dateFormat.format(new Date()));
            }
//            ManagerResult result =managerServer.sendManager();

//            System.out.println(result.isSuccess() + " ======== " + result.getManage());

            String  mailName ="82635896@qq.com";

            ManagerDto managerDto = new ManagerDto();
            managerDto.setAccount(mailName);
            managerDto.setFile(new File("F:"+File.separator+"UltraEdit-32-V16.30简体中文破解版"+File.separator+"方宇要的路由脚本.java"));
            managerDto.setManagerType(0);
            managerDto.setMeanage("欢迎来到我的世界。");
            managerDto.setSendType(SendType.MAIL);
            managerDto.setTitle("你好，" + mailName.split("@")[0]);
//            controller.sendManager(managerDto);
            managerServer.sendAttachmentsMail(managerDto);
            controller.sendManager(managerDto);


            //api url地址
            String url = "http://localhost:8080/myquartz/quartz/myNewQuartz";
            url = "http://localhost:8080/myquartz/manager/sendManager";
            if(jobDetail.getJobDataMap().get("url") != null && StringUtils.isNotEmpty(jobDetail.getJobDataMap().get("url").toString())){
                url = jobDetail.getJobDataMap().get("url").toString();
            }

            //post请求
            HttpMethod method =HttpMethod.POST;
            // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
            MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
            params.add("access_token", "APPLICATION_FORM_URLENCODED");
//            params.add("managerDto", JSON.toJSONString(managerDto));
//            client(url, method, params);
        }
    }

    /**
     * http 请求对应项目
     * @param url
     * @param method
     * @param params
     * @return
     */
    private String client(String url, HttpMethod method, MultiValueMap<String, String> params){
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //我们发起 HTTP 请求还是最好加上"Connection","close" ，有利于程序的健壮性
        headers.set("Connection","close");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        return response.getBody();
    }
}
