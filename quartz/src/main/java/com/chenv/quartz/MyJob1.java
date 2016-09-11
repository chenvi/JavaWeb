package com.chenv.quartz;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob1 extends QuartzJobBean {

	private int timeout;
	private static int i = 0;
	
	public static void main(String[] args) {
		
		int a = 1;
		assert(a < 0):"a > 0";
		System.out.println("ok");
		
		
		/*Calendar ca = Calendar.getInstance();
		System.out.println(ca.get(Calendar.YEAR));
		System.out.println(ca.get(Calendar.MONTH));
		System.out.println(ca.get(Calendar.DAY_OF_MONTH));
		System.out.println(ca.get(Calendar.HOUR_OF_DAY));
		System.out.println(ca.get(Calendar.MINUTE));
		System.out.println(ca.get(Calendar.SECOND));
		
		LocalDateTime lt = LocalDateTime.now();
		System.out.println(lt.getYear());
		System.out.println(lt.getMonthValue());
		System.out.println(lt.getDayOfMonth());
		System.out.println(lt.getHour());
		System.out.println(lt.getMinute());
		System.out.println(lt.getSecond());
		
		System.out.println();
		System.out.println(ca.getTimeInMillis());
		System.out.println(System.currentTimeMillis());
		
		ca.add(Calendar.DATE, -1);
		System.out.println(ca.getTime());
		LocalDateTime l = lt.minusDays(1);
		System.out.println(l);*/
	}
	
	public int setTimeout(int timeout) {
		this.timeout = timeout;
		try {
			
			return this.timeout;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			this.timeout++;
		}
		return timeout;
	}



	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		System.out.println("继承方式调度"+ ++i +"进行中...");

	}

}
