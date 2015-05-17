package clientpack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onmobile.training.Shape;

public class ShapeTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		Shape shape1 = (Shape) ctx.getBean("rectangle");
		System.out.println("Area: " + shape1.area());
		Shape shape2 = (Shape) ctx.getBean("circle");
		System.out.println("Area: " + shape2.area());
		Shape shape3 = (Shape) ctx.getBean("rectangle");
		System.out.println(shape1 == shape3);
	}
}
