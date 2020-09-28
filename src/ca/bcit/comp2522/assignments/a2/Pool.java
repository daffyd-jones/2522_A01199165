package ca.bcit.comp2522.assignments.a2;
/**
 * Pool.
 * simulates a pool full of guppies
 * @author Ben Jones
 * @version 1
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Pool {

  /**
   * DEFAULT_POOL_NAME.
   * "unnamed'
   */
  public static final String DEFAULT_POOL_NAME  = "Unnamed";
  /**
   * DEFAULT_POOL_TEMP_CELSIUS.
   * 40.0
   */
  public static final double DEFAULT_POOL_TEMP_CELSIUS  = 40.0;
  /**
   * MAXIMUM_POOL_TEMP_CELSIUS.
   * 0.0
   */
  public static final double MINIMUM_POOL_TEMP_CELSIUS  = 0.0;
  /**
   * MAXIMUM_POOL_TEMP_CELSIUS.
   * 100.0
   */
  public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;
  /**
   * NEUTRAL_PH.
   * 7.0
   */
  public static final double NEUTRAL_PH = 7.0;
  /**
   * DEFAULT_NUTRIENT_COEFFICIENT.
   * 0.50
   */
  public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;
  /**
   * MINIMUM_NUTRIENT_COEFFICIENT.
   * 0.0
   */
  public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
  /**
   * MAXIMUM_NUTRIENT_COEFFICIENT.
   * 1.0
   */
  public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

  /**
   * name.
   * represents the pools name
   */
  private final String name;
  /**
   * volumeLiters.
   * represents the volume of water in pool
   */
  private double volumeLiters;
  /**
   * temperatureCelsius.
   * the temperature of the water
   */
  private double temperatureCelsius;
  /**
   * pH.
   * the ph of the water
   */
  private double pH;
  /**
   * nutrientCoefficient.
   * the quality of the water
   */
  private double nutrientCoefficient;
  /**
   * identificationNumber.
   * the number id of the pool
   */
  private final int identificationNumber;
  /**
   * guppiesInPool.
   * the number of guppies in the pool
   */
  private final ArrayList<Guppy> guppiesInPool;
  /**
   * randomNumberGenerator.
   * random number generator to simulate chance
   */
  private final Random randomNumberGenerator;
  /**
   * number of pools.
   * static var
   * number of pools in operation
   */
  private static int numberOfPools;

  /**
   * Pool Constructor.
   * Sets default values and instantiates
   * guppiesInPool and randomNumberGenerator
   */
  public Pool() {
    this.name = DEFAULT_POOL_NAME;
    this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
    this.pH = NEUTRAL_PH;
    this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
    this.guppiesInPool = new ArrayList<>();
    this.randomNumberGenerator = new Random();
    numberOfPools++;
    this.identificationNumber = numberOfPools;
  }

  /**
   * Pool Constructor.
   * sets values for following perameters
   * @param name
   * @param volumeLiters
   * @param tempCels
   * @param pH
   * @param nutrientCo
   * instantiates guppiesInPool and randomNumberGenerator
   * adds one to numberOfPools and assigns resultant value to
   * identificationNumber
   */
  public Pool(String name, double volumeLiters, double tempCels,
               double pH, double nutrientCo) {
    if (name != null && !name.isBlank() && !name.isEmpty()) {
      name = name.replaceAll("\\s", "");
      String cap = name.substring(0, 1);
      String end = name.substring(1, name.length() - 1);
      this.name = cap + end;
    } else {
      throw new IllegalArgumentException("Name must not be blank, ws or null");
    }
    if (volumeLiters < 0.0) {
      this.volumeLiters = 0.0;
    } else {
      this.volumeLiters = volumeLiters;
    }
    if (tempCels < MINIMUM_POOL_TEMP_CELSIUS) {
      this.temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;
    } else if (tempCels > MAXIMUM_POOL_TEMP_CELSIUS) {
      this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
    } else {
      this.temperatureCelsius = tempCels;
    }
    if (pH < 0.0 || pH > 14.0) {
      this.pH = NEUTRAL_PH;
    } else {
      this.pH = pH;
    }
    if (nutrientCo > 1.0 || nutrientCo < 0) {
      this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
    } else {
      this.nutrientCoefficient = nutrientCo;
    }
    this.guppiesInPool = new ArrayList<>();
    this.randomNumberGenerator = new Random();
    numberOfPools++;
    this.identificationNumber = numberOfPools;
  }

  /**
   * getName.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * getVolumeLiters.
   * @return volumeLiters
   */
  public double getVolumeLiters() {
    return volumeLiters;
  }

  /**
   * getTemperatureCelsius.
   * @return temperatureCelsius
   */
  public double getTemperatureCelsius() {
    return temperatureCelsius;
  }

  /**
   * getpH.
   * @return ph
   */
  public double getpH() {
    return pH;
  }

  /**
   * getNutrientCoefficient.
   * @return nutrientCoefficient
   */
  public double getNutrientCoefficient() {
    return nutrientCoefficient;
  }

  /**
   * getIdentificationNumber.
   * @return identificationNumber
   */
  public int getIdentificationNumber() {
    return identificationNumber;
  }

  /**
   * setVolumeLiters.
   * sets volumeLiters to parameter value if > 0
   * @param volumeLiters
   */
  public void setVolumeLiters(double volumeLiters) {
    if (volumeLiters > 0.0) {
      this.volumeLiters = volumeLiters;
    }
  }

  /**
   * setTemperatureCelsius.
   * sets temperatureCelsius to parameter value if within bounds
   * @param temperatureCelsius
   */
  public void setTemperatureCelsius(double temperatureCelsius) {
    if (temperatureCelsius < MAXIMUM_POOL_TEMP_CELSIUS && temperatureCelsius
        > MINIMUM_POOL_TEMP_CELSIUS) {
      this.temperatureCelsius = temperatureCelsius;
    }
  }

  /**
   * setpH.
   * sets pH to parameter if within 0.0 - 14.0
   * @param pH
   */
  public void setpH(double pH) {
    if (pH > 0.0 && pH < 14.0) {
      this.pH = pH;
    }
  }

  /**
   * setNutrientCoefficient.
   * sets ntrientCoefficient to param value if 0.0 - 1.0
   * @param nutrientCoefficient
   */
  public void setNutrientCoefficient(double nutrientCoefficient) {
    if (nutrientCoefficient > 0 && nutrientCoefficient < 1.0) {
      this.nutrientCoefficient = nutrientCoefficient;
    }
  }

  /**
   * changeNutrientCoefficient.
   * changes nutrientCoefficient to param value if within bounds
   * @param delta
   */
  public void changeNutrientCoefficient(double delta) {
    if (delta < MINIMUM_NUTRIENT_COEFFICIENT) {
      this.nutrientCoefficient = MINIMUM_NUTRIENT_COEFFICIENT;
    } else if (delta > MAXIMUM_NUTRIENT_COEFFICIENT) {
      this.nutrientCoefficient = MAXIMUM_NUTRIENT_COEFFICIENT;
    } else {
      this.nutrientCoefficient += delta;
    }
  }

  /**
   * changeTemperature.
   * sets temperatureCensius to param value if within bounds
   * @param delta
   */
  public void changeTemperature(double delta) {
    if (delta < MINIMUM_POOL_TEMP_CELSIUS) {
      this.temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;
    } else if (delta > MAXIMUM_NUTRIENT_COEFFICIENT) {
      this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
    } else {
      this.temperatureCelsius = delta;
    }
  }

  /**
   * getNumberCreated.
   * gets nnumber of pools
   * @return
   */
  public static int getNumberCreated() {
    return numberOfPools;
  }

  /**
   * addGuppy.
   * adds parameter Guppy to guppiesInPool
   * @param guppy
   * @return boolean
   */
  public boolean addGuppy(Guppy guppy) {
    if (guppy == null) {
      return false;
    } else {
      guppiesInPool.add(guppy);
    }
    if (guppiesInPool.contains(guppy)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * getPopulation.
   * counts the number of living guppies
   * @return noOfGups
   */
  public int getPopulation() {
    int noOfGups = 0;
    for (Guppy guppy : guppiesInPool) {
      if (guppy.isAlive()) {
        noOfGups++;
      }
    }
    return noOfGups;
  }

  /**
   * applyNutrientCoefficient.
   * applies nutrient goefficient and kills those who dont make the cut
   * @return deaths
   */
  public int applyNutrientCoefficient() {
    Iterator<Guppy> iter = guppiesInPool.iterator();
    int deaths = 0;
    while (iter.hasNext()) {
      double temp = randomNumberGenerator.nextDouble();
      if (temp > this.nutrientCoefficient) {
        iter.next().setIsAlive(false);
        deaths++;
      }
    }
    return deaths;
  }

  /**
   * removeDeadGuppies.
   * removes dead guppies from pool array
   * @return removed
   */
  public int removeDeadGuppies() {
    Iterator<Guppy> iter = guppiesInPool.iterator();
    int removed = 0;
    while (iter.hasNext()) {
      if (!iter.next().isAlive()) {
        iter.remove();
        removed++;
      }
    }
    return removed;
  }

  /**
   * getGuppyVolumeRequirementInLiters.
   * gets volume neeeded for total number of fish
   * @return needed
   */
  public double getGuppyVolumeRequirementInLiteres() {
    Iterator<Guppy> iter = guppiesInPool.iterator();
    int needed = 0;
    while (iter.hasNext()) {
      needed += iter.next().getVolumeNeeded();
    }
    needed /= 1000;
    return needed;
  }

  /**
   * getAverageAgeInWeeks.
   * returns the average age of guppies in pool
   * @return average
   */
  public double getAverageAgeInWeeks() {
    double ages = 0.0;
    Iterator<Guppy> it = guppiesInPool.iterator();
    while (it.hasNext()) {
      ages += it.next().getAgeInWeeks();
    }
    return ages / guppiesInPool.size();
  }

  /**
   * getAverageHealthCoefficient.
   * average health of pool
   * @return health
   */
  public double getAverageHealthCoefficient() {
    double health = 0.0;
    Iterator<Guppy> it = guppiesInPool.iterator();
    while (it.hasNext()) {
      health += it.next().getHealthCoefficient();
    }
    return health / guppiesInPool.size();
  }

  /**
   * getFemalePercentage.
   * returns percentage of females in array
   * @return fem
   */
  public double getFemalePercentage() {
    double fem = 0.0;
    Iterator<Guppy> it = guppiesInPool.iterator();
    while (it.hasNext()) {
      if (it.next().isFemale()) {
        fem++;
      }
    }
    return (fem / guppiesInPool.size()) * 100;
  }

  /**
   * getMedianAge.
   * returns median age in pool
   * @return medAge
   */
  public double getMedianAge() {
    double medAge = 0.0;
    Collections.sort(guppiesInPool, Guppy.ageComparator);
    if (guppiesInPool.size() % 2 == 0) {
      medAge = guppiesInPool.get(guppiesInPool.size() / 2).getAgeInWeeks()
          + guppiesInPool.get(guppiesInPool.size() / 2 - 1).getAgeInWeeks();
    } else {
      medAge = guppiesInPool.get(guppiesInPool.size() / 2).getAgeInWeeks();
    }
    return medAge;
  }

  /**
   * toString.
   * returns string with pool info
   * @return
   */
  @Override
  public String toString() {
    return "Pool{"
        + "name='" + name + '\''
        + ", volumeLiters=" + volumeLiters
        + ", temperatureCelsius=" + temperatureCelsius
        + ", pH=" + pH
        + ", nutrientCoefficient=" + nutrientCoefficient
        + ", identificationNumber=" + identificationNumber
        + ", guppiesInPool=" + guppiesInPool
        + ", randomNumberGenerator=" + randomNumberGenerator
        + '}';
  }

  /**
   * spawn.
   * iterates through guppies and spawns babies for females
   * @return newBabes
   */
  public int spawn() {
    Iterator<Guppy> it = guppiesInPool.iterator();
    int newBabes = 0;
    while (it.hasNext()) {
      ArrayList<Guppy> babes;
      if (it.next().spawn() == null) {
        break;
      } else {
        babes = it.next().spawn();
        newBabes += babes.size();
        guppiesInPool.addAll(babes);
      }
    }
    return newBabes;
  }

  /**
   * incrementAges.
   * increments the age of guppies and returns death
   * @return deaths
   */
  public int incrementAges() {
    Iterator<Guppy> it = guppiesInPool.iterator();
    int deaths = 0;
    while (it.hasNext()) {
      it.next().incrementAge();
      if (!it.next().isAlive()) {
        deaths++;
      }
    }
    return deaths;
  }

  /**
   * adjustForCrowding.
   * compares volumeLiters and total volume needed by guppies.
   * while volume needed is over current vol, weakest guppy is removed
   * @return died
   */
  public int adjustForCrowding() {
    Collections.sort(guppiesInPool, Guppy.healthComparator);
    int died = 0;
    double volNeed = 0.0;
    Iterator<Guppy> it = guppiesInPool.iterator();
    while (it.hasNext()) {
      volNeed += it.next().getVolumeNeeded();
    }
    if (volNeed > volumeLiters) {
      while (volNeed > volumeLiters) {
        guppiesInPool.remove(0);
        died++;
        while (it.hasNext()) {
          volNeed += it.next().getVolumeNeeded();
        }
      }
    }
    return died;
  }


}

