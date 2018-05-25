package constant.tools.mail.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;

public class SendMailUtils {

    /**
     * 
     * @param host
     * @param from
     * @param password
     * @param to
     * @param cc
     * @param bcc
     * @param subject
     * @param content
     * @param type
     * @throws MessagingException
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static void sendMail(String host, String from, String password, String to, String cc, String bcc,
            String subject, String content, String type) throws MessagingException {
        final Properties props = new Properties();

        props.put("mail.smtp.auth", "true");

        // props.put("mail.smtp.host", "smtp.mxhichina.com"); //阿里邮箱企业版
        // props.put("mail.smtp.host", "smtp.qq.com"); //QQ邮箱
        // props.put("mail.smtp.host", "smtp.exmail.qq.com"); // 腾讯企业邮箱
        props.put("mail.smtp.host", host);

        // 发件人的账号
        props.put("mail.user", from);

        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", password);

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };

        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);

        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);

        // 设置发件人
        InternetAddress fromAddress = new InternetAddress(from);
        message.setFrom(fromAddress);

        // 设置收件人
        InternetAddress toAddress = new InternetAddress(to);
        message.setRecipient(RecipientType.TO, toAddress);

        if (StringUtils.isNotEmpty(cc)) {
            InternetAddress ccAddress = new InternetAddress(cc);
            message.setRecipient(RecipientType.CC, ccAddress);
        }

        if (StringUtils.isNotEmpty(bcc)) {
            InternetAddress bccAddress = new InternetAddress(bcc);
            message.setRecipient(RecipientType.BCC, bccAddress);
        }

        // 设置邮件标题
        message.setSubject(subject);

        if (null == type) {
            type = "text/html;charset=UTF-8";
        }

        // 设置邮件的内容体
        message.setContent(content, type);
        // 发送邮件
        Transport.send(message);
    }

}
