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
	
	@Override
	public String send(MultipartFile[] file, String to,String [] cc, String subject, String body) {
		try {
			
			 MimeMessage mimeMessage =javaMailSender.createMimeMessage();
			 MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage,true);
			 mimeMessageHelper.setCc(cc);
			 mimeMessageHelper.setTo(to);
			 mimeMessageHelper.setFrom(emailFrom);
			 mimeMessageHelper.setSubject(subject);
			 mimeMessageHelper.setText(body);
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
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setFrom(emailFrom);
			mimeMessageHelper.setText(body);
			mimeMessageHelper.setCc(cc);
			javaMailSender.send(mimeMessage);
			return "mail send";
			
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

}
