package com.zt.network;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;




public class MailSendUtils {
    //发送html邮件
	public static void sendHtmlMail(MailInfo info)throws Exception{
		Message message = getMessage(info);
		message.setContent(info.getContent(), "text/html;charset=utf-8");
		Transport.send(message);
	}
	//发送普通邮件
	public static void sendTextMail(MailInfo info)throws Exception{
		Message message = getMessage(info);
		message.setText(info.getContent());
		Transport.send(message);
	}
	//发送带附件的邮件
	public static void sendFileMail(MailInfo info)throws Exception{
	    Message message = getMessage(info);
	    BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(info.getContent());
        // 创建多重消息
	    Multipart multipart = new MimeMultipart();
        // 设置文本消息部分
        multipart.addBodyPart(messageBodyPart);
        // 附件部分
        messageBodyPart = new MimeBodyPart();
        //附件路径
        String filename = "C:/Users/Administrator/Desktop/bmcc-servlet.xml";
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
        // 发送完整消息
        message.setContent(multipart );
        Transport.send(message);
	    
	}
	
	private static Message getMessage(MailInfo info) throws Exception{
	 // 创建邮件的发送过程中用到的主机和端口号的属性文件  
		final Properties  p = System.getProperties() ;
		p.setProperty("mail.smtp.host", info.getHost());
		// 设置邮件发送需要认证  
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.user", info.getFormName());
		p.setProperty("mail.smtp.pass", info.getFormPassword());
	    p.setProperty("mail.transport.protocol", "smtp");
		//创建的SSL验证
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
	    sf.setTrustAllHosts(true);
	    p.put("mail.smtp.ssl.enable", "true");
	    p.put("mail.smtp.ssl.socketFactory", sf);
	    // 创建邮件验证信息，即发送邮件的用户名和密码 
		Session session = Session.getInstance(p, new Authenticator(){
		 // 重写验证方法，填写用户名，密码 (注:这里的密码不是登录密码,是授权码)
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(p.getProperty("mail.smtp.user"),p.getProperty("mail.smtp.pass"));
			}
		});
		//为true时输出Debug信息
		session.setDebug(true);
		// 创建一个邮件消息
		Message message = new MimeMessage(session);
		// 设置邮件主题
		message.setSubject(info.getSubject());
		// 创建发件人邮箱地址
		message.setReplyTo(InternetAddress.parse(info.getReplayAddress()));
		// 设置发件人邮箱地址和发件人名称
		message.setFrom(new InternetAddress(p.getProperty("mail.smtp.user"),"网站管理员"));
		//发送给多人的方法
		String[] array = info.getToAddress().split(",");
		Address []addresses=new InternetAddress[array.length];
		for (int i = 0; i < array.length; i++) {
		    addresses[i]= new InternetAddress(array[i]);
        }
		// 将接收者的地址设置到消息的信息中   发送类型设置为TO, CC 或者BCC. 这里CC 代表抄送、BCC 代表秘密抄送
		message.setRecipients(RecipientType.CC, addresses);
		
		return message ;
	}
	
	public static void main(String[] args) throws Exception{
		MailInfo info = new MailInfo();
		// 设置邮件发送方的主机地址如果是163邮箱，则为smtp.163.com  
	    // 如果是其他的邮箱可以参照http://wenku.baidu.com/link?url=Cf-1ggeW3e7Rm9KWfz47UL7vvkRpPxAKBlYoTSGpnK4hxpJDiQ0A4lRoPDncMlcMIvUpEn6PD0aObgm5zJaM7AOGkRdccSx6HDH2fSWkxIq这个文档  
		info.setHost("smtp.qq.com");
		info.setFormName("XXX@foxmail.com");
		info.setFormPassword("XXXX");
		info.setReplayAddress("XX@foxmail.com");
		//如果发送给多人,用逗号隔开
		info.setToAddress("XX@qq.com,XX@163.com");
		info.setSubject("这是标题");
		info.setContent("这里是内容");
		
//		sendTextMail(info);
//		sendHtmlMail(info);
		sendFileMail(info);
	}
}
