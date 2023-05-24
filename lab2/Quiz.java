/**
    Represents a quiz
 */

public class Quiz {
    private double maxGrade;
    private double studentGrade;

    public Quiz(double maxGrade, double studentGrade) {
        this.maxGrade = maxGrade;
        this.studentGrade = studentGrade;
    }

    public double getMaxGrade() {
        return this.maxGrade;
    }

    public double getStudentGrade() {
        return this.studentGrade;
    }
}