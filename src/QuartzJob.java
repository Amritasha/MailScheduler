import java.util.Date;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class QuartzJob implements Job {
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException{
		
		System.out.println("Sending mail");
		System.out.println(new Date());
		Resource r = new ClassPathResource("app.xml");
		BeanFactory b = new XmlBeanFactory(r);
		SendMail sm = (SendMail)b.getBean("mailMail");
		
		String reciever = "#email"; //reciever's email
		String sender = "#email";  //sender's email
		sm.sendMail(sender, reciever, "#subject", "#message");
		
		System.out.println("Sent");
		
	}
}
