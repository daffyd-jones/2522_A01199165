package ca.bcit.comp2522.assignments.a2;
import java.util.ArrayList;
import java.util.Random;

/**
 * Ecosystem.
 * simulates pools
 * @author Ben Jones
 * @version 1
 */



public class Ecosystem {
  /**
   * pools.
   * array of pools
   */
  private ArrayList<Pool> pools;

  /**
   * Ecosystem Constructor.
   * instantiates pools
   */
  public Ecosystem() {
    pools = new ArrayList<Pool>();
  }

  /**
   * addPool.
   * adds param pool to pools
   * @param newPool // pool to add
   */
  public void addPool(Pool newPool) {
    if (newPool != null) {
      pools.add(newPool);
    }
  }

  /**
   * reset.
   * resets the ecosystem by clearing pools.
   */
  public void reset() {
    pools.clear();
  }

  /**
   * getGuppyPopulation.
   * adds total pop for pools
   * @return int
   */
  public int getGuppyPopulation() {
    int gupsNo = 0;
    for (Pool pool : pools) {
      gupsNo += pool.getPopulation();
    }
    return gupsNo;
  }

  /**
   * adjustForCrowding.
   * kills the weak fish due to crowding
   * @return int
   */
  public int adjustForCrowding() {
    int ded = 0;
    for (Pool pool: pools) {
      ded += pool.adjustForCrowding();
    }
    return ded;
  }

  /**
   * setupSimulation.
   * sets up eco simulation
   */
  public void setupSimulation() {

    Pool p1 = new Pool("Skookumchuk",
        3000, 42, 7.9, 0.9);
    Pool p2 = new Pool("Squamish", 15000,
        39, 7.7, 0.85);
    Pool p3 = new Pool("Semiahmoo",
        4500, 37, 7.5, 1.0);
    Random rand = new Random();
    for (int i = 0; i < 300; i++) {
      int weekTemp = rand.nextInt((25 - 10) + 1) + 10;
      double healthTemp = rand.nextDouble() * (0.7999 - 0.5) + 0.5;
      double gurl = rand.nextDouble();
      boolean gurll = false;
      if (gurl < 0.75) {
        gurll = true;
      }
      Guppy temp = new Guppy("Poecilia", "reticulata", weekTemp, gurll,
          0, healthTemp);
      p1.addGuppy(temp);
    }
    for (int i = 0; i < 100; i++) {
      int weekTemp = rand.nextInt((15 - 10) + 1) + 10;
      double healthTemp = rand.nextDouble() * (0.8 - 0.999) + 0.8;
      double gurl = rand.nextDouble();
      boolean gurll = false;
      if (gurl < 0.75) {
        gurll = true;
      }
      Guppy temp = new Guppy("Poecilia", "reticulata", weekTemp, gurll,
          0, healthTemp);
      p2.addGuppy(temp);
    }
    for (int i = 0; i < 200; i++) {
      int weekTemp = rand.nextInt((49 - 15) + 1) + 15;
      double healthTemp = rand.nextDouble() * (0.9999 - 0.0) + 0.0;
      double gurl = rand.nextDouble();
      boolean gurll = false;
      if (gurl < 0.35) {
        gurll = true;
      }
      Guppy temp = new Guppy("Poecilia", "reticulata", weekTemp, gurll,
          0, healthTemp);
      p3.addGuppy(temp);
    }
    addPool(p1);
    addPool(p2);
    addPool(p3);
  }

  /**
   * simulate.
   * runs simulateOneWeek
   * @param numberOfWeeks /// number of weeks to run
   */
  public void simulate(int numberOfWeeks) {
    for (int i = 0; i < numberOfWeeks; i++) {
      simulateOneWeek(i);
    }
  }

  /**
   * simulateOneWeek.
   * updates and runs methods once and prints out results
   * @param i / number of weeks
   */
  public void simulateOneWeek(int i) {
    int diedOfOldAge = 0;
    int numberRemoved = 0;
    int starvedToDeath = 0;
    int newFry = 0;
    int crowdedOut = 0;
    boolean match = false;
    for (Pool pool: pools) {
      diedOfOldAge += pool.incrementAges();
      numberRemoved += pool.removeDeadGuppies();
      starvedToDeath += pool.applyNutrientCoefficient();
      numberRemoved += pool.removeDeadGuppies();
      newFry += pool.spawn();
      crowdedOut += pool.adjustForCrowding();
      numberRemoved += pool.removeDeadGuppies();
    }
    if (numberRemoved == (diedOfOldAge + starvedToDeath + crowdedOut)) {
      match = true;
    }
    System.out.println("Week Number: " + i + "\nAge Deaths: "
          + diedOfOldAge + "\nStarving Deaths: " + starvedToDeath
          + "\n Overcrowding Deaths: " + crowdedOut + "\nBirths: "
          + newFry);
    for (Pool pool : pools) {
      System.out.println(pool.getName() + " : " + pool.getPopulation());
    }
    System.out.println("Total Guppy pop: " + getGuppyPopulation());

  }




}


