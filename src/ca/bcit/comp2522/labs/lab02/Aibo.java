package ca.bcit.comp2522.labs.lab02;

public class Aibo extends Robot implements Speakable {

    /**
     * speak.
     * Is the string that the creature speaks
     */
    private String speak;

    /**
     * Aibo.
     * assigns Woof to speak.
     */
    public Aibo() {
        speak = "Woof!";
    }

    /**
     * speak.
     * prints speak value
     */
    public void speak() {
        System.out.println(speak);
    }
}
