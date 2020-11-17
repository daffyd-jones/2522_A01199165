package ca.bcit.comp2522.labs.lab05;

public abstract class Vehicle {

  private String make;
  private String model;
  private int numPassengers;
  private int topSpeed;

  //
  public Vehicle() {
  }

  public Vehicle(final String make, final String model, final int numPass, final int topSpeed) {
    this.make = make;
    this.model = model;
    this.numPassengers = numPass;
    this.topSpeed = topSpeed;
  }

  @Override
  public String toString() {
    return "Vehicle{"
        + "make='" + make + '\''
        + ", model='" + model + '\''
        + ", numPassengers=" + numPassengers
        + ", topSpeed=" + topSpeed
        + '}';
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getNumPassengers() {
    return numPassengers;
  }

  public void setNumPassengers(int numPassengers) {
    this.numPassengers = numPassengers;
  }

  public int getTopSpeed() {
    return topSpeed;
  }

  public void setTopSpeed(int topSpeed) {
    this.topSpeed = topSpeed;
  }






}
