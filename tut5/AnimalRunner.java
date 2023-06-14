import java.util.*;

public class AnimalRunner {
    public static void main(String[] args) {
        Dog d1 = new Dog("Fred");
        d1.speak();
        Object o = new Dog("Connie");
        Cat c1 = (Cat)o;
        c1.speak();
    }
}

interface Speakable {
    public void speak();
}

class Dog implements Speakable {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("Woof! Woof!");
    }
}

class Cat implements Speakable {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("Meow! Meow!");
    }
}
