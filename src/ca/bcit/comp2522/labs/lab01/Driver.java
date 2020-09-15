package ca.bcit.comp2522.labs.lab01;

/**
 * Driver program.
 *
 * @author Benjamin Jones
 * @version 1
 *
 *  Drives the race program.
 *  uses Race, Tortoise, and Hare classes
 *  Contains: main, simulateRace
 *
 *
 */

public class Driver {

  /**
   * main.
   * runs the program.
   *
   * @param args
   */
  public static void main(String[] args) {

    Race firstRace = new Race(100);
    String firstWin = firstRace.simulateRace();
    System.out.println("The first Race: \nHare final Pos: " + firstRace.hare.getPos() + " | Tortoise Final pos: " + firstRace.tort.getPos() + "\nClock Ticks: " + firstRace.getRaceLength());
    System.out.println();

    simulateRace(100, 100);
    simulateRace(100, 1000);
  }


  /**
   * simulateRace.
   * simulates Hate and Tortoise races at:
   * "length" of race, "rep" of races.
   *
   * @param rep
   * @param length
   */
  public static void simulateRace(int rep, int length) {
    int r = 0;
    int t = 0;
    for (int i = 0; i < rep; i++) {
      Race hundRace = new Race(length);
      String hundWin = hundRace.simulateRace();
      boolean h = hundRace.getWhich();
      if (h) {
        r++;
      } else {
        t++;
      }
    }
    System.out.println(rep + " rounds of " + length + " length(Ticks)\nHare: " + r + " | Tortoise: " + t);
  }
}

/*
* the tortoise consistently won the races
*
* */
