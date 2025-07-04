package ec.com.technoloqie.web.sentiment.analysis.backbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import ec.com.technoloqie.ejb.sentiment.analysis.commons.exception.SentimentAnalysisException;
import ec.com.technoloqie.ejb.sentiment.analysis.commons.log.SentimentAnalysisLog;
import ec.com.technoloqie.web.sentiment.analysis.commons.controller.TwitterSchedulerController;


@ManagedBean(name="sentimentAnalysisBackBean")
@SessionScoped
@SuppressWarnings("serial")
public class SentimentAnalysisBackBean implements Serializable{
	
	private String name;
	/*@ManagedProperty(value = "twitterSchedulerController")
	private TwitterSchedulerController twitterSchedulerController;*/
	
	@PostConstruct
	public void initilize(){
		//this.twitterSchedulerController = new TwitterSchedulerController();
	}
	
	
	public String loadScheduler(){
		try {
			//analysisEjbLocal.executeDownloadsTweets();
			//this.generateJobsScheduler();
		} catch (SentimentAnalysisException e) {
			SentimentAnalysisLog.error("Error al cargar la lista de tareas. ", e);
		}
		return "pages/scheduler/listJobs";
	}
	
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
