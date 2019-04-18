package com.cognizant.dao;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendEmail {

	private static final Logger logger = LoggerFactory.getLogger(SendEmail.class);

	public static void sendEmail(String id,String name,String role,String email,String password,String status) 
	{
		logger.info("----Sending Email----");
		final String username = "arushirastogi702@gmail.com";
		final String password1 = "Arushi14@16$$";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password1);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("arushirastogi702@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Testing Subject");
			if(role.equals("Manager"))
			{
			if(status.equals("Approved"))
			{
			message.setText("Hello "+role+", \n"+"Your Registration Status : "+status+"\n"+
			"Your "+role+" ID : "+id+"\n"+
			"Password : "+password);
			}
			else
			{
				message.setText("Hello "+role+", \n"+"Your Registration Status : "+status+"\n"+
						"Try After Sometime");				
			}
			}
			else
			{
				message.setText("Hello "+role+", \n"+"Your "+role+" ID : "+id+"\n"+
						"Password : "+password);
			}
		Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}