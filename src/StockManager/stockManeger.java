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
        String name="",qty="",price="",a="";

        // Scanner variable
        Scanner sc = new Scanner(System.in);

        // control variable to control while loop
        boolean control = true;
        boolean innerControl = false;

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

            do {
                if (sc.hasNextInt()){
                    a = sc.nextLine();
                    innerControl = true;
                } else {
                    System.out.println("You have entered incorrect input! Please enter a whole number only");
                    a = sc.nextLine();
                }
            } while (innerControl == false);
            innerControl = false;

            switch (a) {
                // Close Loop
                case "0" :
                    System.out.println("Thank you for  Using US");
                    control = false;
                    storeJson.storeToJson();
                    break;
                    // Display Inventory
                case "1":
                    display.showInventory();
                    break;

                // Buy Item
                case "2":
                    // Take item Info
                    System.out.println("PLEASE ENTER YOUR ITEM DATA  \n");
                    System.out.println("ENTER YOUR NAME:\n");
                    do {
                        if (sc.hasNextInt()){
                            System.out.println("You have entered incorrect input! Please String only");
                            name = sc.next();
                        } else {
                            name = sc.next();
                            innerControl = true;
                        }
                    } while (innerControl == false);
                    innerControl = false;

                    System.out.println("ENTER QTY \n");

                    do {
                        if (sc.hasNextInt()) {
                            qty = sc.next();
                            innerControl = true;
                        } else {
                            System.out.println("You have entered incorrect input! Please enter a whole number only");
                            qty = sc.next();
                        }
                    }while (innerControl == false);
                    innerControl = false;

                    System.out.println("ENTER PRICE \n");
                    do {
                        if (sc.hasNextInt()) {
                            price = sc.next();
                            innerControl = true;
                        } else {
                            System.out.println("You have entered incorrect input! Please enter a Number only");
                            price = sc.next();
                        }
                    }while (innerControl == false);
                    innerControl = false;

                    // check if item exists in your inventory
                    if (stockManeger.inv.containsKey(name)){
                        updateItem.buyExistingItem(name, Integer.parseInt(qty), Float.parseFloat(price));
                    } else {
                        updateItem.buyNewItem(name, Integer.parseInt(qty), Float.parseFloat(price));
                    }
                    break;

                // Sold Item
                case "3":
                    // Take Item Info
                    System.out.println("PLEASE ENTER YOUR ITEM DATA  \n");
                    System.out.println("ENTER YOUR NAME:\n");
                    do {
                        if (sc.hasNextInt()) {
                            System.out.println("You have entered incorrect input! Please enter a String only");
                            name = sc.next();
                        } else {
                            name = sc.next();
                            innerControl = true;
                        }
                    }while (innerControl == false);
                    innerControl = false;

                    System.out.println("ENTER QTY \n");
                    do {
                        if (sc.hasNextInt()) {
                            qty = sc.next();
                            innerControl = true;
                        } else {
                            System.out.println("You have entered incorrect input! Please enter a whole number only");
                            qty = sc.next();
                        }
                    }while (innerControl == false);
                    innerControl = false;

                    System.out.println("ENTER PRICE \n");
                    do {
                        if (sc.hasNextInt()) {
                            price = sc.next();
                            innerControl = true;
                        } else {
                            System.out.println("You have entered incorrect input! Please enter a number only");
                            price = sc.next();
                        }
                    }while (innerControl == false);
                    innerControl = false;

                    // check if item exists in your Inventory
                    if (stockManeger.inv.containsKey(name)) {
                        updateItem.sellItem(name, Integer.parseInt(qty), Float.parseFloat(price));
                    } else {
                        System.out.println("You dont have item that you sold\n");
                    }

                    break;

                // Search Item
                case "4":
                    System.out.println("Enter name of item you want to search:\n");
                    // Taking user Input
                    name = sc.next();
                    search.searchInventory(name);
                    break;

                // Delete Inventory
                case "5":
                    System.out.println("Enter name of item you want to delete:\n");
                    // Taking user Input
                    name = sc.next();

                    // Calling delete Method
                    updateItem.deleteItem(name);

                        // Show Inventory
                    display.showInventory();
                    break;
                default:
                    System.out.println("ENTER BETWEEN 1 TO 5 YOU FOOL");
            }
            innerControl=true;
        }
    }
}
