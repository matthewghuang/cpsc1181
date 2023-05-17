/**
    Represents a student.
 */
public class Student {
    private String firstName;
    private String surName;
    private long studentNumber;
    private Address address;
    private double quizScores;
    private int numberOfQuizzes;

    /**
        Creates an instance of Student.
        @param firstName The first name of the student.
        @param surName The family name of the student.
        @param studentNumber The student number.
     */
    public Student(String firstName, String surName, long studentNumber) {
        this.firstName = firstName;
        this.surName = surName;
        this.studentNumber = studentNumber;
    }

    /**
        Sets the name of the student.
        @param firstName The new first name.
        @param surName The new surname.
     */
    public void setName(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    /**
        Returns the students name.
        @return The student name in the format firstName, surName.
     */
    public String getName() {
        return this.firstName + ", " + this.surName;
    }

    /**
        Returns the student number.
        @return The student number.
     */
    public long getStudentNumber() {
        return this.studentNumber;
    }

    /**
        Get the students login ID.
        @return The students login ID, with the format {first letter of first name}{first four letters of sur name}{last two digits of student number} (without curly braces).
     */
    public String getLoginId() {
        String firstPart = this.firstName.substring(0, 1).toLowerCase();
        String middlePart = this.surName.length() >= 4 ? this.surName.substring(0, 4).toLowerCase() : this.surName.toLowerCase();
        String studentNumberStr = Long.toString(this.studentNumber);
        String lastPart = studentNumberStr.substring(studentNumberStr.length() - 2);

        return String.format("%s%s%s", firstPart, middlePart, lastPart) ;
    }

    /**
        Get the students info.
        @return The students info in the format firstName, surName (loginId, studentNumber).
     */
    public String getInfo() {
        return String.format("%s, %s (%s, %s)", this.firstName, this.surName, this.getLoginId(), this.getStudentNumber());
    }

    /**
        Set the student address.
        @param number The building number.
        @param street The street.
        @param city The city.
        @param province The province.
        @param postalCode The postal code.
     */
    public void setAddress(String number, String street, String city, String province, String postalCode) {
        this.address = new Address(number, street, city, province, postalCode);
    }

    /**
        Get the student address.
        @return The student's address {number} {street}, {city}, {province}, {postalCode}.
     */
    public String getAddress() {
        return this.address.toString();
    }

    /**
        Add a quiz score.
        @param quiz The quiz score to add.
     */
    public void addQuiz(double quiz) {
        this.quizScores += quiz;
        this.numberOfQuizzes++;
    }

    /**
        Get the average of the student's quiz scores.
        @return The average.
     */
    public double getQuizAverage() {
        return this.quizScores / this.numberOfQuizzes;
    }

    /**
        Format the student as a string.
        @return The student's info in the format [{firstName}, {surName}, {studentNumber}, {loginId}].
     */
    public String toString() {
        return String.format("[%s, %s, %s, %s]", this.firstName, this.surName, this.getStudentNumber(), this.getLoginId());
    }
}