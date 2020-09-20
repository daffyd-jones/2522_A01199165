package ca.bcit.comp2522.assignments.a1;

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
  public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
  public static final int MATURE_FISH_AGE_IN_WEEKS = 30;
  public static final int MAXIMUM_AGE_IN_WEEKS = 50;
  public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
  public static final String DEFAULT_GENUS = "Poecilia";
  public static final String DEFAULT_SPECIES = "reticulata";
  public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
  public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
  public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

  private String genus;
  private String species;
  private int ageInWeeks;
  private boolean isFemale;
  private int generationNumber;
  private boolean isAlive;
  private double healthCoefficient;
  private int identificationNumber;



  private static int numberOfGuppies;

  /**
   * Guppy Constructor.
   * sets the fish's parameters to their default values
   */
  public Guppy() {
    this.ageInWeeks = 0;
    this.generationNumber = 0;
    this.genus = DEFAULT_SPECIES;
    this.species = DEFAULT_SPECIES;
    this.isFemale = true;
    this.isAlive = true;
    this.healthCoefficient = 1.0;
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
    String tempUp = newGenus.substring(0, 1).toUpperCase();
    String tempLow = newGenus.substring(1, newGenus.length() - 1).toLowerCase();
    this.genus = tempUp + tempLow;
    tempUp = newSpecies.substring(0, 1).toUpperCase();
    tempLow = newSpecies.substring(1, newSpecies.length() - 1);
    this.species = tempUp + tempLow;
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

  public String getGenus() {
    return genus;
  }

  public String getSpecies() {
    return species;
  }

  public int getAgeInWeeks() {
    return ageInWeeks;
  }

  public boolean isFemale() {
    return isFemale;
  }

  public int getGenerationNumber() {
    return generationNumber;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public double getHealthCoefficient() {
    return healthCoefficient;
  }

  public int getIdentificationNumber() {
    return identificationNumber;
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
    } else if (ageInWeeks > 10 && this.ageInWeeks < 30) {
      double tempDoub = (double) ageInWeeks;
      return MINIMUM_WATER_VOLUME_ML * (tempDoub / YOUNG_FISH_AGE_IN_WEEKS);
    } else if (ageInWeeks > 31 && ageInWeeks < 50) {
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

  public boolean equals(Object obj) {
    return this == obj;
  }

}
