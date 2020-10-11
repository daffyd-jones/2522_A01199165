package ca.bcit.comp2522.assignments.a3;
/**
 * InvalidOperationTypeException.
 * extends Exception
 */
public class InvalidOperationTypeException extends Exception {
  /**
   * InvalidOperationTypeException Const.
   * @param w passed to super
   */
  public InvalidOperationTypeException(final String w) {
    super(w);
  }
}
