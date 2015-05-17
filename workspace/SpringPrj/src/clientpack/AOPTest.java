package clientpack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onmobile.training.aop.Instrumentalist;

public class AOPTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/aopAppCtx.xml");
		Instrumentalist inst = (Instrumentalist) ctx.getBean("inst");
		inst.play("In the END");
		inst.play();
	}
}