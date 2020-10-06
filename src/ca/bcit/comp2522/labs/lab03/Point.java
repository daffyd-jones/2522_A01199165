package ca.bcit.comp2522.labs.lab03;

public class Point {

  /**
   * x pos.
   * Is the x position of the point
   */
  private final int x;
  /**
   * y pos.
   * Is the y position of the point
   */
  private final int y;

  /**
   * Point Constructor.
   * Takes two ints.
   * @param xIn int
   * @param yIn int
   */
  public Point(final int xIn, final int yIn) {
    this.x = xIn;
    this.y = yIn;
  }

  /**
   * get Y.
   * @return int y
   */
  public int getY() {
    return y;
  }

  /**
   * get x.
   * @return int x
   */
  public int getX() {
    return x;
  }




}
