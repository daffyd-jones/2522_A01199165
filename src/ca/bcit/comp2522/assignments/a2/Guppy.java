package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * Guppy Class.
 *
 * @author Benjamin jones
 * @version 1.0
 *
 * Represents a guppy.
 * contains:
 * genus;
 * species;
 * ageInWeeks;
 * isFemale;
 * generationNumber;
 * isAlive;
 * healthCoefficient;
 * identificationNumber;
 *
 * uses:
 * incrementAge();
 * getVolumeNeeded();
 * getters for instance variables;
 * setters for: ageInWeeks, healthCoefficient
 *
 * changeHealthCoefficient();
 * and toString();
 */

public class Guppy {
  /**
   * YOUNG_FISH_AGE_IN_WEEKS.
   * 10
   */
  public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
  /**
   * MATURE_FISH_AGE_IN_WEEKS.
   * 30
   */
  public static final int MATURE_FISH_AGE_IN_WEEKS = 30;
  /**
   * MAXIMUM_AGE_IN_WEEKS.
   * 50
   */
  public static final int MAXIMUM_AGE_IN_WEEKS = 50;
  /**
   * MINIMUM_WATER_VOLUME_ML.
   * 250.0
   */
  public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
  /**
   * DEFAULT_GENUS.
   * Poecilia
   */
  public static final String DEFAULT_GENUS = "Poecilia";
  /**
   * DEFAULT_SPECIES.
   * reticulata
   */
  public static final String DEFAULT_SPECIES = "reticulata";
  /**
   * DEFAULT_HEALTH_COEFFICIENT.
   * 0.5
   */
  public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
  /**
   * MINIMUM_HEALTH_COEFFICIENT.
   * 0.0
   */
  public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
  /**
   * MAXIMUM_HEALTH_COEFFICIENT.
   * 1.0
   */
  public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

  /**
   * genus.
   */
  private String genus;
  /**
   * species.
   */
  private String species;
  /**
   * ageInWeeks.
   */
  private int ageInWeeks;
  /**
   * isFemale.
   */
  private boolean isFemale;
  /**
   * generationNumber.
   */
  private int generationNumber;
  /**
   * isAlive.
   */
  private boolean isAlive;
  /**
   * healthCoefficient.
   */
  private double healthCoefficient;
  /**
   * identificatonNumber.
   */
  private int identificationNumber;



  private static int numberOfGuppies;

  /**
   * Guppy Constructor.
   * sets the fish's parameters to their default values
   */
  public Guppy() {
    this.ageInWeeks = 0;
    this.generationNumber = 0;
    this.genus = DEFAULT_GENUS;
    this.species = DEFAULT_SPECIES;
    this.isFemale = true;
    this.isAlive = true;
    this.healthCoefficient = 0.5;
    numberOfGuppies++;
    this.identificationNumber = numberOfGuppies;

  }

