package com.example.MailSendProject.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface MailService {

	ResponseEntity<String> send(MultipartFile[] file, String to,String[] cc, String subject, String body);

	ResponseEntity<String> sendWithText(String to, String[] cc, String subject, String body);

}
