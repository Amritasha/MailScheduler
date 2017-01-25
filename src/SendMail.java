import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SendMail {
		
	private MailSender mailSend;

	public void setMailSend(MailSender mailSend) {
		this.mailSend = mailSend;
	}
	
	public void sendMail(String from, String to,String subject, String msg){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSend.send(message);
	}
}
