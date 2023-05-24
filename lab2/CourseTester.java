public class CourseTester {
    public static void main(String[] args) {
        long count = 10000001;
        Course cpsc1181 = new Course();

        System.out.println("addStudent: adding student Matthew Huang");
        cpsc1181.addStudent("Matthew", "Huang");

        System.out.println("findStudent: find the student we just made");
        Student matthewHuang = cpsc1181.findStudent(count);
        System.out.println("it should be [Matthew, Huang, 10000001, mhuan01]");
        System.out.println(matthewHuang.toString());

        System.out.println("addQuiz: adding 100% quiz score");
        cpsc1181.addQuiz(count, 12, 12);
        System.out.println("getAverage: it should be 1");
        System.out.println(cpsc1181.getAverage());

        System.out.println("addQuiz: adding 0% quiz score");
        cpsc1181.addQuiz(count, 12, 0);
        System.out.println("getAverage: it should be 0.5");
        System.out.println(cpsc1181.getAverage());

        System.out.println("addStudent: add a new student named David Wong");
        Student davidWong = cpsc1181.addStudent("David", "Wong");
        count++;
        System.out.println("addQuiz: adding 100% quiz score");
        cpsc1181.addQuiz(count, 1, 1);
        System.out.println("getAverage: it should be 0.75");
        System.out.println(cpsc1181.getAverage());

        System.out.println("deleteStudent: delete David Wong");
        Student deleted = cpsc1181.deleteStudent(count);
        System.out.println("it should be true");
        System.out.println(deleted == davidWong);

        System.out.println("deleteStudent: delete a student that doesn't exist");
        Student deleted2 = cpsc1181.deleteStudent(count);
        System.out.println("it should be false");
        System.out.println(deleted2 == davidWong);
    }
}