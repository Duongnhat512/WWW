package entities;

public class Student extends Person{
	private String email;
	
	public Student(String id, String name, String email) {
		super(id, name);
		this.email = email;
	}
	
	public Student(String id, String name) {
		super(id, name);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void show() {
		System.out.println(super.getId() + " " + super.getName());
		System.out.println(email);
	}
}
