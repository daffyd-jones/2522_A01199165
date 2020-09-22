package ca.bcit.comp2522.labs.lab02;

public abstract class Animal implements Speakable {

    /**
     * speak.
     * the string the creature speaks
     */
    private String speak;

    /**
     * Animal.
     * assigns ... to speak
     */
    public Animal() {
        speak = "...";
    }

    /**
     * Animal.
     * Assigns parameter to speak
     *
     * @param s
     */
    public Animal(final String s) {
        speak = s;
    }

    /**
     * getSpeak.
     *
     * @return speak
     */
    public String getSpeak() {
        return speak;
    }

    /**
     * setSpeak.
     * sets this.speak to parameter
     *
     * @param s
     */
    public void setSpeak(final String s) {
        this.speak = s;
    }

    /**
     * speak.
     * prints speak
     */
    public void speak() {
        System.out.println(getSpeak());
    }

}
