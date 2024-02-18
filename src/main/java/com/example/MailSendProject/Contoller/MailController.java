package com.example.MailSendProject.Contoller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.MailSendProject.Service.MailService;

@RestController
@RequestMapping("/home")
public class MailController {

	private  MailService mailservice;
	
	MailController(MailService mailservice){
		this.mailservice=mailservice;
	}
	
	@PostMapping("/sendmailText")
	public String sendMailWithText(@RequestParam String to,@RequestParam String [] cc,@RequestParam String subject,@RequestParam String body ) {
		System.out.println("in the controler : /sendmailText");
		return mailservice.sendWithText(to,cc,subject,body);
	}
	
	

	@PostMapping("/sendmail")
	public String sendMailWithFile( @RequestParam(value="file",required=false)MultipartFile[] file,@RequestParam String to,@RequestParam String [] cc,@RequestParam String subject,@RequestParam String body ) {
		System.out.println("in the controler :  /sendmail");
		return mailservice.send(file,to,cc,subject,body);
	}



}


