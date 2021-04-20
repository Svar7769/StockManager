package StockManager;

import java.util.*;

public class stockManeger {

    // Inventory variable that can be accesed by all class
    protected static Hashtable<String, Hashtable<String, String>> inv = new Hashtable<>();

    public static void main( String[] args ) {

        // Scanner variable
        Scanner sc = new Scanner(System.in);

        // control variable to control while loop
        boolean control = true;

        System.out.println("Updated Map " + inv);

        // Some printf statement
        System.out.println("WELCOME TO iSTOCKS :");
        // User input for loading methods
        System.out.println("Enter no 1 to 5 to view respective feature");
        int a= sc.nextInt();

        while (true) {
            System.out.println("Enter Ypur Pick \n");
            a= sc.nextInt();
            if (a > 0 && a <= 5) {
                switch (a) {
                    // Add Item
                    case 1:
                        // Data Entry
                        System.out.println("PLEASE ENTER YOUR ITEM DATA  \n");
                        System.out.println("ENTER YOUR NAME:\n");
                        String name = sc.next();
                        System.out.println("ENTER QTY \n");
                        int qty = sc.nextInt();
                        System.out.println("ENTER PRICE \n");
                        float price = sc.nextFloat();

                        // Adding Item to the inventory
                        StockManager.addItem items1 = new addItem(name, qty, price);
                        System.out.println("Updated Inventory " + inv);
                        break;
                    // Update Item

                    case 2:
                        control = false;
                        break;
                    // Display Inventory

                    case 3:
                        break;

                    // Delete Item
                    case 4:
                        break;

                    // Closing the program by braking while loop
                    case 5:
                        System.out.println("Thank you for  Using US");
                        control = false;
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
