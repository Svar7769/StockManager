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
}
