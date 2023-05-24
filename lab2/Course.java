import java.util.ArrayList;

/**
    Represents a course.
 */
public class Course {
    private ArrayList<Student> students;

    /**
        Course consctructor. 
     */
    public Course() {
        students = new ArrayList<Student>();
    }

    /**
        Adds a student to the course.
        @param name First name.
        @param familyName Surname.
        @return A reference to the newly added student.
     */
    Student addStudent(String name, String familyName) {
        Student newStudent = new Student(name, familyName);
        students.add(newStudent);
        return newStudent;
    }

    /**
        Finds a student by student number.
        @param studentNumber The student number to search for.
        @return A reference to the student if found, or null if not found.
     */
    Student findStudent(long studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                return student;
            }
        }

        return null;
    }

    /**
        Deletes a student by student number. 
        @param studentNumber The student number to delete.
        @return A reference to the deleted student, or null if not found.
     */
    Student deleteStudent(long studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                students.remove(student);
                return student;
            }
        }

        return null;
    }

    /**
        Adds a quiz to a student.
        @param studentNumber The student number to add a quiz for.
        @param maxGrade The max grade of the quiz.
        @param studentGrade The grade the student achieved on the quiz.
        @return A boolean for if the quiz was successfully added. 
     */
    boolean addQuiz(long studentNumber, double maxGrade, double studentGrade) {
        Student stud = this.findStudent(studentNumber);

        if (stud != null) {
            stud.addQuiz(maxGrade, studentGrade);
            return true;
        } else {
            return false;
        }
    }

    /**
        Finds the student with the highest average quiz score in the course.
        @return The student with the highest average quiz score or null if there are no students. 
     */
    Student findTopStudent() {
        Student best = null;

        for (Student stud : students) {
            if ((best != null && stud.getQuizAverage() > best.getQuizAverage()) || best == null) {
                best = stud;
            }
        }

        return best;
    }

    /**
        Get the average quiz score of the course.
        @return The average quiz score of the course. 
     */
    double getAverage() {
        if (students.isEmpty()) {
            return 0;
        }

        double sum = 0;

        for (Student stud : students) {
            sum += stud.getQuizAverage();
        }

        return sum / students.size();
    }
}