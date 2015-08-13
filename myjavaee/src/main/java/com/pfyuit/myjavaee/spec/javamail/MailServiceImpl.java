package com.pfyuit.myjavaee.spec.javamail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

	@Override
	public MimeBodyPart createHTMLContent(String body) throws Exception {
		MimeBodyPart content = new MimeBodyPart();
		content.setContent(body, "text/html;charset=utf-8");
		return content;
	}

	@Override
	public MimeBodyPart createHTMLContentWithImage(String body, String fileName) throws Exception {
		MimeBodyPart content = new MimeBodyPart();
		MimeMultipart multipart = new MimeMultipart("related");

		MimeBodyPart text = new MimeBodyPart();
		text.setContent(body, "text/html;charset=utf-8");
		multipart.addBodyPart(text);

		MimeBodyPart image = new MimeBodyPart();
		FileDataSource fds = new FileDataSource(fileName);
		image.setDataHandler(new DataHandler(fds));
		image.setContentID("logo");
		multipart.addBodyPart(image);

		content.setContent(multipart);
		return content;
	}

	@Override
	public MimeBodyPart createAttachment(String fileName) throws Exception {
		MimeBodyPart attachment = new MimeBodyPart();
		FileDataSource fds = new FileDataSource(fileName);
		attachment.setDataHandler(new DataHandler(fds));
		attachment.setFileName(fds.getName());
		return attachment;
	}

	@Override
	public MimeMessage createMessage(Session session, String from, String to, String subject, String body, String image, String... attachments) throws Exception {
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		msg.setSubject(subject);

		MimeMultipart all = new MimeMultipart("mixed");

		MimeBodyPart content = createHTMLContentWithImage(body, image);
		all.addBodyPart(content);

		for (int i = 0; i < attachments.length; i++) {
			String attachment = attachments[i];
			all.addBodyPart(createAttachment(attachment));
		}

		msg.setContent(all);
		msg.saveChanges();
		return msg;
	}

	@Override
	public void sendEmail(MimeMessage msg) {
		try {
			Transport.send(msg);
		} catch (MessagingException e) {
			LOGGER.error("Email send error");
			e.printStackTrace();
		}
	}

	@Override
	public Session createSession(String host, int port, boolean ssl, String username, String password, boolean auth) {
		Authenticator authenticator = new EmailAuthenticator(username, password);
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", auth);
		properties.put("mail.smtp.ssl.enable", ssl);
		Session session = Session.getDefaultInstance(properties, authenticator);
		return session;
	}

	public static void main(String[] args) throws Exception {
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
