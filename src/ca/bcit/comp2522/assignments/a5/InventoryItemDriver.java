package ca.bcit.comp2522.assignments.a5;

import java.util.Date;

/**
 * Inventory Item Driver.
 * runs Asn5 test
 * @author Ben Jones
 * @version 1
 */
public class InventoryItemDriver {

  /**
   * Sales one name.
   */
  private static final String SALES1NAME = "Shovel";
  /**
   *  Sales one description.
   */
  private static final String SALES1DESC = "Its a shovel";
  /**
   *  Sales one type.
   */
  private static final String SALES1TYPE = "Shovel Type";
  /**
   *  Sales one sku.
   */
  private static final long SALES1SKU = 56413546;
  /**
   *   Sales one purchase price.
   */
  private static final double SALES1PURPRICE = 12.45;
  /**
   *   Sales one SerialVersion UID.
   */
  private static final long SALES1SVUID = 1;
  /**
   *  Sales one sales price.
   */
  private static final double SALES1SALPRICE = 15.45;
  /**
   *  Sales one sales id.
   */
  private static final long SALES1SALID = 1654;

  /**
   *  Sales two name.
   */
  private static final String SALES2NAME = "Flower Pot";
  /**
   *  Sales two description.
   */
  private static final String SALES2DESC = "This is a pot";
  /**
   *  Sales two type.
   */
  private static final String SALES2TYPE = "Pot Type";
  /**
   *  Sales two sku.
   */
  private static final long SALES2SKU = 32165487;
  /**
   *  Sales two purchase price.
   */
  private static final double SALES2PURPRICE = 12.45;
  /**
   *  Sales two SreialVersionUID.
   */
  private static final long SALES2SVUID = 2;
  /**
   *  Sales two sales price.
   */
  private static final double SALES2SALPRICE = 15.45;
  /**
   *  Sales two sales Id.
   */
  private static final long SALES2SALID = 8798745;
  /**
   *  Sales three name.
   */
  private static final String SALES3NAME = "Rake";
  /**
   *  Sales three description.
   */
  private static final String SALES3DESC = "Its a rake";
  /**
   *  Sales three type.
   */
  private static final String SALES3TYPE = "Rake Type";
  /**
   *  Sales three sku.
   */
  private static final long SALES3SKU = 987535458;
  /**
   *  Sales three purchase price.
   */
  private static final double SALES3PURPRICE = 12.45;
  /**
   *  Sales three Serial VersionUID..
   */
  private static final long SALES3SVUID = 3;
  /**
   *  Sales three sales price.
   */
  private static final double SALES3SALPRICE = 15.45;
  /**
   *  Sales three sales id.
   */
  private static final long SALES3SALID = 6548;

  /**
   *  Sales four name.
   */
  private static final String SALES4NAME = "Ball";
  /**
   *  Sales four description.
   */
  private static final String SALES4DESC = "its a Ball";
  /**
   *  Sales four type.
   */
  private static final String SALES4TYPE = "Ball Type";
  /**
   *  Sales four sku.
   */
  private static final long SALES4SKU = 873545414;
  /**
   *  Sales four purchase price.
   */
  private static final double SALES4PURPRICE = 12.45;
  /**
   *  Sales four Serial VersionUID.
   */
  private static final long SALES4SVUID = 4;
  /**
   *  Sales four sales price.
   */
  private static final double SALES4SALPRICE = 15.45;
  /**
   *  Sales four sales id.
   */
  private static final long SALES4SALID = 69876;

