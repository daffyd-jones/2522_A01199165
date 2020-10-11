package ca.bcit.comp2522.assignments.a3;

/**
 * Operation.
 * @author Ben Jones
 * @version 1
 * interface
 * implemented by AbstractOperation
 */
public interface Operation {
  /**
   * getSymbol.
   * implemented in AbstractOperation
   * @return char
   */
  char getSymbol();

  /**
   * perform.
   * implemented in Sub/Add/Mul/DivOperation
   * @param operandA int
   * @param operandB int
   * @return int //result of equation
   */
  int perform(int operandA, int operandB);
}
