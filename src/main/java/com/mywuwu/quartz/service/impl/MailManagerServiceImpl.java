package com.mywuwu.quartz.service.impl;

import com.mywuwu.quartz.common.ManagerResult;
import com.mywuwu.quartz.dto.ManagerDto;
import com.mywuwu.quartz.service.IMailManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Author:梁乐乐
 * @Description: 邮件发送类
 * @Date: 2018/5/5 19:04
 */
@Service
public class MailManagerServiceImpl implements IMailManagerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public ManagerResult sendManager(ManagerDto managerDto) {

        ManagerResult result = new ManagerResult();
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(from);
            message.setTo(managerDto.getAccount()); //自己给自己发送邮件
            message.setSubject(managerDto.getTitle());
            message.setText(managerDto.getMeanage());
            sender.send(message);

            logger.info("普通信息邮件已发送");
            result.setSuccess(true);
            result.setManage("邮件发送给" + message.toString());
        } catch (Exception e) {
            logger.error("发送htext邮件时发生异常！", e);
            result.setSuccess(false);
        }
        return result;
    }


    @Override
    public ManagerResult sendManagerHtml(ManagerDto managerDto) {

        ManagerResult result = new ManagerResult();
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(managerDto.getAccount());
            helper.setSubject(managerDto.getTitle());
            helper.setText(managerDto.getMeanage(), true);

            sender.send(message);
            logger.info("html邮件已经发送。");
            result.setSuccess(true);
            result.setManage("邮件发送给" + helper.toString());
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
            result.setSuccess(false);
        }
        return result;
    }


    @Override
    public ManagerResult sendAttachmentsMail(ManagerDto managerDto) {
        ManagerResult result = new ManagerResult();
        MimeMessage message = null;
        try {
            message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(managerDto.getAccount());
            helper.setSubject(managerDto.getTitle());
            helper.setText(managerDto.getMeanage());
            //注意项目路径问题，自动补用项目路径
            FileSystemResource file = new FileSystemResource(managerDto.getFile());
            //加入邮件
            helper.addAttachment(file.getFilename(), file);
            sender.send(message);

            logger.info("带附件邮件已经发送。");
            result.setSuccess(true);
            result.setManage("带附件邮件发送给" + helper.toString());

        } catch (Exception e){
            e.printStackTrace();
            logger.info("带附件邮件发送失败。");
        }
        return result;
    }
}
