package StockManager;

import java.util.*;

public class addItem {
    private String name;
    private int qty;
    private float price;

    addItem(String name,int qty, float price){
        this.name = name;
        this.qty = qty;
        this.price = price;

        addToInventory();
    }

    void addToInventory() {

        // Making an value
        Hashtable<String, String> itemInfo = new Hashtable<>();

        // Placing Value in hashTable
        itemInfo.put("PRICE", String.valueOf(this.price));
        itemInfo.put("QUANTITY", String.valueOf(this.qty));


        // adding it to the Inv
        stockManeger.inv.put(name, itemInfo);
    }
}
