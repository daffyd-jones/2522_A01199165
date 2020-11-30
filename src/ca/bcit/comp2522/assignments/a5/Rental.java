package ca.bcit.comp2522.assignments.a5;
import java.io.Serializable;
import java.util.Date;

/**
 * Rental.
 * rental object
 * @author Ben Jones
 * @version 1
 */
public class Rental implements Serializable {
  /**
   * comment string.
   */
  private String comments;
  /**
   * Condition conafter.
   */
  private Condition conditionAfter;
  /**
   * Condition conbefore.
   */
  private Condition conditionBefore;
  /**
   * Date date.
   */
  private Date date;
  /**
   * rental long.
   */
  private long rentalId;
  /**
   * serialVersionUID.
   */
  private long serialVersionUID;
  /**
   * hashcode.
   */
  private int hashcode = 0;

  /**
   * Rental.
   * @param commentsq String
   * @param conditionAfterq Condition
   * @param conditionBeforeq Condition
   * @param dateq Date
   * @param rentalIdq long
   * @param serialVersionUIDq long
   */
  public Rental(final String commentsq, final Condition conditionAfterq,
                final Condition conditionBeforeq, final Date dateq,
                final long rentalIdq, final long serialVersionUIDq) {
    this.comments = commentsq;
    this.conditionAfter = conditionAfterq;
    this.conditionBefore = conditionBeforeq;
    this.date = dateq;
    this.rentalId = rentalIdq;
    this.serialVersionUID = serialVersionUIDq;
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
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rental rent = (Rental) o;
    return rentalId == rent.rentalId;
  }
  /**
   * hashCode.
   * @return int hashcode from rentalId.
   */
  public int hashCode() {
    final int mult = 57;
    if (hashcode == 0) {
      int code = 191;
      code = mult * code + Float.floatToIntBits(rentalId);
      hashcode = code;
    }
    return hashcode;
  }
  /**
   * getComments.
   * @return String
   */
  public String getComments() {
    return comments;
  }
  /**
   * getConditionAfter.
   * @return Condition
   */
  public Condition getConditionAfter() {
    return conditionAfter;
  }
  /**
   * getConditionBefore.
   * @return Condition
   */
  public Condition getConditionBefore() {
    return conditionBefore;
  }
  /**
   * getDate.
   * @return Date
   */
  public Date getDate() {
    return date;
  }
  /**
   * getRentalId.
   * @return long
   */
  public long getRentalId() {
    return rentalId;
  }
  /**
   * setComments.
   * @param commentsq String
   */
  public void setComments(final String commentsq) {
    this.comments = commentsq;
  }
  /**
   * setConditionAfter.
   * @param conditionAfterq Condition
   */
  public void setConditionAfter(final Condition conditionAfterq) {
    this.conditionAfter = conditionAfterq;
  }
  /**
   * setConditionBefore.
   * @param conditionBeforeq Condition
   */
  public void setConditionBefore(final Condition conditionBeforeq) {
    this.conditionBefore = conditionBeforeq;
  }

  /**
   * setRentalId.
   * @param rentalIdq long
   */
  public void setRentalId(final long rentalIdq) {
    this.rentalId = rentalIdq;
  }

  /**
   * toString.
   * @return String
   */
  @Override
  public String toString() {
    return "\nRental{"
        + "comments='" + comments + '\''
        + ", conditionAfter=" + conditionAfter
        + ", conditionBefore=" + conditionBefore
        + ", date=" + date
        + ", rentalId=" + rentalId
        + ", hashcode=" + this.hashCode()
        + '}';
  }
}
