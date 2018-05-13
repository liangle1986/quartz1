package com.mywuwu.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuartzApplicationTests {
	@Autowired
	private static JavaMailSender sender;
	@Test
	public void contextLoads() {
		MimeMessage message = sender.createMimeMessage();

		try {
			//true表示需要创建一个multipart message
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("liangle1986@126.com");
			helper.setTo("37781552@qq.com");
			helper.setSubject("主题：带附件的邮件");
			helper.setText("测试邮件内容", true);

			sender.send(message);

		} catch (MessagingException e) {
		}
	}

}
