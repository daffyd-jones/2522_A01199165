package ca.bcit.comp2522.assignments.a5;
import java.io.Serializable;
import java.util.Date;

/**
 * InventoryItem.
 * abstract
 * represents a stock item
 * @author Ben Jones
 * @version 1
 */
public abstract class InventoryItem implements Sellable, Serializable {
  /**
   * Date var.
   */
  private Date ipd;
  /**
   * sku long.
   */
  private long sku;
  /**
   * description long.
   */
  private String desc;
  /**
   * String Name.
   */
  private String name;
  /**
   * Purchase price double.
   */
  private double purchasePrice;
  /**
   * serial version UID.
   */
  private long serialVersionUID;
  /**
   * String type.
   */
  private String type;
  /**
   * hashCode int.
   */
  private volatile int hashcode = 0;

  /**
   * InventoryItem const.
   */
  public InventoryItem() {
  }
  /**
   * InventoryItem Const.
   * @param ipdq Date
   * @param skuq long
   * @param descq String
   * @param nameq String
   * @param purchasePriceq double
   * @param serialVersionUIDq long
   * @param typeq String
   */
  public InventoryItem(final Date ipdq, final long skuq, final String descq,
                       final String nameq, final double purchasePriceq,
                       final long serialVersionUIDq, final String typeq) {
    this.ipd = ipdq;
    this.sku = skuq;
    this.desc = descq;
    this.name = nameq;
    this.purchasePrice = purchasePriceq;
    this.serialVersionUID = serialVersionUIDq;
    this.type = typeq;
  }

  /**
   * equals.
   * @param o Object
   * @return Object
   */
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InventoryItem)) {
      return false;
    }
    InventoryItem invIt = (InventoryItem) o;
    return sku == invIt.sku && name == invIt.name;
  }

  /**
   * hashCode.
   * @return int returns hash based on sku and name
   */
  public int hashCode() {
    final int mult = 57;
    if (hashcode == 0) {
      int code = 191;
      code = mult * code + Float.floatToIntBits(sku);
      code = mult * code + name.hashCode();
      hashcode = code;
    }
    return hashcode;
  }
  /**
   * getDesc.
   * @return String
   */
  public String getDesc() {
    return desc;
  }
  /**
   * getIpd.
   * @return Date
   */
  public Date getIpd() {
    return ipd;
  }

  /**
   * getName.
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * getPurchasePrice.
   * @return double
   */
  public double getPurchasePrice() {
    return purchasePrice;
  }
  /**
   * getSku.
   * @return long
   */
  public long getSku() {
    return sku;
  }
  /**
   * getType.
   * @return String
   */
  public String getType() {
    return type;
  }

  /**
   * setDesc.
   * @param descq String
   */
  public void setDesc(final String descq) {
    this.desc = descq;
  }
  /**
   * setIpd.
   * @param ipdq Date
   */
  public void setIpd(final Date ipdq) {
    this.ipd = ipdq;
  }
  /**
   * setName.
   * @param nameq String
   */
  public void setName(final String nameq) {
    this.name = nameq;
  }
  /**
   * setPurchasePrice.
   * @param purchasePriceq double
   */
  public void setPurchasePrice(final double purchasePriceq) {
    this.purchasePrice = purchasePriceq;
  }
  /**
   * setSku.
   * @param skuq long
   */
  public void setSku(final long skuq) {
    this.sku = skuq;
  }
  /**
   * setType.
   * @param typeq String
   */
  public void setType(final String typeq) {
    this.type = typeq;
  }
  /**
   * toString.
   * prints feilds and passes to child
   */
  @Override
  public String toString() {
    return "InventoryItem{"
        + "ipd=" + ipd
        + ", sku=" + sku
        + ", desc='" + desc + '\''
        + ", name='" + name + '\''
        + ", purchasePrice=" + purchasePrice
        + ", serialVersionUID=" + serialVersionUID
        + ", type='" + type + '\''
        + ", hashcode=" + this.hashCode()
        + '}';
  }
}
