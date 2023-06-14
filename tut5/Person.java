import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private Memory mem;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        mem = new Memory(name, age);
    }

    public String toString() {
        return "Name: " + name + '\n' +
                "Age: " + age + '\n';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void tellAll() {
        mem.dumpMemory();
    }

    public void rememberAnEvent(String s) {
        mem.addLifeData(s);
    }
}

class Memory {
    private ArrayList<String> lifeData;

    public Memory(String name, int age) {
        lifeData = new ArrayList<String>();
        lifeData.add("Name:" + name);
        lifeData.add("Age:" + age);
    }

    public void addLifeData(String datum) {
        lifeData.add(datum);
    }

    public void dumpMemory() {
        for (String s : lifeData) {
            System.out.println(s);
        }
    }
}