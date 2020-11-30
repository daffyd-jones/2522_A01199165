package ca.bcit.comp2522.assignments.a5;
import java.util.Date;

/**
 * SalesItem.
 * extends InventoryItem
 * @author Ben Jones
 * @version 1
 */
public class SalesItem extends InventoryItem {
  /**
   * sales price double.
   */
  private double salesPrice;
  /**
   * sales id long.
   */
  private long salesID;
  /**
   * sellable boolean.
   */
  private boolean sellable;
  /**
   * serial VersionUID long.
   */
  private long serialVersionUID;
  /**
   * sold boolean.
   */
  private boolean sold;

  /**
   * SalesItem Const.
   * @param salesPriceq double
   * @param salesIDq long
   * @param sellableq boolean
   * @param serialVersionUIDq long
   * @param soldq boolean
   */
  public SalesItem(final double salesPriceq, final long salesIDq,
                   final boolean sellableq, final long serialVersionUIDq,
                   final boolean soldq) {
    this.salesPrice = salesPriceq;
    this.salesID = salesIDq;
    this.sellable = sellableq;
    this.serialVersionUID = serialVersionUIDq;
    this.sold = soldq;
  }

  /**
   * SalesItem Const.
   * @param ipd Date
   * @param sku long
   * @param desc String
   * @param name String
   * @param purchasePrice double
   * @param serialVersionUIDq long
   * @param type String
   * @param salesPriceq double
   * @param salesIDq long
   * @param sellableq boolean
   * @param serialVersionUID1 long
   * @param soldq boolean
   */
  public SalesItem(final Date ipd, final long sku, final String desc,
                   final String name, final double purchasePrice,
                   final long serialVersionUIDq, final String type,
                   final double salesPriceq, final long salesIDq,
                   final boolean sellableq, final long serialVersionUID1,
                   final boolean soldq) {
    super(ipd, sku, desc, name, purchasePrice, serialVersionUIDq, type);
    this.salesPrice = salesPriceq;
    this.salesID = salesIDq;
    this.sellable = sellableq;
    this.serialVersionUID = serialVersionUID1;
    this.sold = soldq;
  }
  /**
   * getSalesPrice.
   * @return double
   */
  public double getSalesPrice() {
    return salesPrice;
  }
  /**
   * getSalesID.
   * @return long
   */
  public long getSalesID() {
    return salesID;
  }
  /**
   * isSellable.
   * @return boolean
   */
  public boolean isSellable() {
    return sellable;
  }
  /**
   * setSellable.
   * @param sellableq boolean
   */
  public void setSellable(final boolean sellableq) {
    this.sellable = sellableq;
  }
  /**
   * isSold.
   * @return boolean
   */
  public boolean isSold() {
    return sold;
  }
  /**
   * setSalesPrice.
   * @param salesPriceq double
   */
  public void setSalesPrice(final double salesPriceq) {
    this.salesPrice = salesPriceq;
  }
  /**
   * setSalesId.
   * @param salesIDq long
   */
  public void setSalesID(final long salesIDq) {
    this.salesID = salesIDq;
  }
  /**
   * setSold.
   * @param soldq boolean
   */
  public void setSold(final boolean soldq) {
    this.sold = soldq;
  }

  /**
   * toString.
   * prints feilds and those inherited from parent
   */
  @Override
  public String toString() {
    return "SalesItem{"
        + super.toString()
        + " salesPrice=" + salesPrice
        + ", salesID=" + salesID
        + ", sellable=" + sellable
        + ", serialVersionUID=" + serialVersionUID
        + ", sold=" + sold
        + '}';
  }
}
