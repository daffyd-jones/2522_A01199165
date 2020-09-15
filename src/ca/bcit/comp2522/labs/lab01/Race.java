package ca.bcit.comp2522.labs.lab01;

/**
 * Race.
 *
 * @author Ben Jones
 * @version 1
 *
 * Runs race
 * used by Driver
 * uses Hare and Tortoise
 * Contoins: race, reset, simulateRace, getWhich
 * getRaceLength, setRaceLength
 */

import java.util.Random;

public class Race {
  public Hare hare;
  public Tortoise tort;

  public int raceLength = 0;
  public boolean which = false;

  /**
   * constructor.
   *
   * takes in race length and instantiates the tortoise and hare.
   *
   * @param raceLength
   */
  public Race(int raceLength) {
    this.raceLength = raceLength;
    this.hare = new Hare();
    this.tort = new Tortoise();
  }

  /**
   * reset.
   * sets hare and tortoise pos to 0
   */
  public void reset() {
    hare.setPos(0);
    tort.setPos(0);
  }

  /**
   * race.
   * runs a race between tortoise and the hare and returns String
   *
   * @return String
   */
  private String race() {
    int i = 0;
    int clk = this.raceLength;
    while (clk >= i) {
      Random rand = new Random();
      int e = rand.nextInt() * 2;
      if (e > 1) {
        tort.move();
        hare.move();
      } else {
        hare.move();
        tort.move();
      }
      i++;
    }
    int r = hare.getPos();
    int t = tort.getPos();
    if (r > t) {
      which = true;
      return new String("The Hare Wins!");
    } else {
      return new String("The Tortoise Wins!");
    }
  }

  /**
   * getWhich.
   *
   * @return winner of race
   */
  public boolean getWhich() {
    return this.which;
  }

  /**
   * simulateRace.
   *
   * resets pos values for hare and tortoise then runs 'race'
   * @return String
   */
  public String simulateRace() {
    reset();
    return race();
  }


  /**
   * getRaceLength.
   *
   * @return raceLength
   */
  public int getRaceLength() {
    return this.raceLength;
  }

  /**
   * setRaceLength.
   *
   * @param raceLength
   *
   */
  public void setRaceLength(int raceLength) {
    this.raceLength = raceLength;
  }








}
