package ec.com.technoloqie.web.schedule.commons.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import ec.com.technoloqie.web.schedule.commons.entity.QuartzJob;

/*@ManagedBean(name = "schedulerController")
@SessionScoped*/
@SuppressWarnings("serial")
public class SchedulerController implements Serializable{
	

	private Scheduler scheduler;

	private List<QuartzJob> quartzJobList = new ArrayList<QuartzJob>();

	public SchedulerController() throws SchedulerException {

	  ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

	  //Get QuartzInitializerListener
	  StdSchedulerFactory stdSchedulerFactory = (StdSchedulerFactory) servletContext.getAttribute(QuartzInitializerListener.QUARTZ_FACTORY_KEY);

	  scheduler = stdSchedulerFactory.getScheduler();

	  // loop jobs by group
	  for (String groupName : scheduler.getJobGroupNames()) {

		// get jobkey
		for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

			String jobName = jobKey.getName();
			String jobGroup = jobKey.getGroup();

			// get job's trigger
			List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
			Date nextFireTime = triggers.get(0).getNextFireTime();

			quartzJobList.add(new QuartzJob(jobName, jobGroup, nextFireTime));

		}

	  }

	}

	//trigger a job
	public void fireNow(String jobName, String jobGroup)throws SchedulerException {
		JobKey jobKey = new JobKey(jobName, jobGroup);
		scheduler.triggerJob(jobKey);

	}

	public List<QuartzJob> getQuartzJobList() {
		return quartzJobList;

	}

}
