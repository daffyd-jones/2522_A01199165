package ca.bcit.comp2522.labs.lab05;

public class SpyCar extends Submarine {

  private int mileage;

  public SpyCar(final String make, final String model, final int numPassengers,
                final int topSpeed, final int maxDepth, final int  mileage) {
    super(make, model, numPassengers, topSpeed, maxDepth);
    this.mileage = mileage;
  }



}
