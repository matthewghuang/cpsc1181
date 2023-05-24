import java.util.ArrayList;

public class Course {
    private ArrayList<Student> students;

    public Course() {
        students = new ArrayList<Student>();
    }

    Student addStudent(String name, String familyName) {
        Student newStudent = new Student(name, familyName);
        students.add(newStudent);
        return newStudent;
    }

    Student findStudent(long studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                return student;
            }
        }

        return null;
    }

    Student deleteStudent(long studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                students.remove(student);
                return student;
            }
        }

        return null;
    }

    boolean addQuiz(long studentNumber, double maxGrade, double studentGrade) {
        Student stud = this.findStudent(studentNumber);

        if (stud != null) {
            stud.addQuiz(maxGrade, studentGrade);
            return true;
        } else {
            return false;
        }
    }

    Student findTopStudent() {
        Student best = null;

        for (Student stud : students) {
            if ((best != null && stud.getQuizAverage() > best.getQuizAverage()) || best == null) {
                best = stud;
            }
        }

        return best;
    }

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