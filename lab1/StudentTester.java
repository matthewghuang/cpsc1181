/**
	StudentTester tests class Student and class Address 

*/
class StudentTester{
	public static void main(String[] args){
		// test Student constructor
		Student student = new Student("Matthew","Huang",100380151);
		System.out.println(student); 

		// test Student getName, geyStudentNumber(), getLoginId()
		System.out.println(student.getName());
		System.out.println(student.getStudentNumber());
		System.out.println(student.getLoginId());


		// test Student getInfo()
		System.out.println(student.getInfo());

		// test Student addQuiz and getAverage
		student.addQuiz(6.0);
		student.addQuiz(8.5);
		student.addQuiz(9.8);
		System.out.println(student.getQuizAverage());

		// add your test cases:
		// test Student setAddress and getAddress
		student.setAddress("8483", "Ontario St.", "Vancouver", "BC", "V8J 3P2");
		System.out.println(student.getAddress());

		// test Student setName and getName
		student.setName("David", "Wong");
		System.out.println(student.getName());
	}
}
