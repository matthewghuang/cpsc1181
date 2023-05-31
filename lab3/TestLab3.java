public class TestLab3{
	public static void main(String[] args){
		
		System.out.println("Test Faculty:");
		Faculty f1 = new Faculty("jack palace","jpalace@gmail.com","804 123 5888","A101",68000.00, Status.PART_TIME);
		System.out.println(f1);

		Faculty f2 = new Faculty("jack palace","jpalace@gmail.com","804 123 5888");
		System.out.println(f2);

		f2.setStatus(Status.FULL_TIME);
		System.out.println(f2.getStatus());
		f2.setOffice("C102");
		f2.setSalary(65000);
		System.out.println(f2);

		System.out.println("------------");
		System.out.println("Test Person:");
		Person p1 = new Person("Mary Poppins","mpoppins@gmail.com", "604 123 4567");
		System.out.println(p1);
		// add more test cases as required


		System.out.println("------------");
		System.out.println("Test Employee:");
		Employee e1 = new Employee("Bill Gates","bgates@gmail.com","641 888 7766","B303",45000.99);
		System.out.println(e1);
		// add more test cases as required
		

		System.out.println("------------");
		System.out.println("Test Stuff:");
		Employee s1 = new Employee("Clark Gable","cgable@gmail.com","1 800 888 8888","XB02",85600);
		System.out.println(s1);
		// add more test cases as required


		


	}
}
enum Status{TEMPORARY,PART_TIME, FULL_TIME};

class Person{
	private String name;
	private String email;
	private String phoneNumber;	

	public Person() {
	}

	public Person(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void modifyInfo(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	@Override
	public String toString() {
		return String.format("name: %s, email: %s, phone number: %s", name, email, phoneNumber);
	}
}

class Employee extends Person{
	private String office = "A101";
	private double salary = 40000;	

	public Employee() {
		super();
	}

	public Employee(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
	}

	public Employee(String name, String email, String phoneNumber, String office, double salary) {
		this(name, email, phoneNumber);
		this.office = office;
		this.salary = salary;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public String getOffice() {
		return office;
	}

	@Override
	public String toString() {
		return String.format("%s, office: %s, salary: %.2f", super.toString(), office, salary);
	}
}


class Faculty extends Employee{
	private Status status = Status.TEMPORARY;

	public Faculty() {
		super();
	}

	public Faculty(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
	}

	public Faculty(String name, String email, String phoneNumber, String office, double salary, Status status) {
		super(name, email, phoneNumber, office, salary);
		this.status = status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return String.format("%s, status: %s", super.toString(), status);
	}
}

class Staff extends Employee{
	private String position = "general";	

	public Staff() {
		super();
	}

	public Staff(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
	}

	public Staff(String name, String email, String phoneNumber, String office, double salary) {
		super(name, email, phoneNumber, office, salary);
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return String.format("%s, position: %s", super.toString(), position);
	}
}