package StockManager;

import java.util.*;

public class stockManeger {

    // Inventory variable that can be accesed by all class
    protected static Hashtable<String, Hashtable<String, String>> inv = new Hashtable<>();
    protected static String DIR_PATH = "C:\\Users\\svarp\\IdeaProjects\\StockManager\\src\\StockManager\\DATA.json";

    public static void main( String[] args ) {

        // Loading Data From Hash Table
        storeJson.loadDATA();

        // Class Variable declaration
        StockManager.Display display = new Display();
        StockManager.updateInventory updateItem = new updateInventory();
        StockManager.addItem item = new addItem();
        StockManager.search search = new search();

        // Variable Declaration
        String name;
        int qty;
        float price;

        // Scanner variable
        Scanner sc = new Scanner(System.in);

        // control variable to control while loop
        boolean control = true;

        System.out.println("Updated Map " + inv);

        // Some printf statement
        System.out.println("WELCOME TO iSTOCKS :");

        // User input for loading methods
        while (control) {
            System.out.println("Enter Your Pick");
            System.out.println("Enter 1 :   Display Inventory\n" +
                    "Enter 2 :  Buy Item\n" +
                    "Enter 3 :  Sell Item\n" +
                    "Enter 4 :  Search Item\n" +
                    "Enter 5 :  Delete Item\n" +
                    "Enter 0:   Exit\n");
            int a= sc.nextInt();
            if (a >= 0 && a <= 5) {
                switch (a) {
                    // Close Loop
                    case 0 :
                        System.out.println("Thank you for  Using US");
                        control = false;
                        storeJson.storeToJson();
                        break;

                    // Display Inventory
                    case 1:
                        display.showInventory();
                        break;

                    // Buy Item
                    case 2:
                        // Take item Info
                        System.out.println("PLEASE ENTER YOUR ITEM DATA  \n");
                        System.out.println("ENTER YOUR NAME:\n");
                        name = sc.next();
                        System.out.println("ENTER QTY \n");
                        qty = sc.nextInt();
                        System.out.println("ENTER PRICE \n");
                        price = sc.nextFloat();

                        // check if item exists in your inventory
                        if (stockManeger.inv.containsKey(name)){
                            updateItem.buyExistingItem(name, qty, price);
                        } else {
                            updateItem.buyNewItem("svar", 12, 12);
                            updateItem.buyNewItem("SVAR", 12, 12);
                            updateItem.buyNewItem("SVar", 12, 12);
                            updateItem.buyNewItem(name, qty, price);
                        }
                        break;

                    // Sold Item
                    case 3:
                        // Take Item Info
                        System.out.println("PLEASE ENTER YOUR ITEM DATA  \n");
                        System.out.println("ENTER YOUR NAME:\n");
                        name = sc.next();
                        System.out.println("ENTER QTY \n");
                        qty = sc.nextInt();
                        System.out.println("ENTER PRICE \n");
                        price = sc.nextFloat();

                        // check if item exists in your Inventory
                        if (stockManeger.inv.containsKey(name)) {
                            updateItem.sellItem(name, qty, price);
                        } else {
                            System.out.println("You dont have item that you sold\n");
                        }

                        break;

                    // Search Item
                    case 4:
                        System.out.println("Enter name of item you want to search:\n");
                        // Taking user Input
                        name = sc.next();
                        search.searchInventory(name);
                        break;

                    // Delete Inventory
                    case 5:
                        System.out.println("Enter name of item you want to delete:\n");
                        // Taking user Input
                        name = sc.next();

                        // Calling delete Method
                        updateItem.deleteItem(name);

                        // Show Inventory
                        display.showInventory();
                        break;
                    default:
                        System.out.println("INVALID INPUT");
                }
            } else {
                System.out.println("ENTER BETWEEN 1 TO 5 YOU FOOL");
            }
        }
    }
}
