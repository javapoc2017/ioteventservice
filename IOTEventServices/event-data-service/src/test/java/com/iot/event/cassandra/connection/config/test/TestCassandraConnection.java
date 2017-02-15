package com.iot.event.cassandra.connection.config.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.semisol.data.dao.api.OrganizationDAO;

public class TestCassandraConnection {
	public static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		try {
			context = new AnnotationConfigApplicationContext("com.semisol.data");
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testCase() {
		try {
			System.out.println("caling OrganizationDAO");
			OrganizationDAO organizationDAO= context.getBean(OrganizationDAO.class);
			System.out.println("caling OrganizationDAO...");
			organizationDAO.saveOrganizationData();
			Thread.sleep(500000);
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
