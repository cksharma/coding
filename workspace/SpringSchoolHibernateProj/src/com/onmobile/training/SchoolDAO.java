package com.onmobile.training;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class SchoolDAO {
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public List<?> findStudentsBySchool(String school)
	{
		String sql="from School where name=?";
		List<?> s=template.find(sql, school);
		return s;
	}

	public void setDatabase(School school) {
	//	template.save(school);
//		Address address=new Address("Bangalore", "JPNagar");
//		Person person=new Person("Me", "Male", address);
//		template.save(address);
//		template.save(person);
//		Address address2=new Address("Bangalore", "");
		
		Student student=new Student("rajesh","male",1);
		Set<Student> set=new HashSet<Student>();
		set.add(student);
		school.setStudents(set);
		template.save(school);
	}
}
