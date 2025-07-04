package ec.com.technoloqie.web.schedule.commons.entity;

import java.util.Date;

public class QuartzJob {
	
	private String jobName;
	private String jobGroup;
	private Date nextFireTime;

	public QuartzJob(String jobName, String jobGroup, Date nextFireTime) {
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.nextFireTime = nextFireTime;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public Date getNextFireTime() {
		return nextFireTime;
	}

	public void setNextFireTime(Date nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

}
