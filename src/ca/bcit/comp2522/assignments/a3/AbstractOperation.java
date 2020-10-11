package ca.bcit.comp2522.assignments.a3;
/**
 * AbstractOperation.
 * @author Ben Jones
 * @version 1
 * abstract class
 * implements Operation
 * extended by Add/Sub/Mul/DivOperation
 */
abstract class AbstractOperation implements Operation {
  /**
   * operationType.
   * char "+, -, *, /"
   */
  protected char operationType;

  /**
   * AbstractOperation Constructor.
   * @param optype char
   */
  AbstractOperation(final char optype) {
    this.operationType = optype;
  }

  public final char getSymbol() {
    return operationType;
  }
}
