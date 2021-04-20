package StockManager;

import java.util.*;

public class updateInventory {
    // Constructor
    public updateInventory() {
    }

    // Method to modify the content for the given item name
    void updateItem(String name, int qty) {
        // Qty of item to be updated
        int preQty =Integer.parseInt(stockManeger.inv.get(name).get("QUANTITY"));
        int newQty = preQty-qty;

        // Condition Checking
        if (newQty<0){
            System.out.println("You don't have that much item in your inventory");
        } else {
            // Changing Qty in Inv
            stockManeger.inv.get(name).replace("QUANTITY", String.valueOf(newQty));
        }
    }

    // Delete method
    void deleteItem(String name) {
        if (stockManeger.inv.containsKey(name)){
            stockManeger.inv.remove(name);
        } else {
            // If the Does not Exist
            System.out.println("Your Inventory does not contain such Item\n");
        }
    }
}
