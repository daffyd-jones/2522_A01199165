package ca.bcit.comp2522.assignments.a3;

/**
 * MultiplicationOperation.
 * @author Ben Jones
 * @version 1
 * extends AbstractOperation
 */
public class MultiplicationOperation extends AbstractOperation {
  /**
   * MULTIPLICATION_CODE.
   * char '*'
   */
  private static final char MULTIPLICATION_CODE = '*';

  /**
   * MultiplicationOperation Const.
   * passes MULTIPLICATION_CODE to super
   */
  public MultiplicationOperation() {
    super(MULTIPLICATION_CODE);
  }

  /**
   * perform.
   * @param operandA int
   * @param operandB int
   * @return int //result of multiplication operation
   */
  public int perform(final int operandA, final int operandB) {
    return operandA * operandB;
  }
}
