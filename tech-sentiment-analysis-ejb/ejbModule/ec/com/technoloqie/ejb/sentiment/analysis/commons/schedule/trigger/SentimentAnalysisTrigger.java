package ec.com.technoloqie.ejb.sentiment.analysis.commons.schedule.trigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.schedule.jobs.TwitterJob;

public class SentimentAnalysisTrigger {
	
	private Scheduler scheduler;
	
	public void executeTriggerTwitter() throws Exception{
		JobDetail job = JobBuilder.newJob(TwitterJob.class).withIdentity("twitterJobName", "group1").build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("twitteTriggerName", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0/15 * 1/1 * ?")).build(); 
		 
		// schedule it
		this.scheduler = new StdSchedulerFactory().getScheduler();
		this.scheduler.start();
		this.scheduler.scheduleJob(job, trigger);
    
    }

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
}
