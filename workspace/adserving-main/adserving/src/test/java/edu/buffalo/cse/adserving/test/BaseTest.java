package edu.buffalo.cse.adserving.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.buffalo.cse.adserving.app.context.AdservingWebApplicationContext;


public class BaseTest {
	Log log = LogFactory.getLog(BaseTest.class);
	private static ApplicationContext ctx;
	
	static {
		ctx = new ClassPathXmlApplicationContext("adserving-beans-test.xml");
		AdservingWebApplicationContext.setContext(ctx);
	}

	public ApplicationContext getApplicationContext() {
		if (ctx == null) {
			throw new IllegalStateException("Application Context not set");
		}
		return ctx;
	}
}
