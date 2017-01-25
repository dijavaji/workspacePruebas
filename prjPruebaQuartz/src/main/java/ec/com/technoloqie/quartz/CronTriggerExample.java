package ec.com.technoloqie.quartz;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import ec.com.technoloqie.commons.HelloJob;

public class CronTriggerExample {
	
	 public void ejecutarCronTriggerExample() throws Exception
	    {
	    	//Quartz 1.6.3
	    	JobDetail job = new JobDetail();
	    	job.setName("dummyJobName");
	    	job.setJobClass(HelloJob.class);    	

		//Quartz 1.6.3
	    	CronTrigger trigger = new CronTrigger();
	    	trigger.setName("dummyTriggerName");
	    	//trigger.setCronExpression("0/5 * * * * ?");
	    	trigger.setCronExpression("0 0/15 * 1/1 * ? *");
	    	
	    	
	    	//schedule it
	    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	    	scheduler.start();
	    	scheduler.scheduleJob(job, trigger);
	    
	    }
}
