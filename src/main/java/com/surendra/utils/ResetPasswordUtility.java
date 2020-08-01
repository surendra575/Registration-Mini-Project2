package com.surendra.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


import com.surendra.entity.UserEntity;
@Component
public class ResetPasswordUtility {
	@Autowired
	private JavaMailSender jms;
	
	
	public boolean sendMail(UserEntity ue)
	{
		boolean isSent=false;
		try
		{
			MimeMessage mimeMessage = jms.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
			helper.setTo(ue.getEmail());
			helper.setSubject("Reset your account");
			helper.setText(getResetEmailBody(ue), true);
			jms.send(mimeMessage);
			isSent=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return isSent;
	}
	
	
	private String getResetEmailBody(UserEntity acc) throws IOException {
		StringBuffer sb = new StringBuffer("");

		FileReader fr = new FileReader("RESET_PWD_EMAIL-BODY-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		br.close();

		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", acc.getFirstName());
		mailBody = mailBody.replace("{LNAME}", acc.getLastName());
		mailBody = mailBody.replace("{PWD}", acc.getPassword());
//		mailBody = mailBody.replace("{EMAIL}", acc.getEmail());

		return mailBody;
	}

}
