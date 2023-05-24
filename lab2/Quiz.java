/**
    Represents a quiz
 */

public class Quiz {
    private double maxGrade;
    private double studentGrade;

    /**
        Construct a quiz.
        @param maxGrade The max grade of the quiz.
        @param studentGrade The grade the student achieved in the quiz. 
     */
    public Quiz(double maxGrade, double studentGrade) {
        this.maxGrade = maxGrade;
        this.studentGrade = studentGrade;
    }

    /**
        Get the max grade of the quiz.
        @return The max grade of the quiz. 
     */
    public double getMaxGrade() {
        return this.maxGrade;
    }

    /**
        Get the student's grade on the quiz.
        @return The student grade. 
     */
    public double getStudentGrade() {
        return this.studentGrade;
    }
}