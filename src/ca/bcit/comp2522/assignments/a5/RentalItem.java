package ca.bcit.comp2522.assignments.a5;
import java.util.Arrays;
import java.util.Date;

/**
 * RentalItem.
 * represents an item to be rented
 * @author Ben Jones
 * @version 1
 */
public class RentalItem extends InventoryItem {

  /**
   * Condition Enum.
   */
  private Condition currentCondition;
  /**
   *  Rental object array.
   */
  private Rental[] items;
  /**
   *  rental Id.
   */
  private long rentalID;
  /**
   *  rental price.
   */
  private double rentalPrice;
  /**
   *  sellable boolean.
   */
  private boolean sellable;
  /**
   *  Serializable id.
   */
  private long serialVersionUID;
  /**
   *  sold boolean.
   */
  private boolean sold;


  /**
   * RentalItem const.
   * @param currentConditionq Condition enum
   * @param itemsq Rental[] of items
   * @param rentalIDq  rental id.
   * @param rentalPriceq retal price
   * @param sellableq  sellable bool
   * @param serialVersionUIDq  serialVer uid
   * @param soldq  sold bool
   */
  public RentalItem(final Condition currentConditionq, final Rental[] itemsq,
                    final long rentalIDq, final double rentalPriceq,
                    final boolean sellableq, final long serialVersionUIDq,
                    final boolean soldq) {
    this.currentCondition = currentConditionq;
    this.items = itemsq;
    this.rentalID = rentalIDq;
    this.rentalPrice = rentalPriceq;
    this.sellable = sellableq;
    this.serialVersionUID = serialVersionUIDq;
    this.sold = soldq;
  }

  /**
   * RentalItem.
   * @param ipd date obj
   * @param sku long
   * @param desc  String
   * @param name String
   * @param purchasePrice double
   * @param serialVersionUIDq  long
   * @param type String
   * @param currentConditionq Condition
   * @param itemsq Rental[]
   * @param rentalIDq long
   * @param rentalPriceq double
   * @param sellableq boolean
   * @param serialVersionUID1 long
   * @param soldq boolean
   */
  public RentalItem(final Date ipd, final long sku, final String desc,
                    final String name, final double purchasePrice,
                    final long serialVersionUIDq, final String type,
                    final Condition currentConditionq, final Rental[] itemsq,
                    final long rentalIDq, final double rentalPriceq,
                    final boolean sellableq, final long serialVersionUID1,
                    final boolean soldq) {
    super(ipd, sku, desc, name, purchasePrice, serialVersionUIDq, type);
    this.currentCondition = currentConditionq;
    this.items = itemsq;
    this.rentalID = rentalIDq;
    this.rentalPrice = rentalPriceq;
    this.sellable = sellableq;
    this.serialVersionUID = serialVersionUID1;
    this.sold = soldq;
  }

  /**
   * getCurrentCondition.
   * @return Condition
   */
  public Condition getCurrentCondition() {
    return currentCondition;
  }
  /**
   * getItems.
   * @return Rental[]
   */
  public Rental[] getItems() {
    return items;
  }
  /**
   * getRentalId.
   * @return long
   */
  public long getRentalID() {
    return rentalID;
  }
  /**
   * getRentalPrice.
   * @return double
   */
  public double getRentalPrice() {
    return rentalPrice;
  }
  /**
   * isSold.
   * @return boolean
   */
  public boolean isSold() {
    return sold;
  }
  /**
   * isSellable.
   * @return boolean
   */
  public boolean isSellable() {
    return sellable;
  }

  /**
   * setCurrentCondition.
   * @param currentConditionq Condition
   */
  public void setCurrentCondition(final Condition currentConditionq) {
    this.currentCondition = currentConditionq;
  }
  /**
   * setItems.
   * @param itemsq Rental[]
   */
  public void setItems(final Rental[] itemsq) {
    this.items = itemsq;
  }
  /**
   * setRentalID.
   * @param rentalIDq long
   */
  public void setRentalID(final long rentalIDq) {
    this.rentalID = rentalIDq;
  }
  /**
   * setRentalPrice.
   * @param rentalPriceq double
   */
  public void setRentalPrice(final double rentalPriceq) {
    this.rentalPrice = rentalPriceq;
  }
  /**
   * setSold.
   * @param soldq boolean
   */
  public void setSold(final boolean soldq) {
    this.sold = soldq;
  }
  /**
   * setSellable.
   * @param sellableq boolean
   */
  public void setSellable(final boolean sellableq) {
    this.sellable = sellableq;
  }

  /**
   * toString.
   * prints feilds and those inherited from parent
   */
  @Override
  public String toString() {
    return "RentalItem{"
        + super.toString()
        + " currentCondition=" + currentCondition
        + ", rentalID=" + rentalID
        + ", rentalPrice=" + rentalPrice
        + ", sellable=" + sellable
        + " serialVersionUID=" + serialVersionUID
        + ", sold=" + sold
        + ",\nitems=" + Arrays.toString(items)
        + '}';
  }
}
