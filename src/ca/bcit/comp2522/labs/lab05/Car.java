package ca.bcit.comp2522.labs.lab05;
/*
 * Car.java
 */

public class Car extends Vehicle {

    private int mileage;

    /** Creates a new instance of Car */
    public Car() {
    }
    public Car(String make, String model, int numPassengers, int topSpeed, int mileage) {
        super(make, model, numPassengers, topSpeed);
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

}
