package ca.bcit.comp2522.assignments.a3;

/**
 * SubtrationOperation.
 * @author Ben Jones
 * @version 1
 * extends AbstractOperation
 */
public class SubtractionOperation extends AbstractOperation {
  /**
   * SUBTRACTION_CODE.
   * char '-'
   */
  private static final char SUBTRACTION_CODE = '-';

  /**
   * SubtractionOperation Const.
   * passes SUBTRACTION_CODE to super
   */
  public SubtractionOperation() {
    super(SUBTRACTION_CODE);
  }

  /**
   * perform.
   * @param operandA int
   * @param operandB int
   * @return int //result of subtraction operation
   */
  public int perform(final int operandA, final int operandB) {
    return operandB - operandA;
  }
}
