package com.example.MailSendProject.Service;

import org.springframework.web.multipart.MultipartFile;

public interface MailService {

	String send(MultipartFile[] file, String to,String[] cc, String subject, String body);

	String sendWithText(String to, String[] cc, String subject, String body);

}
