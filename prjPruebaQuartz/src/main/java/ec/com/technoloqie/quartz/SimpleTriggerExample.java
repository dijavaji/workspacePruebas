package ec.com.technoloqie.quartz;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import ec.com.technoloqie.commons.HelloJob;

public class SimpleTriggerExample {
	
public void ejecutarSimpleTriggerExample() throws Exception {
		
		// Quartz 1.6.3
		 JobDetail job = new JobDetail();
		 job.setName("dummyJobName");
		 job.setJobClass(HelloJob.class);


                //Quartz 1.6.3
		 SimpleTrigger trigger = new SimpleTrigger();
		 trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
		 trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		 trigger.setRepeatInterval(30000);

		// Trigger the job to run on the next round minute

		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

}
