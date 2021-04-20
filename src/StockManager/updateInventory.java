package StockManager;

import java.util.*;

public class updateInventory {
    // variable declaration
    private String name;
    private int qty;

    // Constructor
    updateInventory(String name, int qty) {
        this.name = name;
        this.qty = qty;

        updateItem();
    }

    // Method to modify the content for the given item name
    void updateItem() {
        // Qty of item to be updated
        int preQty =Integer.parseInt(stockManeger.inv.get(name).get("QUANTITY"));
        int newQty = preQty-qty;

        // Condition Chacking
        if (newQty<0){
            System.out.println("You don't have that much item in your inventory");
        } else {
            // Changing Qty in Inv
            stockManeger.inv.get(name).replace("QUANTITY", String.valueOf(newQty));
        }
    }
}
