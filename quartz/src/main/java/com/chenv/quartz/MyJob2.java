package com.chenv.quartz;

public class MyJob2 {
	private int i = 0;
	
	public void doJob() {
		System.out.println("非继承方式"+ ++i +"调度中...");
	}
}
