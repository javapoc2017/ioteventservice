package com.iot.event.subscriber.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iot.event.subscriber.EventSubscriber;
import com.iot.event.subscriber.MQTTConfig;

public class TestEventConsumer {
	public static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		try {
			context = new AnnotationConfigApplicationContext(MQTTConfig.class,EventSubscriber.class);
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testCase() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass
	public static void destroy() {
		if (context != null) {
			context.close();
		}
	}
}
