package clientpack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onmobile.training.aop.Sample;;

public class AnnotationTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("/aopAnnotation.xml");
		Sample sample=(Sample)ctx.getBean("sample");
		sample.doSomething();
	}
}
