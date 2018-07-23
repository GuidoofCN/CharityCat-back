package cn.cat.factory;

import java.util.Date;
import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;

public class MailMessageFactory {
	//邮箱模板
	public static SimpleMailMessage getMailMessageTemplate(String mail,String verificatCode) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("1209306293@qq.com");
		mailMessage.setTo(mail);
		mailMessage.setSentDate(new Date());
		mailMessage.setSubject("公益猫验证码");
		mailMessage.setText(verificatCode);
		return mailMessage;
	}

}
