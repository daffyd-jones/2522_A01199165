package ca.bcit.comp2522.labs.lab03;

/**
 * Parallelogram.
 * @author Ben Jones
 * @version 1
 * -- extends Quadrilateral
 */
public class Parallelogram extends Quadrilateral {
  /**
   * Parallelogram Constructor.
   * @param p1x int
   * @param p1y int
   * @param p2x int
   * @param p2y int
   * @param p3x int
   * @param p3y int
   * @param p4x int
   * @param p4y int
   */
  public Parallelogram(final int p1x, final int p1y, final int p2x,
                       final int p2y, final int p3x, final int p3y,
                       final int p4x, final int p4y) {
    super(p1x, p1y, p2x, p2y, p3x, p3y, p4x, p4y);
  }

  /**
   * area.
   * returns area of the object
   * @return int - area of the object
   */
  public int area() {
    int b = getSecondPoint().getX() - getFirstPoint().getX();
    int h = getThirdPoint().getY() - getFirstPoint().getY();
    return b * h;
  }
}
