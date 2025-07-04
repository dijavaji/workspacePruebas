package ec.com.technoloqie.web.schedule.commons.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobA implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Inicio------------- Hello Quartz!");
		try {
			Thread.sleep(10L *1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin------------- Hello Quartz!");
		
	}

}
