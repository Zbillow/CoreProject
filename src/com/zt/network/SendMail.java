/*
 * Copyright 2012-2017 hchbox.com All right reserved. This software is the
 * confidential and proprietary information of hchbox.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with hchbox.com.
 */
package com.zt.network;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {
    
    public static void main(String[] args) {
        
        
//        String to = "zbillows@foxmail.com";
//   
//        String from = "858864344@qq.com";
//   
//        String host = "mx1.qq.com";
//   
//        Properties properties = System.getProperties();
//   
//        properties.setProperty("mail.smtp.host", host);
//
//   
//        Session  session = Session.getDefaultInstance(properties);
//   
//        try{
//           MimeMessage message = new MimeMessage(session);
//   
//           message.setFrom(new InternetAddress(from));
//   
//           message.addRecipient(Message.RecipientType.TO,
//                                    new InternetAddress(to));
//   
//           message.setSubject("This is the Subject Line!");
//   
//           message.setText("This is actual message");
//   
//           Transport.send(message);
//           System.out.println("Sent message successfully....");
//        }catch (MessagingException mex) {
//           mex.printStackTrace();
//        }
        
        String to = "zbillows@foxmail.com";
   
        String from = "858864344@qq.com";
   
        String host = "smtp.qq.com";
   
        Properties properties = new Properties();
   
        properties.put("smtp.qq.com", host);
        properties.put("smtp.qq.com", "true");
        properties.setProperty("mail.user", "858864344@qq.com");
        properties.setProperty("mail.password", "hacker043005");
   
        Session session = Session.getDefaultInstance(properties);
   
        try{
           MimeMessage message = new MimeMessage(session);
   
           message.setFrom(new InternetAddress(from));
   
           message.addRecipient(Message.RecipientType.TO,
                                    new InternetAddress(to));
   
           message.setSubject("This is the Subject Line!");
   
           message.setText("This is actual message");
   
           Transport.send(message);
           System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
           mex.printStackTrace();
        }
        
    }

}
