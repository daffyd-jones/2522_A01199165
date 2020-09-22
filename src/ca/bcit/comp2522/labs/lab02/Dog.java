package ca.bcit.comp2522.labs.lab02;

public class Dog extends Animal {

    /**
     * Dog.
     * uses animal to say woof.
     */
    public Dog() {
        //speak = "Meow!";
        super("Woof woof!");
    }

    /**
     * speak.
     * prints speak value
     */
    public void speak() {
        System.out.println(getSpeak());
    }
}
