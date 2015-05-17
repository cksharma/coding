package clientpack;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onmobile.training.Address;
import com.onmobile.training.School;
import com.onmobile.training.Student;
import com.onmobile.training.Teacher;

public class SchoolTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		School school = (School) ctx.getBean("school");
		System.out.println();
		System.out.println("School Name " + school.getName());
		Address address = school.getAddress();
		System.out.println();
		System.out.println("School Address");
		System.out.println("Location " + address.getLocation());
		System.out.println("City " + address.getCity());
		List<Student> students = school.getStudents();
		System.out.println();
		System.out.println("Students Information");
		for (Student stud : students) {
			Address add = stud.getAddress();
			System.out.println(stud.getName() + "\t" + stud.getGender() + "\t" + stud.getRollNumber());
			System.out.println("Student address" + add.getLocation() + "\t" + add.getCity());
		}

		List<Teacher> teachers = school.getTeachers();
		System.out.println();
		System.out.println("Teacher's Details");
		for (Teacher teach : teachers) {
			Address add1 = teach.getAddress();
			System.out.println(teach.getName() + "\t" + teach.getGender() + "\t" + teach.getSubject());
			System.out.println("Teacher address" + add1.getLocation() + "\t" + add1.getCity());
		}
		System.out.println();
	}
}
