package org.iis.mocking.purchaseorder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PurchaseOrderTest {
  @Test
  void givenAPurchaseOrderWhenThereAreEnoughProductsThenTheProductsAreRemovedFromTheWarehouse() {
    // STEP 1: create the mock object
    Warehouse warehouse = Mockito.mock(Warehouse.class);

    // STEP 2: define behavior (stubbing)
    Mockito.when(warehouse.thereAreProducts("Milk", 20)).thenReturn(true);

    // STEP 3: execute
    PurchaseOrder purchaseOrder = new PurchaseOrder("Milk", 20);
    purchaseOrder.purchase(warehouse);

    // STEP 4: verify
    Mockito.verify(warehouse, Mockito.times(1)).remove("Milk", 20);
  }

  @Test
  void
      givenAPurchaseOrderWhenThereAreNotEnoughProductsThenTheProductsAreNotRemovedFromTheWarehouse() {
    // STEP 1: create the mock object
    Warehouse warehouse = Mockito.mock(Warehouse.class);

    // STEP 2: define behavior
    Mockito.when(warehouse.thereAreProducts("Pasta'", 4)).thenReturn(false);

    // STEP 3: execute
    PurchaseOrder purchaseOrder = new PurchaseOrder("Pasta", 4);
    purchaseOrder.purchase(warehouse);

    // STEP 4: verify
    Mockito.verify(warehouse, Mockito.atLeastOnce()).thereAreProducts("Pasta", 4);
    Mockito.verify(warehouse, Mockito.never()).remove("Pasta", 4);
  }
}
