package ca.bcit.comp2522.assignments.a3;

/**
 * Stack.
 * an array and helper methods to act as equation stack
 * @author Ben Jones
 * @version 1
 * used by RPNCalculator
 */
public class Stack {
  /**
   * stackValues.
   * int[] for operand values
   */
  private final int[] stackValues;
  /**
   * count.
   * number of items in array
   */
  private int count;

  /**
   * Stack Constructor.
   * @param a int //throws IllegalArgumentException if
   * under 1
   */
  public Stack(final int a) {
    if (a < 1) {
      throw new IllegalArgumentException("Value must be above 0");
    } else {
      stackValues = new int[a];
    }
  }

  /**
   * size.
   * returns count var
   * @return int //count var
   */
  public int size() {
    return count;
  }

  /**
   * capacity.
   * @return int //stackValues.length
   */
  public int capacity() {
    return stackValues.length;
  }

  /**
   * unsaved.
   * @return int //stackValues.length - count
   */
  public int unused() {
    return stackValues.length - count;
  }

  /**
   * push.
   * adds parameter to stackValues
   * @param value int to be added to array
   * @throws StackOverflowException //if stack is full
   */
  public void push(final int value) throws StackOverflowException {
    if (unused() == 0) {
      throw new StackOverflowException("This stack is full");
    } else {
      count++;
      stackValues[count - 1] = value;

    }
  }

  /**
   * pop.
   * removes and returns element from top of array
   * @return int elment from top of array
   * @throws StackUnderflowException //if stack is empty
   */
  public int pop() throws StackUnderflowException {
    int out;
    if (count == 0) {
      throw new StackUnderflowException("Cannot call Stack.pop() "
          + "on an empty stack");
    } else {
      out = stackValues[count - 1];
      stackValues[count - 1] = 0;
      count--;
    }
    return out;
  }

  /**
   * peek.
   * returns top element without removing it
   * @return int from top of stack
   * @throws StackUnderflowException //if stack is empty
   */
  public int peek() throws StackUnderflowException {
    if (count < 1) {
      throw new StackUnderflowException("Cannot call Attack.pop() "
          + "on an empty stack");
    } else {
      return stackValues[count - 1];
    }
  }
}



