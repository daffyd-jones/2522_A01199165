package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

/**
 * Driver.
 * runs guppy environment
 * @author Ben Jones
 * @version 1
 */
public class Driver {


  /**
   * main.
   * runs the program
   * @param args unused
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Ecosystem eco = new Ecosystem();
    System.out.println("How many weeks would you like to run the simulation?");
    int num = scan.nextInt();
    eco.setupSimulation();
    eco.simulate(num);
  }
}
