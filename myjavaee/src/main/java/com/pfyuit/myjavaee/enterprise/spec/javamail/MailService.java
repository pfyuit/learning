package com.pfyuit.myjavaee.enterprise.spec.javamail;

import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public interface MailService {
	
	public abstract Session createSession(String host, int port, boolean ssl, String username, String password, boolean auth);

	public abstract MimeBodyPart createHTMLContent(String body) throws Exception;

	public abstract MimeBodyPart createHTMLContentWithImage(String body, String fileName) throws Exception;

	public abstract MimeBodyPart createAttachment(String fileName) throws Exception;

	public abstract MimeMessage createMessage(Session session, String from, String to, String subject, String body, String image, String... attachments) throws Exception;

	public abstract void sendEmail(MimeMessage msg);

}