  /**
   * Guppy Constructor.
   *
   * @param newGenus // genus of the fish.
   * @param newSpecies // species of the fish.
   * @param newAgeInWeeks // new age of the fish, if (newAgeInWeeks < 0) ageInWeeks = 0;
   * @param newIsFemale // determines the gender of the fish
   * @param newGenerationNumber // the generation that the fish belongs to, if
   *                            (newGenerationNumber < 0) generationNumber = 1;
   * @param newHealthCoefficient // sets the fish's health quality, if newHealthCoefficient
   *                             exceeds bounds healthCoefficient = bounds
   */
  public Guppy(String newGenus, String newSpecies, int newAgeInWeeks,
               boolean newIsFemale, int newGenerationNumber,
               double newHealthCoefficient) {
    if (newGenus != null && !newGenus.isBlank() && !newGenus.isEmpty()) {
      newGenus = newGenus.replaceAll("\\s", "");
      String tempUp = newGenus.substring(0, 1).toUpperCase();
      String tempLow = newGenus.substring(1, newGenus.length()).toLowerCase();
      this.genus = tempUp + tempLow;
    }
    if (newSpecies != null && !newSpecies.isBlank() && !newSpecies.isEmpty()) {
      newSpecies = newSpecies.replaceAll("\\s", "");
      this.species = newSpecies.toLowerCase();
    }
    if (newAgeInWeeks < 0) {
      this.ageInWeeks = 0;
    } else {
      this.ageInWeeks = newAgeInWeeks;
    }
    this.isFemale = newIsFemale;
    if (newGenerationNumber < 0) {
      this.generationNumber = 1;
    } else {
      this.generationNumber = newGenerationNumber;
    }
    if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
      this.healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
    } else if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
      this.healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
    } else {
      this.healthCoefficient = newHealthCoefficient;
    }
    this.isAlive = true;
    numberOfGuppies++;
    this.identificationNumber = numberOfGuppies;
  }

  /**
   * incrementAge.
   * increments the ageInWeeks variable by 1
   * if new value exceeds MAXIMUM_AGE_IN_WEEKS
   * isAlive is set to false
   */
  public void incrementAge() {
    this.ageInWeeks++;
    if (this.ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
      this.isAlive = false;
    }
  }

  /**
   * getGenus.
   * @return genus
   */
  public String getGenus() {
    return genus;
  }

  /**
   * getSpecies.
   * @return species
   */
  public String getSpecies() {
    return species;
  }

  /**
   * getAgeInWeeks.
   * @return ageInWeeks
   */
  public int getAgeInWeeks() {
    return ageInWeeks;
  }

  /**
   * isFemale.
   * @return isFemale
   */
  public boolean isFemale() {
    return isFemale;
  }

  /**
   * getGenerationNumber.
   * @return generationNumber
   */
  public int getGenerationNumber() {
    return generationNumber;
  }

  /**
   * getGenerationNumber.
   * @return isAlive
   */
  public boolean isAlive() {
    return isAlive;
  }

  /**
   * getHealthCoefficient.
   * @return healthCoefficient
   */
  public double getHealthCoefficient() {
    return healthCoefficient;
  }

  /**
   * getIdentificationNumber.
   * @return identificationNumber
   */
  public int getIdentificationNumber() {
    return identificationNumber;
  }

  /**
   * setIsAlive.
   * is used to change isAlive boolean
   *
   * @param isAlive // alive boolean
   */
  public void setIsAlive(boolean isAlive) {
    this.isAlive = isAlive;
  }

  /**
   * setAgeInWeeks.
   * determines whether input is withing acceptable health range
   * if acceptable, it is assigned to the ageInWeeks variable
   *
   * @param ageInWeeks // used to set the new age of fish, (0 < ageInWeeks < MAXIMUM_AGE_IN_WEEKS)
   */
  public void setAgeInWeeks(int ageInWeeks) {
    if (ageInWeeks < 0 || ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
      return;
    }
    this.ageInWeeks = ageInWeeks;
  }

  /**
   * setAlive.
   * @param alive // alive boolean
   */
  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  /**
   * setHealthCoefficient.
   * mutator for healthCoefficient
   *
   * @param healthCoefficient //used to determine the health of the fish.
   */
  public void setHealthCoefficient(double healthCoefficient) {
    if (healthCoefficient < MINIMUM_HEALTH_COEFFICIENT
        || healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
      return;
    }
    this.healthCoefficient = healthCoefficient;
  }

  public static int getNumberOfGuppiesBorn() {
    return numberOfGuppies;
  }

  /**
   * getVolumeNeeded.
   * evaluates the amout of water needed by the fish
   * based on their age in weeks
   *
   * @return double
   */
  public double getVolumeNeeded() {
    if (ageInWeeks < 10) {
      return MINIMUM_WATER_VOLUME_ML;
    } else if (ageInWeeks >= 10 && ageInWeeks <= 30) {
      double tempDoub = (double) ageInWeeks;
      return MINIMUM_WATER_VOLUME_ML * (tempDoub / YOUNG_FISH_AGE_IN_WEEKS);
    } else if (ageInWeeks >= 31 && ageInWeeks <= 50) {
      return MINIMUM_WATER_VOLUME_ML * 1.5;
    } else {
      return 0.0;
    }
  }

  /**
   * changeHealthCoefficient.
   * Changes the healthCoefficient variable.
   *
   * @param delta //used to modify the healthCoefficient variable
   */
  public void changeHealthCoefficient(double delta) {
    double tempDoub = delta + healthCoefficient;
    if (tempDoub <= MINIMUM_HEALTH_COEFFICIENT) {
      healthCoefficient = 0.0;
      isAlive = false;
    } else if (tempDoub > MAXIMUM_HEALTH_COEFFICIENT) {
      healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
    }
  }

  /**
   * spawn.
   * spawns babies for female guppies.
   * @return babyGuppies
   */
  public ArrayList<Guppy> spawn() {
    if (!this.isFemale || this.ageInWeeks < 8 && this.ageInWeeks > 0) {
      return null;
    }
    ArrayList<Guppy> babyGuppies = new ArrayList<Guppy>();
    Random rand = new Random();
    if (rand.nextInt() <= 0.5) {
      int guppyNum = rand.nextInt(100) + 1;
      for (int i = 0; i < guppyNum; i++) {
        int gendTemp = rand.nextInt();
        boolean fem = false;
        if (gendTemp < 0.5) {
          fem = true;
        }
        Guppy tempGup = new Guppy(this.genus, this.species, 0,
            fem, this.generationNumber + 1,
            1.0 + this.healthCoefficient);
        babyGuppies.add(tempGup);
      }
    }
    return babyGuppies;
  }

  /**
   * ageComparator.
   * compares guppy ages
   */
  public static Comparator<Guppy> ageComparator = new Comparator<Guppy>() {
    @Override
    public int compare(Guppy o1, Guppy o2) {
      return (Integer.compare(o1.getAgeInWeeks(), o2.getAgeInWeeks()));
    }
  };

  /**
   * healthComparator.
   * compares guppy healthCoefficients
   */
  public static Comparator<Guppy> healthComparator = new Comparator<Guppy>() {
    @Override
    public int compare(Guppy o1, Guppy o2) {
      return (Double.compare(o1.getHealthCoefficient(), o2.getHealthCoefficient()));
    }
  };




  /**
   * toString method.
   * Outputs information about this fish
   *
   * @return String.
   */
  public String toString() {
    return String.format("This object represents a fish.\nGenus: %s | Species: %s "
            + "| Age in weeks: %d \nFemale: %b | Generation %d | Alive %b \nHealth: "
            + "%1.2f | ID Number: %d", genus, species, ageInWeeks,
        isFemale, generationNumber, isAlive, healthCoefficient, identificationNumber);
  }

  /**
   * equals.
   * @param obj // object to compare
   * @return boolean
   */
  public boolean equals(Object obj) {
    return this == obj;
  }

}
