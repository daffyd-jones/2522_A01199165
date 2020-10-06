package ca.bcit.comp2522.labs.lab03;

/**
 * Quadrilateral.
 * @author Ben Jones
 * @version 1
 * -- abstract
 * >Parallelogram, Trapezoid, Rectangle, Square
 */

public abstract class Quadrilateral {
  /**
   * firstPoint.
   * Point Object - lower left corner
   */
  private final Point firstPoint;
  /**
   * secondPoint.
   * Point Object - lower right corner
   */
  private final Point secondPoint;
  /**
   * thirdPoint.
   * Point Object - upper left corner
   */
  private final Point thirdPoint;
  /**
   * fourthPoint.
   * Point Object - upper right corner
   */
  private final Point fourthPoint;

  /**
   * Quadrilateral Const.
   * @param p1x int
   * @param p1y int
   * @param p2x int
   * @param p2y int
   * @param p3x int
   * @param p3y int
   * @param p4x int
   * @param p4y int
   */
  public Quadrilateral(final int p1x, final int p1y, final int p2x,
                       final int p2y, final int p3x, final int p3y,
                       final int p4x, final int p4y) {
    firstPoint = new Point(p1x, p1y);
    secondPoint = new Point(p2x, p2y);
    thirdPoint = new Point(p3x, p3y);
    fourthPoint = new Point(p4x, p4y);

  }

  /**
   * getFirstPoint.
   * @return Point
   */
  public Point getFirstPoint() {
    return firstPoint;
  }

  /**
   * getSecondPoint.
   * @return Point
   */
  public Point getSecondPoint() {
    return secondPoint;
  }

  /**
   * getThirdPoint.
   * @return Point
   */
  public Point getThirdPoint() {
    return thirdPoint;
  }

  /**
   * getFourthPoint.
   * @return Point
   */
  public Point getFourthPoint() {
    return fourthPoint;
  }

  /**
   * area.
   * calculates and returns area of object
   * @return int
   */
  public int area() {
    int h = thirdPoint.getY() - firstPoint.getY();
    int b = secondPoint.getX() - firstPoint.getY();
    return h * b;
  }
}
