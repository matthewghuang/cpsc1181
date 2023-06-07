import java.util.*;

public class CatsAndDogs3

{
	public static void main(String[] args)
	{
		ArrayList<Pets> dogcatList = new ArrayList<Pets>();
		dogcatList.add(new Dog("Fred"));
		dogcatList.add(new Cat("Wanda"));
		for (Pets pet : dogcatList) {
			pet.speak();
			pet.whatDoYouWant();
		}
	}
}

abstract class Pets {
	abstract public void speak();
	abstract public void whatDoYouWant();
}

//-------------------
class Dog extends Pets
{
	private String name;

	public Dog(String name)
	{
		this.name = name;
	}

	public void speak()
	{
		System.out.println("Woof! Woof!");
	}

	public void whatDoYouWant() {
		System.out.println(name + ": I like walking with you");
	}

	public String toString()
	{
		return "Dog:  " + name;
	}
}

//-------------------
class Cat extends Pets
{
	private String name;

	public Cat(String name)
	{
		this.name = name;
	}

	public void speak()
	{
		System.out.println("Meow! Meow!");
	}

	public void whatDoYouWant() {
		System.out.println(name + ": Leave me alone, I need a nap");
	}

	public String toString()
	{
		return "Cat:  " + name;
	}
}
