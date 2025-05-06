package org.iis.mocking.purchaseorder;

/**
 * Represents a warehouse where products are stored.
 */
public interface Warehouse {

  /**
   * Checks if there are enough products with the specified name and quantity in the warehouse.
   *
   * @param name The name of the product to check.
   * @param amount The quantity of the product to check.
   * @return True if there are enough products, false otherwise.
   */
  boolean thereAreProducts(String name, int amount);

  /**
   * Removes the specified quantity of products with the given name from the warehouse.
   *
   * @param name The name of the product to remove.
   * @param amount The quantity of the product to remove.
   */
  void remove(String name, int amount);
}
