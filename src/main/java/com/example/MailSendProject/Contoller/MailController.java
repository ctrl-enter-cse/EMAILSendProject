package com.example.MailSendProject.Contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<String>("hellow",HttpStatus.OK);
	}
	
	@PostMapping("/sendmailText")
	public ResponseEntity<String> sendMailWithText(@RequestParam String to, @RequestParam String [] cc,@RequestParam String subject,@RequestParam String body ) {
		System.out.println("in the controler : /sendmailText");
		return mailservice.sendWithText(to,cc,subject,body);
	}


	@PostMapping("/sendmail")								//**  multiple number of files  **//                                           //**  multiple number of cc **//                   
	public ResponseEntity<String> sendMailWithFile( @RequestParam(value="file",required=false)MultipartFile[] file,@RequestParam String to,@RequestParam String [] cc,@RequestParam String subject,@RequestParam String body ) {
		System.out.println("in the controler :  /sendmail");
		return mailservice.send(file,to,cc,subject,body);
	}

}


