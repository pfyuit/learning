package com.pfyuit.myjavaee.service.email.javamail;

import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 * Java mail service interface.
 * @author yupengfei
 */
public interface MailService {

	public Session createSession(String host, int port, boolean ssl, String username, String password, boolean auth);

	public MimeBodyPart createHTMLContent(String body) throws Exception;

	public MimeBodyPart createHTMLContentWithImage(String body, String fileName) throws Exception;

	public MimeBodyPart createAttachment(String fileName) throws Exception;

	public MimeMessage createMessage(Session session, String from, String to, String subject, String body, String image, String... attachments)
			throws Exception;

	public void sendEmail(MimeMessage msg);

}