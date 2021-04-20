package StockManager;

import java.util.Enumeration;

public class search {
    // Creating Constructor
    search() {}

    void searchInventory(String name) {
        // Check if th e key exists
        if (stockManeger.inv.containsKey(name)){
            // Storing value keys of the item in String Enumeration
            Enumeration<String> Enumeration = stockManeger.inv.get(name).keys();

            // accessing those keys using while loop
            while (Enumeration.hasMoreElements()) {
                String secondKey = Enumeration.nextElement();
                System.out.println("    " + secondKey + " : " + stockManeger.inv.get(name).get(secondKey));
            }

        } else {
            // If the Does not Exist
            System.out.println("Your Inventory does not contain such Item\n");
        }
    }
}
