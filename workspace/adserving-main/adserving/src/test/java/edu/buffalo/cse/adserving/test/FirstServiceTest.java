package edu.buffalo.cse.adserving.test;

import edu.buffalo.cse.adserving.app.context.AdservingWebApplicationContext;
import edu.buffalo.cse.adserving.services.FirstService;

public class FirstServiceTest extends BaseTest {

	@org.junit.Test
	public void firstServiceTest() throws Exception {
					
		FirstService firstSrv = AdservingWebApplicationContext.getBean("firstService", FirstService.class);
		
		String response = firstSrv.getFirstResponse("cksharma.skt@gmail.com");
		
		System.out.println("Data : " + response);
	}
}
