package clientpack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onmobile.training.School;
import com.onmobile.training.SchoolDAO;

public class SchoolTest {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
		SchoolDAO dao=(SchoolDAO)ctx.getBean("dao");
		School school=new School();
		school.setName("OnMobile");
		dao.setDatabase(school);
	}
}
