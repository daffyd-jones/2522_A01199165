package ca.bcit.comp2522.assignments.a3;

/**
 * AdditionOperation.
 * @author Ben Jones
 * @version 1
 * extends AbstractOperation
 */
public class AdditionOperation extends AbstractOperation {
  /**
   * ADDITION_CODE.
   * char '+'
   */
  private static final char ADDITION_CODE = '+';

  /**
   * AdditionOperation Const.
   * passes ADDITION_CODE to super
   */
  public AdditionOperation() {
    super(ADDITION_CODE);
  }

  /**
   * perform.
   * @param operandA int
   * @param operandB int
   * @return int //result of addition operation
   */
  public int perform(final int operandA, final int operandB) {
    return operandA + operandB;
  }
}
