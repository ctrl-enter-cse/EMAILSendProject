# EMAILSendProject
sending email implementation in the spring project

-----------------------------------------------------------------------------------------------------------------------------------------------------

To Do List: steps 
1. Download starter package with required dependencies
2. Add necessary configurations to connect to mail server
3. here we are sending  with file and without file (attachments)  and all the other parameter are taken as @pram in contoller 
4. Create a controller method to call the service class
5. Create a method in service class to send the mail
6. Send mail

-----------------------------------------------------------------------------------------------------------------------------------------------------
exception faced while implementing javaMailSender project
=====================================================================================================================================================
org.springframework.mail.MailSendException: Mail server connection failed. Failed messages: org.eclipse.angus.mail.util.MailConnectException: Couldn't connect to host, port: smtp.gmail.com, 587; timeout -1;
  nested exception is:
	java.net.UnknownHostException: smtp.gmail.com; message exceptions (1) are:
Failed message 1: org.eclipse.angus.mail.util.MailConnectException: Couldn't connect to host, port: smtp.gmail.com, 587; timeout -1;
  nested exception is:
	java.net.UnknownHostException: smtp.gmail.com
 ##  network was not connected 
==============================================================================================================================================
org.springframework.mail.MailSendException: Failed messages: jakarta.mail.SendFailedException: Invalid Addresses;
  nested exception is:
	org.eclipse.angus.mail.smtp.SMTPAddressFailedException: 553-5.1.3 The recipient address <c> is not a valid RFC 5321 address. For more
553-5.1.3 information, go to
553-5.1.3  https://support.google.com/a/answer/3221692 and review RFC 5321
553 5.1.3 specifications. h4-20020a170902eec400b001d911dd145esm1704358plb.219 - gsmtp
; message exceptions (1) are:
Failed message 1: jakarta.mail.SendFailedException: Invalid Addresses;
  nested exception is:
	org.eclipse.angus.mail.smtp.SMTPAddressFailedException: 553-5.1.3 The recipient address <c> is not a valid RFC 5321 address. For more
553-5.1.3 information, go to
553-5.1.3  https://support.google.com/a/answer/3221692 and review RFC 5321
553 5.1.3 specifications. h4-20020a170902eec400b001d911dd145esm1704358plb.219 – gsmtp


##This was bcoz the cc address was wrong so wrong address thrown
===============================================================================================================================================

org.springframework.mail.MailSendException: Mail server connection failed. Failed messages: org.eclipse.angus.mail.util.MailConnectException: Couldn't connect to host, port: smtp.gmail.com, 25; timeout -1;
  nested exception is:
	java.net.ConnectException: Connection timed out: connect; message exceptions (1) are:
Failed message 1: org.eclipse.angus.mail.util.MailConnectException: Couldn't connect to host, port: smtp.gmail.com, 25; timeout -1;
  nested exception is:
	java.net.ConnectException: Connection timed out: connect
 [2m2024-02-17T22:09:45.082+05:30 [0;39m  [31mERROR [0;39m  [35m19740 [0;39m  [2m--- [0;39m  [2m[nio-8080-exec-2] [0;39m  [2m [0;39m [36mo.a.c.c.C.[.[.[/].[dispatcherServlet]    [0;39m  [2m: [0;39m Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.RuntimeException: exception] with root cause
Port wrong 

## Server.port =587  this is  for server I wanted to write the smtp ported 
===============================================================================================================================================
org.springframework.mail.MailAuthenticationException: Authentication failed; nested exception is javax.mail.AuthenticationFailedException: ;

================================================================================================================================================







