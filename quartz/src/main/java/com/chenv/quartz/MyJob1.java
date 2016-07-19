package com.chenv.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob1 extends QuartzJobBean {

	private int timeout;
	private static int i = 0;
	
	
	
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}



	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		System.out.println("继承方式调度"+ ++i +"进行中...");

	}

}
