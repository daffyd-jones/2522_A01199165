package ca.bcit.comp2522.assignments.a3;
/**
 * StackUnderflowException.
 * extends Exception
 */
public class StackUnderflowException extends Exception {
  /**
   * StackUnderflowException.
   * @param w passed to super
   */
  public StackUnderflowException(final String w) {
    super(w);
  }
}
