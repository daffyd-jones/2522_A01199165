package ca.bcit.comp2522.assignments.a5;
import java.io.Serializable;

/**
 * Sellable.
 * interface
 * @author Ben Jones
 * @version 1
 */
public interface Sellable extends Serializable {
  /**
   * isSellable.
   * @return boolean
   */
  boolean isSellable();
  /**
   * setSellable.
   * @param sellable boolean
   */
  void setSellable(boolean sellable);
}
