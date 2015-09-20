package com.pfyuit.myjavaee.spec.enterprise.javamail;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfyuit.myjavaee.enterprise.spec.javamail.MailService;
import com.pfyuit.myjavaee.enterprise.spec.javamail.MailServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class MailServiceTest {

	@Autowired
	private MailService mailService;

	@Test
	@Ignore
	public void testSendEmail() throws Exception {
		MailService mailService = new MailServiceImpl();

		String host = "mx1.qq.com"; //用了mx1.qq.com貌似port/ssl/username/password/auth都被忽略了
		int port = 465;
		boolean ssl = true;
		String username = "";
		String password = "";
		boolean auth = true;

		String from = "hello@world.com";
		String to = "";
		String subject = "系统自动发出的邮件";
		String body = "<h4>图文并茂的邮件且包含附件</h4></br>" + "<img src = \"cid:logo\">";
		String image = "C:\\Users\\yupengfei\\Pictures\\Penguins.jpg";

		Session session = mailService.createSession(host, port, ssl, username, password, auth);
		MimeMessage msg = mailService.createMessage(session, from, to, subject, body, image, "C:\\图片1.png");
		mailService.sendEmail(msg);
	};

}
