Socket 编程

套接字使用TCP提供了两台计算机之间的通信机制。 客户端程序创建一个套接字，并尝试连接服务器的套接字。
当连接建立时，服务器会创建一个Socket对象。客户端和服务器现在可以通过对Socket对象的写入和读取来进行进行通信。
java.net.Socket类代表一个套接字，并且java.net.ServerSocket类为服务器程序提供了一种来监听客户端，并与他们建立连接的机制。
以下步骤在两台计算机之间使用套接字建立TCP连接时会出现：
服务器实例化一个ServerSocket对象，表示通过服务器上的端口通信。
服务器调用 ServerSocket类 的accept（）方法，该方法将一直等待，直到客户端连接到服务器上给定的端口。
服务器正在等待时，一个客户端实例化一个Socket对象，指定服务器名称和端口号来请求连接。
Socket类的构造函数试图将客户端连接到指定的服务器和端口号。如果通信被建立，则在客户端创建一个Socket对象能够与服务器进行通信。
在服务器端，accept()方法返回服务器上一个新的socket引用，该socket连接到客户端的socket。
连接建立后，通过使用I/O流在进行通信。每一个socket都有一个输出流和一个输入流。客户端的输出流连接到服务器端的输入流，而客户端的输入流连接到服务器端的输出流。
TCP是一个双向的通信协议，因此数据可以通过两个数据流在同一时间发送.以下是一些类提供的一套完整的有用的方法来实现sockets。
GreetingClient 是一个客户端程序，该程序通过socket连接到服务器并发送一个请求，然后等待一个响应。
GreetingServer 是一个服务器端应用程序，使用Socket来监听一个指定的端口。

-------------------------------------------------------------------
邮件发送
发送邮件需要开通SMTP服务,获取到授权码.
使用Java应用程序发送E-mail十分简单，但是首先你应该在你的机器上安装JavaMail API 和Java Activation Framework (JAF) 。
你可以在 JavaMail http://www.oracle.com/technetwork/java/index-138643.html 下载最新的版本。
你可以再 在JAF http://www.oracle.com/technetwork/java/jaf11-139815.html下载最新的版本。
下载并解压这些文件，最上层文件夹你会发现很多的jar文件。你需要将mail.jar和activation.jar 添加到你的CLASSPATH中。

MailInfo 存放发送邮件相关属性
MailSendUtils  发送邮件的具体方法

发送邮件时遇到的异常
Exception in thread "main" javax.mail.AuthenticationFailedException: 530 Error: A secure connection is requiered(such as ssl). More information at http://service.mail.qq.com/cgi-bin/help?id=28

异常原因是未加上SSL加密,163、新浪邮箱不需要 SSL 加密.
使用QQ发送的话加上以下代码
MailSSLSocketFactory sf = new MailSSLSocketFactory();
sf.setTrustAllHosts(true);
p.put("mail.smtp.ssl.enable", "true");
p.put("mail.smtp.ssl.socketFactory", sf);
Exception in thread "main" javax.mail.AuthenticationFailedException: 535 Error: ÇëÊ¹ÓÃÊÚÈ¨ÂëµÇÂ¼¡£ÏêÇéÇë¿´: http://service.mail.qq.com/cgi-bin/help?subtype=1&&id=28&&no=1001256

	at com.sun.mail.smtp.SMTPTransport$Authenticator.authenticate(SMTPTransport.java:826)
	at com.sun.mail.smtp.SMTPTransport.authenticate(SMTPTransport.java:761)
	at com.sun.mail.smtp.SMTPTransport.protocolConnect(SMTPTransport.java:685)
	at javax.mail.Service.connect(Service.java:317)
	at javax.mail.Service.connect(Service.java:176)
	at javax.mail.Service.connect(Service.java:125)
	at javax.mail.Transport.send0(Transport.java:194)
	at javax.mail.Transport.send(Transport.java:124)
	at com.zt.network.MailSendUtils.sendHtmlMail(MailSendUtils.java:23)
	at com.zt.network.MailSendUtils.main(MailSendUtils.java:78)
该异常邮箱为用户名和密码验证错误;首先先检查用户名是否正确,密码应为授权码,不是邮箱登录密码.

