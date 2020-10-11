package ca.bcit.comp2522.assignments.a3;
/**
 * DivisionOperation.
 * @author Ben Jones
 * @version 1
 * extends AbstractOperation
 */
public class DivisionOperation extends AbstractOperation {

  /**
   * DIVISION_CODE.
   * char '/'
   */
  private static final char DIVISION_CODE = '/';

  /**
   * DivisionOperation.
   * passes DIVISION_CODE to super
   */
  public DivisionOperation() {
    super(DIVISION_CODE);
  }

  /**
   * perform.
   * @param operandA int
   * @param operandB int
   * @return int //result of division operation
   */
  public int perform(final int operandA, final int operandB) {
    return operandB / operandA;
  }
}
