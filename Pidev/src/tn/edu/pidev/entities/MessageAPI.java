/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.entities;

/**
 *
 * @author Admin
 */

import java.net.*;
import java.util.Base64;
import java.io.*;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;


public class MessageAPI {
    
 
  
  public void send() throws IOException, AddressException, MessagingException {

 String to = "XXXXX@gmail.com"; // to address. It can be any like gmail, hotmail etc.
  final String from = "XXXXX@gmail.com"; // from address. As this is using Gmail SMTP.
  final String password = "XXXX"; // password for from mail address. 
  
  
  Properties prop = new Properties();
  prop.put("mail.smtp.host", "smtp.gmail.com");
  prop.put("mail.smtp.port", "465");
  prop.put("mail.smtp.auth", "true");
  prop.put("mail.smtp.socketFactory.port", "465");
  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

 
  Session session = Session.getInstance(prop, new Authenticator() {
  
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(to, password);
   }
  });
      try {
   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress(from));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
   message.setSubject("Message from Java Simplifying Tech");
    
   String msg = "This email sent using JavaMailer API from Java Code!!!";
    
   MimeBodyPart mimeBodyPart = new MimeBodyPart();
   mimeBodyPart.setContent(msg, "text/html");
     
   Multipart multipart = new MimeMultipart();
   multipart.addBodyPart(mimeBodyPart);
    
   MimeBodyPart attachmentBodyPart = new MimeBodyPart();
   attachmentBodyPart.attachFile(new File ("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Pidev\\src\\images\\capture.png"));
   multipart.addBodyPart(attachmentBodyPart);
   message.setContent(multipart);
   Transport.send(message);
   
   
      } catch (Exception e) {
          System.out.println(e);
      }
  }
}

 
 
  
 
