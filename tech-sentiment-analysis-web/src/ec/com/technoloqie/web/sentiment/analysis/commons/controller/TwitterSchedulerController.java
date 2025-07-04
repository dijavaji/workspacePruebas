package ec.com.technoloqie.web.sentiment.analysis.commons.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.entities.ScheduleJobEstr;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.log.SentimentAnalysisLog;
import ec.com.technoloqie.ejb.sentiment.analysis.persistence.business.SentimentAnalysisEjbLocal;

@ManagedBean(name="twitterSchedulerController" )
@SessionScoped
@SuppressWarnings("serial")
public class TwitterSchedulerController implements Serializable{
	
	@EJB
	private SentimentAnalysisEjbLocal analysisEjbLocal;
	
	private Scheduler scheduler;

	private List<ScheduleJobEstr> quartzJobList = new ArrayList<ScheduleJobEstr>();
	
	/**
	 * Constructor inicializa el trigger de la descarga de tweets
	 */
	public TwitterSchedulerController(){
		//analysisEjbLocal.executeDownloadsTweets();
		
	}

	private void generateJobsScheduler() throws SentimentAnalysisException {
		
		try{
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

					quartzJobList.add(new ScheduleJobEstr(jobName, jobGroup, nextFireTime));

				}

			  }
			
		}catch(SchedulerException e){
			SentimentAnalysisLog.error("Error al ejecutar el trigger de twitter ", e);
			throw new SentimentAnalysisException("Error al ejecutar el trigger de twitter",e);
		}
	}
	
	public String loadScheduler(){
		try {
			analysisEjbLocal.executeDownloadsTweets();
			this.generateJobsScheduler();
		} catch (SentimentAnalysisException e) {
			SentimentAnalysisLog.error("Error al cargar la lista de tareas. ", e);
		}
		return "pages/scheduler/listJobs";
	}

	//trigger a job
	public void fireNow(String jobName, String jobGroup)throws SchedulerException {
		JobKey jobKey = new JobKey(jobName, jobGroup);
		scheduler.triggerJob(jobKey);

	}

	public List<ScheduleJobEstr> getQuartzJobList() {
		return quartzJobList;

	}

	public SentimentAnalysisEjbLocal getAnalysisEjbLocal() {
		return analysisEjbLocal;
	}

	public void setAnalysisEjbLocal(SentimentAnalysisEjbLocal analysisEjbLocal) {
		this.analysisEjbLocal = analysisEjbLocal;
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public void setQuartzJobList(List<ScheduleJobEstr> quartzJobList) {
		this.quartzJobList = quartzJobList;
	}

}
