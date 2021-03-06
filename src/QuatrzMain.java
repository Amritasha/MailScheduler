import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuatrzMain {

	public static void main(String[] args) throws SchedulerException {
		// TODO Auto-generated method stub
		
		JobDetail job =  JobBuilder.newJob(QuartzJob.class).build();
		
		//Trigger t1 = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger").startNow().build();
		
		//Trigger t1 = TriggerBuilder.newTrigger().withIdentity("hello").withSchedule(CronScheduleBuilder.cronSchedule("")).build();
		
		Trigger t1 = TriggerBuilder.newTrigger().withIdentity("TwoMinutes").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(2).repeatForever()).build();
		
		
		Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
		
		sc.start();
		
		sc.scheduleJob(job,t1);
	}

}
