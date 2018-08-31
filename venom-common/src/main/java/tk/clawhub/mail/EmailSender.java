package tk.clawhub.mail;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * <Description> 邮件发送<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -08-28 <br>
 */
@Component
public class EmailSender {

    /**
     * Send .
     *
     * @param topic       the topic
     * @param content     the content
     * @param addressList the address list
     * @return the boolean
     */
    public boolean send(String topic, String content, List<String> addressList) {
        // 配置
        Properties prop = new Properties();
        // 设置邮件服务器主机名，这里是163
        prop.put("mail.host", "smtp.163.com");
        // 发送邮件协议名称
        prop.put("mail.transport.protocol", "smtp");
        // 是否认证
        prop.put("mail.smtp.auth", true);
        try {
            // SSL加密
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            // 设置信任所有的主机
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);
            // 创建会话对象
            Session session = Session.getDefaultInstance(prop, new Authenticator() {
                // 认证信息，需要提供"用户账号","授权码"
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("clawhub@163.com", "clawhub123");
                }
            });
            // 是否打印出debug信息
            session.setDebug(false);
            // 创建邮件
            Message message = new MimeMessage(session);
            // 邮件发送者，设置个性化别名
            message.setFrom(new InternetAddress("ClawHub@163.com", "ClawHub"));
            // 邮件接受者
            for (String tmpAddress : addressList) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(tmpAddress));
            }
            // 邮件主题
            message.setSubject(topic);
            // 邮件内容
            message.setContent(content, "text/html;charset=UTF-8");
            // 邮件发送
            Transport transport = session.getTransport();
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
