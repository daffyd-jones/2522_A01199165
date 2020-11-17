package ca.bcit.comp2522.labs.lab05;
/*
 * Submarine.java
 */

public class Submarine extends Vehicle {

    private int maxDepth;

    /** Creates a new instance of Submarine */
    public Submarine() {
    }
    public Submarine(String make, String model, int topSpeed, int numPassengers, int maxDepth) {
        super(make, model, numPassengers, topSpeed);
        this.maxDepth = maxDepth;
    }

    @Override
    public String toString() {
        return super.toString()
            + ", maxDepth=" + maxDepth
            + '}';
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

}
