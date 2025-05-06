package org.iis.mocking.purchaseorder;

/**
 * Represents a purchase order for a specific product and quantity.
 */
public class PurchaseOrder {
  private final String productName;
  private final int amountToBuy;

  /**
   * Constructs a purchase order with the given product name and quantity.
   *
   * @param productName The name of the product to purchase.
   * @param amountToBuy The quantity of the product to purchase.
   */
  public PurchaseOrder(String productName, int amountToBuy) {
    this.productName = productName;
    this.amountToBuy = amountToBuy;
  }

  /**
   * Attempts to purchase the specified quantity of the product from the warehouse.
   * If there are enough products available in the warehouse, they are removed.
   *
   * @param warehouse The warehouse from which to purchase the products.
   */
  void purchase(Warehouse warehouse) {
    if (warehouse.thereAreProducts(productName, amountToBuy)) {
      warehouse.remove(productName, amountToBuy);
    }
  }
}
