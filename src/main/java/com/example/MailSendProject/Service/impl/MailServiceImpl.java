package com.example.MailSendProject.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.MailSendProject.Service.MailService;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

	
	@Value("${spring.mail.username}")
	private String emailFrom;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private String Body ="Hi {name},\r\n"
			+ "{body}\r\n"
			+ "Just a quick note to say thank you for using email send project ! Your support means a lot.\r\n"
			+ "If you have any questions or just want to connect, feel free to reach out to me:\r\n"
			+ "•	Email: [parannacharaya@gmail.com]\r\n"
			+ "•	LinkedIn: [https://www.linkedin.com/in/prasannaacharya007/]\r\n"
			+ "•	GitHub: [github.com/ctrl-enter-cse]\r\n"
			+ "•	Twitter: [https://twitter.com/PrasannaAc91526]\r\n"
			+ "•	I am looking for the job if u like the work u can refer me \r\n"
			+ "Looking forward to staying in touch!\r\n"
			+ "Best, [Prasanna]\r\n"
			+ "";
	
	@Override
	public String send(MultipartFile[] file, String to,String [] cc, String subject, String body) {
		try {
			
			 MimeMessage mimeMessage =javaMailSender.createMimeMessage();
			 MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage,true);
			 add(to,body);
			 mimeMessageHelper.setCc(cc);
			 mimeMessageHelper.setTo(to);
			 mimeMessageHelper.setFrom(emailFrom);
			 mimeMessageHelper.setSubject(subject);
			 mimeMessageHelper.setText(Body);
			 for( int i=0;i<file.length;i++) {
				 mimeMessageHelper.addAttachment(
						 file[i].getOriginalFilename(),new ByteArrayResource(file[i].getBytes())
						 );
			 }	
			 
			 javaMailSender.send(mimeMessage);
			  return "mail send";
		}catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException("exception");
		}
		
	}

	@Override
	public String sendWithText(String to, String[] cc, String subject, String body) {
		
		try{
			MimeMessage mimeMessage= javaMailSender.createMimeMessage();
			
			MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage);
			
			add(to,body);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setFrom(emailFrom);
			mimeMessageHelper.setText(Body);
			mimeMessageHelper.setCc(cc);
			javaMailSender.send(mimeMessage);
			return "mail send";
			
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	private String add(String to, String body) {
	
		String name = "";
		   name =to.substring(0, to.indexOf('@'));
		   Body=Body.replace("{name}", null != name?name:"Member");
		   Body=Body.replace("{body}", body);
		return name;
	}

}
