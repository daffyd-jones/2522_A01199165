package ca.bcit.comp2522.assignments.a3;
/**
 * StackOverflowException.
 * extends Exception
 */
public class StackOverflowException extends Exception {
  /**
   * StackOverflowException Const.
   *
   * @param d passed to super
   */
  public StackOverflowException(final String d) {
    super(d);
  }
}
