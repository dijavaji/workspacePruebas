package ec.com.technoloqie.quartz.test;

import ec.com.technoloqie.quartz.CronTriggerExample;

public class TestQuartz {
	
	@org.junit.Test
	public void prueba(){
		CronTriggerExample example = new CronTriggerExample();
		try {
			example.ejecutarCronTriggerExample();
			System.out.println("finaliza");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
