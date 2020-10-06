package ca.bcit.comp2522.labs.lab03;

/**
 * Driver.
 * Runs the Quadrilateral test
 * @author Ben Jones
 * @version 1
 * -- uses Quadrilateral, Parallelogram, Square, Rectangle, Trapezoid
 */
public class Driver {

  /**
   * main.
   * runs the program
   * @param args unused
   */
  public static void main(final String[] args) {
    Quadrilateral tr = new Trapezoid(0, 0, 4, 0, 1,
        4, 3, 4);
    Quadrilateral pal = new Parallelogram(0, 0, 4, 0,
        1, 4, 5, 4);
    Quadrilateral rec = new Rectangle(0, 0, 4, 0,
        0, 5, 4, 5);
    Quadrilateral sq = new Square(0, 0, 4, 0,
        0, 4, 4, 4);

    System.out.println("Trapezoid area: " + tr.area());
    System.out.println("Parallelogram area: " + pal.area());
    System.out.println("Rectangle area " + (rec.area()));
    System.out.println("Square area: " + sq.area());
  }
}
