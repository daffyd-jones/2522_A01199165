package ca.bcit.comp2522.labs.lab06;

public class Resources {
  private String levelName;
  private int levelNo;
  private int x, y;
  private int health;
  private int levelEnemies;


  public Resources(final String levelName, final int levelNo,
                   final int x, final int y, final int health,
                   final int levelEnemies) {
    this.levelName = levelName;
    this.levelNo = levelNo;
    this.x = x;
    this.y = y;
    this.health = health;
    this.levelEnemies = levelEnemies;
  }

  public String getLevelName() {
    return levelName;
  }

  public int getLevelNo() {
    return levelNo;
  }


  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getHealth() {
    return health;
  }

  public int getLevelEnemies() {
    return levelEnemies;
  }
  @Override
  public String toString() {
    return "Resources{"
        + "levelName='" + levelName + '\''
        + ", levelNo=" + levelNo
        + ", x=" + x
        + ", y=" + y
        + ", health=" + health
        + ", levelEnemies=" + levelEnemies
        + '}';
  }
}
