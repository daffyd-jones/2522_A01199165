package ca.bcit.comp2522.assignments.a3;
import java.util.Scanner;
/**
 * RPNCalculator.
 * @author Ben Jones
 * @version 1
 * runs RPNCalculator program
 * uses: Stack, Operation > AbstractOperation(AdditionOperation,
 * SubtractionOperation, MultiplicationOperation, DivisionOperation)
 */
public class RPNCalculator {

  /**
   * MIN_STACK_SIZE.
   * 2 int
   */
  public static final int MIN_STACK_SIZE = 2;

  /**
   * stack.
   * A Stack obj
   */
  private final Stack stack;

  /**
   * RPNCalculator Constructor.
   * @param stackSize int
   */
  public RPNCalculator(final int stackSize) {
    if (stackSize < MIN_STACK_SIZE) {
      throw new IllegalArgumentException("Stack size must be larger than 2");
    } else {
      this.stack = new Stack(stackSize);
    }
  }

  /**
   * processFormula.
   * puts formula operand in stack, initializes operation and uses perform
   * to do math, returns result
   * @param formula int //throws exception if null
   * @return int result of equation
   * @throws StackOverflowException //if stack is full
   * @throws InvalidOperationTypeException //if operation is not +,/,-,*
   * @throws StackUnderflowException //if stack is empty
   */
  public int processFormula(final String formula) throws
      StackOverflowException, InvalidOperationTypeException,
      StackUnderflowException {
    if (formula == null || formula.length() == 0) {
      throw new StackUnderflowException("Input value must not be null or "
          + "less than 0 in length");
    } else {
      Scanner scan = new Scanner(formula);
      while (scan.hasNext()) {
        System.out.println("In the loop");
        if (scan.hasNextInt()) {
          push(scan.nextInt());
        } else {
          Operation op = getOperation(scan.next().charAt(0));
          perform(op);
        }
      }
      return getResult();
    }
  }

  /**
   * push.
   * adds operand to stack
   * @param operand int
   * @throws StackOverflowException //if stack is full
   */
  public void push(final int operand) throws StackOverflowException {
    if (stack.unused() == 0) {
      throw new StackOverflowException("This stack is full");
    } else {
      stack.push(operand);
    }
  }

  /**
   * getResult.
   * gets result from stack
   * @return int
   * @throws StackUnderflowException //if stack is empty
   */
  public int getResult() throws StackUnderflowException {
    if (stack.capacity() == 0) {
      throw new StackUnderflowException("Operation cannot be null");
    } else {
      return stack.peek();
    }
  }

  /**
   * perform.
   * pulls operands from stack, uses operation.perform and
   * pops result onto stack
   * @param operation operation class //will throw exception if null
   * @throws StackUnderflowException //if stack is empty
   * @throws StackOverflowException //if stack is full
   */
  protected void perform(final Operation operation) throws
      StackUnderflowException, StackOverflowException {
    if (operation == null) {
      throw new IllegalArgumentException("Operation cannot be null!");
    } else {
      int a = stack.pop();
      int b = stack.pop();
      int c = operation.perform(a, b);
      stack.push(c);
    }
  }

  /**
   * getOperation.
   * uses symbol param. to instantiate operation obj
   * @param symbol char
   * @return Operation
   * @throws InvalidOperationTypeException //if symbol is not
   * amongst those in switch
   */
  protected Operation getOperation(final char symbol)
        throws InvalidOperationTypeException {
    return switch (symbol) {
      case '-' -> new SubtractionOperation();
      case '*' -> new MultiplicationOperation();
      case '/' -> new DivisionOperation();
      case '+' -> new AdditionOperation();
      default -> throw new InvalidOperationTypeException("Not a valid "
          + "operator type.");
    };
  }

  /**
   * main.
   * runs the program
   * @param argv incoming formula String
   */
  public static void main(final String[] argv) {
    // Checks the correct number of command line arguments
    if (argv.length != 2) {
      System.err.println("Usage: Main <stack size> <formula>");
      System.exit(1);
    }

    //Initializes stack and RPNCalculator
    final int stackSize = Integer.parseInt(argv[0]);
    final RPNCalculator calculator = new RPNCalculator(stackSize);

    try {
      System.out.println("[" + argv[1] + "] = "
            + calculator.processFormula(argv[1]));
    } catch (final InvalidOperationTypeException ex) {
      System.err.println("Formula can only contain integers, +, -, * and /");
    } catch (final StackOverflowException ex) {
      System.err.println("too many operands in the formula, increase the "
          + "stack size");
    } catch (final StackUnderflowException ex) {
      System.err.println("too few operands in the formula");
    }
  }
}


