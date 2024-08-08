package Objects;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a shopping list.
 */
public class ShoppingList {
    /**
     * The shopping list.
     */
    private final ArrayList<String> list = new ArrayList<>();

    /**
     * Adds a new item to the shopping list.
     * @param item the new item
     */
    public void addItem(String item){
        list.add(item);
    }

    /**
     * Displays the list.
     */
    public void display(){
        for (int i=0; i<list.size(); i++){
            System.out.print(i+1 + ". " + list.get(i));
            System.out.println();
        }
    }

    /**
     * Updates an item from the list.
     * @param oldItem The old item to update.
     * @param newItem The new item.
     */
    public void updateItem(String oldItem, String newItem){
        if (list.contains(oldItem)){
            list.set(list.indexOf(oldItem), newItem);
        }else {
            System.out.println("Item not found!");
        }
    }

    /**
     * Deletes an item from the list.
     * @param item the item to be deleted
     */
    public void deleteItem(String item){
        if (list.contains(item)){
            list.remove(item);
        } else {
            System.out.println("Item not found!");
        }
    }

    /**
     * Clears the list.
     */
    public void clearList(){
        list.clear();
    }

    /**
     * Search for a specific item in the list.
     * @param item The item to search.
     */
    public void searchItem(String item){
        if (list.contains(item)){
            System.out.println("Item found in the list!");
        } else {
            System.out.println("Item not found!");
        }
    }
}

/**
 * This class tests the functionality of the {@link ShoppingList} class.
 */
class ShoppingListTest{
    private static final Scanner scanner = new Scanner(System.in);
    private static final ShoppingList list = new ShoppingList();

    public static void main(String[] args) {
        boolean exit = false;
        int option;
        displayOptions();
        while (!exit){
            System.out.println("Choose an option:");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0 -> displayItems();
                case 1 -> addItem();
                case 2 -> updateItem();
                case 3 -> deleteItem();
                case 4 -> searchItem();
                case 5 -> clearList();
                case 6 -> displayOptions();
                case 7 -> exit = true;
            }
        }


    }

    public static void displayOptions(){
        System.out.println("\t 0. Display the shopping list.");
        System.out.println("\t 1. Add an item to the list.");
        System.out.println("\t 2. Update an item from the list.");
        System.out.println("\t 3. Delete an item from the list.");
        System.out.println("\t 4. Search for an item.");
        System.out.println("\t 5. Clear the list.");
        System.out.println("\t 6. Display the options.");
        System.out.println("\t 7. Exit.");
    }

    public static void addItem(){
        System.out.println("Enter the item:");
        list.addItem(scanner.nextLine());
    }

    public static void displayItems(){
        list.display();
    }

    public static void updateItem(){
        System.out.println("Enter the item for update: ");
        String oldItem = scanner.nextLine();
        System.out.println("Enter the new item:");
        String newItem = scanner.nextLine();
        list.updateItem(oldItem,newItem);
    }

    public static void deleteItem(){
        System.out.println("Enter the item:");
        list.deleteItem(scanner.nextLine());
    }

    public static void searchItem(){
        System.out.println("Enter the item:");
        list.searchItem(scanner.nextLine());
    }

    public static void clearList(){
        list.clearList();
    }
}
