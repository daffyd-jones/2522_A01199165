package ca.bcit.comp2522.labs.lab02;

public class Poodle extends Dog implements IncessantSpeakable {

    /**
     * Poodle.
     * speaks arf arf
     */
    public Poodle() {
        setSpeak("Arf arf!");
    }

    /**
     * speak.
     * prints speak
     */
    public void speak() {
        System.out.println(getSpeak());
    }

    /**
     * loudSpeak.
     * says speak in uppercase
     */
    public void loudSpeak() {
        System.out.println(getSpeak().toUpperCase());
    }
}
