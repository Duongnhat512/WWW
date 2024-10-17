package di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Address;
import entities.Employee;
import entities.Student;

public class DemoBean {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Address address = context.getBean("address", Address.class);
		Student student = context.getBean("student", Student.class);
		student.show();
		Employee employee = context.getBean("employee", Employee.class);
		employee.show();
	}
}
