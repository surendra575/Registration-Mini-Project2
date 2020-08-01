package com.surendra.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.surendra.binding.User;
@Component
public class EmailUtility {
	@Autowired
	private JavaMailSender jms;
	
	
	public boolean sendMail(User user)
	{
		boolean isSent=false;
		try
		{
			MimeMessage mimeMessage = jms.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
			helper.setTo(user.getEmail());
			helper.setSubject("Unlock your account");
			helper.setText(getUnlockAccEmailBody(user), true);
			jms.send(mimeMessage);
			isSent=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return isSent;
	}
	
	
	private String getUnlockAccEmailBody(User acc) throws IOException {
		StringBuffer sb = new StringBuffer("");

		FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
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
		mailBody = mailBody.replace("{TEMP-PWD}", acc.getPassword());
		mailBody = mailBody.replace("{EMAIL}", acc.getEmail());

		return mailBody;
	}

}