  /**
   *  Rental name.
   */
  private static final String RENTALNAME = "They rented stuff";
  /**
   *  Rental description.
   */
  private static final String RENTALDESC = "These are rented items";
  /**
   *  Rental type.
   */
  private static final String RENTALTYPE = "They they have some stuff";
  /**
   *  Rental sku.
   */
  private static final long RENTALSKU = 542315487;
  /**
   *  Rental purchase price.
   */
  private static final double RENTALPURPRICE = 23.45;
  /**
   *  Rental Serial VersionUID.
   */
  private static final long RENTALSVUID = 7;
  /**
   *  Rental price.
   */
  private static final double RENTALPRICE = 34.45;
  /**
   *  Rental Id.
   */
  private static final long RENTALID = 69876;
  /**
   *  Rental 1 comment.
   */
  private static final String RENT1COMM = "Rental item one";
  /**
   *  Rental 1 id.
   */
  private static final long RENT1RENTID = 123;
  /**
   *  Rental 1 Serial Version UIDId.
   */
  private static final long RENT1SVUID = 5;
  /**
   *  Rental 2 comment.
   */
  private static final String RENT2COMM = "Rental item two";
  /**
   *  Rental 2 id.
   */
  private static final long RENT2RENTID = 987;
  /**
   *  Rental 2 Serial Version UIDId.
   */
  private static final long RENT2SVUID = 6;

  /**
   * main method.
   * Runs the thing.
   * @param args unused
   */
  public static void main(final String[] args) {
    Date date = new Date();
    SalesItem salesItem1 = new SalesItem(date, SALES1SKU, SALES1DESC,
        SALES1NAME, SALES1PURPRICE, SALES1SVUID, SALES1TYPE,
        SALES1SALPRICE, SALES1SALID, true, SALES1SVUID, false);
    SalesItem salesItem2 = new SalesItem(date, SALES2SKU, SALES2DESC,
        SALES2NAME, SALES2PURPRICE, SALES2SVUID, SALES2TYPE,
        SALES2SALPRICE, SALES2SALID, true, SALES2SVUID, false);
    SalesItem salesItem3 = new SalesItem(date, SALES3SKU, SALES3DESC,
        SALES3NAME, SALES3PURPRICE, SALES3SVUID, SALES3TYPE,
        SALES3SALPRICE, SALES3SALID, true, SALES3SVUID, false);
    SalesItem salesItem4 = new SalesItem(date, SALES4SKU, SALES4DESC,
        SALES4NAME, SALES4PURPRICE, SALES4SVUID, SALES4TYPE,
        SALES4SALPRICE, SALES4SALID, true, SALES4SVUID, false);
    ////
    Rental rent1 = new Rental(RENT1COMM, null,
        Condition.EXCELLENT, date, RENT1RENTID, RENT1SVUID);
    Rental rent2 = new Rental(RENT2COMM, null,
        Condition.EXCELLENT, date, RENT2RENTID, RENT2SVUID);
    Rental[] rentArr = new Rental[2];
    rentArr[0] = rent1;
    rentArr[1] = rent2;
    RentalItem rentalItem = new RentalItem(date, RENTALSKU,
        RENTALDESC, RENTALNAME, RENTALPURPRICE, RENTALSVUID,
        RENTALTYPE, Condition.EXCELLENT, rentArr, RENTALID, RENTALPRICE,
        true, RENTALSVUID, false);
    //
    Object[] items = new Object[5];
    items[0] = salesItem1;
    items[1] = salesItem2;
    items[2] = salesItem3;
    items[3] = salesItem4;
    items[4] = rentalItem;
    for (int i = 0; i < items.length; i++) {
      System.out.println(items[i].toString());
    }
    System.out.println("\n");
    if (salesItem1.equals(salesItem1)) {
      System.out.println("sales item 1 equals itself");
    }
    if (!salesItem1.equals(salesItem2)) {
      System.out.println("sales item 1 does not equal sales item 2");
    }
    items = rem(items, 3);
    System.out.println("\n");
    for (int i = 0; i < items.length; i++) {
      System.out.println(items[i].toString());
    }
  }

  /**
   * rem.
   * removes index of array
   * @param arr incoming array
   * @param index index to be removed
   * @return Object[] array with removed index.
   */
  public static Object[] rem(final Object[] arr, final int index) {
    if (arr == null
        || index < 0
        || index >= arr.length) {
      return arr;
    }
    Object[] anotherArray = new Object[arr.length - 1];
    for (int i = 0, k = 0; i < arr.length; i++) {
      if (i == index) {
        continue;
      }
      anotherArray[k++] = arr[i];
    }
    return anotherArray;
  }
}
