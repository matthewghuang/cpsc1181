import java.util.ArrayList;

/**
    Represents a student.
 */
public class Student {
    private String firstName;
    private String surName;
    private long studentNumber;
    private ArrayList<Quiz> quizzes;
    private static long count = 10000001;

    /**
        Creates an instance of Student.
        @param firstName The first name of the student.
        @param surName The family name of the student.
     */
    public Student(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
        this.studentNumber = this.count;
        this.count++;
        this.quizzes = new ArrayList<Quiz>();
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
        Add a quiz score.
        @param maxGrade The max grade of the quiz.
        @param studentGrade What the student achieved in the quiz.
     */
    public void addQuiz(double maxGrade, double studentGrade) {
        this.quizzes.add(new Quiz(maxGrade, studentGrade));
    }

    /**
        Get the average of the student's quiz scores.
        @return The average.
     */
    public double getQuizAverage() {
        double sum = 0;

        for (Quiz quiz : this.quizzes) {
            // add normalized grade
            sum += quiz.getStudentGrade() / quiz.getMaxGrade();
        }

        return this.quizzes.isEmpty() ? 0 : (sum / this.quizzes.size());
    }

    /**
        Format the student as a string.
        @return The student's info in the format [{firstName}, {surName}, {studentNumber}, {loginId}].
     */
    public String toString() {
        return String.format("[%s, %s, %s, %s]", this.firstName, this.surName, this.getStudentNumber(), this.getLoginId());
    }
}