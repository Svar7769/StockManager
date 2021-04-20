package StockManager;

import java.util.*;

public class Display {

    void showInventory() {
        // get keys() from Hashtable and iterate
        Enumeration<String> enumeration = stockManeger.inv.keys();

        // iterate using enumeration object
        while (enumeration.hasMoreElements()) {

            String key = enumeration.nextElement();
            System.out.println("Item : " + key);

            Enumeration<String> secondEnumeration = stockManeger.inv.get(key).keys();

            while (secondEnumeration.hasMoreElements()) {
                String secondKey = secondEnumeration.nextElement();
                System.out.println("    " + secondKey + " : " + stockManeger.inv.get(key).get(secondKey));
            }
        }
    }

    void serchInventory(String name) {
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
            System.out.println("Your Inventory does not contain suuch Item\n");
        }
    }
}
