package entities;

public class Employee extends Person {
	private Address address;

	public Employee(String id, String name, Address address) {
		super(id, name);
		this.address = address;
	}

	public Employee(String id, String name) {
		super(id, name);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public void show() {
		System.out.println(super.getId() + " " + super.getName());
		System.out.println(address.toString());
	}

}
