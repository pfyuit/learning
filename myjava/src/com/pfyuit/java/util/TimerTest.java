package com.pfyuit.java.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) {
		testSchedule();
		testPurge();
		testCancel();
	}

	private static void testSchedule() {
		Timer timer = new Timer();
		testScheduleWithDate(timer);
		testScheduleWithDelay(timer);
		testScheduleWithDateAndPeriod(timer);
		testScheduleWithDelayAndPeriod(timer);
		testScheduleAtFixedRateWithDateAndPeriod(timer);
		testScheduleAtFixedRateWithDelayAndPeriod(timer);
	}

	private static void testScheduleAtFixedRateWithDelayAndPeriod(Timer timer) {
		timer.scheduleAtFixedRate(new MyTimerTask(), 5000, 5000);
	}

	private static void testScheduleAtFixedRateWithDateAndPeriod(Timer timer) {
		timer.scheduleAtFixedRate(new MyTimerTask(), new Date(Timestamp.valueOf("2015-09-12 21:15:00").getTime()), 5000);
	}

	private static void testScheduleWithDelayAndPeriod(Timer timer) {
		timer.schedule(new MyTimerTask(), 5000, 5000);
	}

	private static void testScheduleWithDateAndPeriod(Timer timer) {
		timer.schedule(new MyTimerTask(), new Date(Timestamp.valueOf("2015-09-12 21:15:00").getTime()), 5000);
	}

	private static void testScheduleWithDelay(Timer timer) {
		timer.schedule(new MyTimerTask(), 5000);
	}

	private static void testScheduleWithDate(Timer timer) {
		timer.schedule(new MyTimerTask(), new Date(Timestamp.valueOf("2015-09-12 21:15:00").getTime()));
	}

	private static void testPurge() {
	}

	private static void testCancel() {
		Timer timer = new Timer();
		TimerTask timerTask = new MyTimerTaskWithCancel(timer);
		timer.schedule(timerTask, 5000);
	}

	public static class MyTimerTask extends TimerTask {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + ": task start");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": task end");
		}

	}

	public static class MyTimerTaskWithCancel extends TimerTask {

		private Timer timer;

		public MyTimerTaskWithCancel(Timer timer) {
			this.timer = timer;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + ": task start");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": task end");

			timer.cancel();
		}

	}

}
