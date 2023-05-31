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

/**
	Represents a person
 */
class Person{
	private String name;
	private String email;
	private String phoneNumber;	

	/**
		Default constructor
	 */
	public Person() {
	}

	/**
		Creates a person
		@param name The person's name.
		@param email The person's email.
		@param phoneNumber The person's phone number.
	 */
	public Person(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/**
		Modify a person's info
		@param name The new name.
		@param email The new email.
		@param phoneNumber The new phone number.
	 */
	public void modifyInfo(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/**
		Get the name.
		@return The person's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
		Get the email.
		@return The person's email.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
		Get the phone number.
		@return The person's phone number.
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
		Represent the person as a String.
		@return Person in a String in the format "name: %s, email: %s, phone number: %s".
	 */
	@Override
	public String toString() {
		return String.format("name: %s, email: %s, phone number: %s", name, email, phoneNumber);
	}
}

/**
	Represents an employee with a default office of A101 and a salary of 40000.
 */
class Employee extends Person{
	private String office = "A101";
	private double salary = 40000;	

	/**
		Empty constructor.
	 */
	public Employee() {
		super();
	}

	/**
		Creates an employee.
		@param name The employee's name.
		@param email The employee's email.
		@param phoneNumber The employee's phone number.
	 */
	public Employee(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
	}

	/**
		Creates an employee.
		@param name The employee's name.
		@param email The employee's email.
		@param phoneNumber The employee's phone number.
		@param office The employee's office.
		@param salary The employee's salary.
	 */
	public Employee(String name, String email, String phoneNumber, String office, double salary) {
		this(name, email, phoneNumber);
		this.office = office;
		this.salary = salary;
	}

	/**
		Set the employee's office.
		@param office The new office.	
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
		Set the employee's salary.
		@param salary The new salary.
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
		Get the employee's salary.
		@return The salary.	
	 */
	public double getSalary() {
		return salary;
	}

	/**
		Get the employee's office.
		@return The office.	
	 */
	public String getOffice() {
		return office;
	}

	/**
		Represent the employee as a String.
		@return Employee in a String in the format "name: %s, email: %s, phone number: %s, office: %s, salary: %.2f".
	 */
	@Override
	public String toString() {
		return String.format("%s, office: %s, salary: %.2f", super.toString(), office, salary);
	}
}


class Faculty extends Employee{
	private Status status = Status.TEMPORARY;

	/**
     * Constructs a new Faculty object with default values.
     */
	public Faculty() {
		super();
	}

	/**
     * Constructs a new Faculty object with the specified name, email, and phone number.
     *
     * @param name         the name of the faculty member
     * @param email        the email address of the faculty member
     * @param phoneNumber  the phone number of the faculty member
     */
	public Faculty(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
	}

	/**
     * Constructs a new Faculty object with the specified name, email, phone number, office, salary, and status.
     *
     * @param name         the name of the faculty member
     * @param email        the email address of the faculty member
     * @param phoneNumber  the phone number of the faculty member
     * @param office       the office location of the faculty member
     * @param salary       the salary of the faculty member
     * @param status       the employment status of the faculty member
     */
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