package ec.com.technoloqie.web.schedule.backbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.quartz.SchedulerException;

import ec.com.technoloqie.web.schedule.commons.controller.SchedulerController;
import ec.com.technoloqie.web.schedule.commons.trigger.CronTrigger;

@ManagedBean(name="helloBackBean")
@SessionScoped
@SuppressWarnings("serial")
public class HelloBackBean implements Serializable {
	
	private String name;
	private CronTrigger example;
	private SchedulerController schedulerController;
	
	@PostConstruct
	public void initilize(){
		try {
			example = new CronTrigger();
			example.ejecutarCronTriggerExample();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String loadScheduler(){
		try {
			this.schedulerController = new SchedulerController();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public CronTrigger getExample() {
		return example;
	}

	public void setExample(CronTrigger example) {
		this.example = example;
	}

	public SchedulerController getSchedulerController() {
		return schedulerController;
	}

	public void setSchedulerController(SchedulerController schedulerController) {
		this.schedulerController = schedulerController;
	}
}
