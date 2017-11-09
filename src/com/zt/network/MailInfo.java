package com.zt.network;

public class MailInfo {

    /**
     *发送方主机地址
     */
    private String host;
    
    /**用户名**/
    private String formName;
    /**授权码**/
    private String formPassword;
    /**发送方邮箱地址**/
    private String replayAddress;
    /**接收方邮箱地址**/
    private String toAddress;
    /**邮件标题**/
    private String subject;
    /**邮件内容**/
    private String content;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormPassword() {
        return formPassword;
    }

    public void setFormPassword(String formPassword) {
        this.formPassword = formPassword;
    }

    public String getReplayAddress() {
        return replayAddress;
    }

    public void setReplayAddress(String replayAddress) {
        this.replayAddress = replayAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
