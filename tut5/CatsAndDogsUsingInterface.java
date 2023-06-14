import java.util.*;

/**
Interface vs abstract class
- In this program they are not so different.
- The interface version is simpler, so there is less code to write.
- If there was more complicated functionality an abstract class might be useful to add instance variables,
- You can only extend one class but you can implement many interfaces
   - There could be interface Speakable and interface WhatDoYouWant
 */

public class CatsAndDogsUsingInterface
{
   public static void main(String[] args)
   {
      ArrayList<MyPets> dogcatList = new ArrayList<MyPets>();

      dogcatList.add(new Dog("Fred"));
      dogcatList.add(new Cat("Wanda"));

      for (MyPets pet : dogcatList) {
         pet.speak();
         pet.whatDoYouWant();
      }
   }
}
//------
// create interface
interface MyPets {
   void speak();
   void whatDoYouWant();
}

//-------------------
class Dog implements MyPets
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
class Cat implements MyPets
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
