import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a food item.
 */
public class FoodItem {
    /**
     * field item code
     */
    private int itemCode;
    /**
     * field name of item
     */
    private String itemName;
    /**
     * private float item Price
     */
    private float itemPrice;
    /**
     * Private int quantity in stock
     */
    private int itemQuantityInStock;

    /**
     * Private float cost of item
     */
    private float itemCost;

    /**
     * Default constructor for FoodItem class.
     */
    public FoodItem() {
    }

    /**
     * Constructor for FoodItem class with specified parameters.
     *
     * @param itemCode            the item code
     * @param itemName            the item name
     * @param itemPrice           the item price
     * @param itemQuantityInStock the quantity of the item in stock
     * @param itemCost            the item cost
     */
    public FoodItem(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantityInStock = itemQuantityInStock;
        this.itemCost = itemCost;
    }

    /**
     * Returns a string representation of the FoodItem.
     *
     * @return a string representation of the FoodItem
     */
    public String toString() {
        return "Item : " + itemCode + " " + itemName + " " + itemQuantityInStock + " Price: $" + itemPrice + " Cost: $"
                + itemCost + " ";
    }

    /**
     * Updates the quantity of the item in stock by the specified amount.
     *
     * @param amount the amount to update the item quantity
     * @return true if the update was successful, false otherwise
     */
    public boolean updateItem(int amount) {
        if (amount >= 0) {
            itemQuantityInStock += amount;
            return true;
        } else {
            itemQuantityInStock += amount;
            return true;

        }
    }

    /**
     * Checks if the current FoodItem is equal to the specified FoodItem.
     *
     * @param item the FoodItem to compare
     * @return true if the FoodItems are equal, false otherwise
     */
    public boolean isEqual(FoodItem item) {
        return this.itemCode == item.itemCode;
    }

    /**
     * Adds a new FoodItem to the inventory by getting input from the user.
     *
     * @param scanner the Scanner object to read user input
     * @return true if the FoodItem was successfully added, false otherwise
     */
    public boolean addItem(Scanner scanner) {
        //try catch block to check the user input
        try {
            System.out.print("Enter the code for the item: ");
            int code = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            //if code is already present, we can directly buy/sell the item
            if (code == itemCode) {
                System.out.println("Item with code " + code + " already exists.");
                return false;
            }

            //while loop with validation, if user does not
            // enter any name; it will keep asking for an input
            boolean validInput = false;
            String name = "";
            while (!validInput) {
                System.out.print("Enter the name for the item: ");
                name = scanner.nextLine();
                if (!name.isEmpty()) {
                    validInput = true;
                } else {
                    System.out.println("Invalid entry");
                }
            }


            // while loop with validation, if user does not enter a number which is positive
            // it will keep asking the user to enter price.
            validInput = false;
            float price = 0;
            while (!validInput) {
                System.out.print("Enter the sales price of the item: ");
                price = scanner.nextFloat();
                if (price >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid entry");
                }
            }

            // while loop with validation, if user does not enter an integer which is positive
            // it will keep asking the user to enter quantity of item.
            validInput = false;
            int quantity = 0;
            while (!validInput) {
                System.out.print("Enter the quantity for the item: ");
                if (scanner.hasNextInt()) {
                    quantity = scanner.nextInt();
                    if (quantity >= 0) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid input for quantity. Please enter a non-negative integer.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Consume the invalid input
                }
            }


            // while loop with validation, if user does not enter a number which is positive
            // it will keep asking the user to enter cost.
            validInput = false;
            float cost = 0;
            while (!validInput) {
                System.out.print("Enter the cost of the item: ");
                cost = scanner.nextFloat();
                if (cost >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid entry");
                }
            }

            // set fields in class Inventory
            setItemCode(code);
            setItemName(name);
            setItemPrice(price);
            setItemQuantityInStock(quantity);
            setItemCost(cost);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct input.");
            scanner.nextLine(); // Consume the invalid input
            return addItem(scanner); // Ask for inputs again
        }

        return true;
    }


    /**
     * Gets the item code.
     *
     * @return the item code
     */
    public int getItemCode() {
        return itemCode;
    }

    /**
     * Gets the item name.
     *
     * @return the item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Gets the item price.
     *
     * @return the item price
     */
    public float getItemPrice() {
        return itemPrice;
    }

    /**
     * Gets the quantity of the item in stock.
     *
     * @return the quantity of the item in stock
     */
    public int getItemQuantityInStock() {
        return itemQuantityInStock;
    }

    /**
     * Gets the item cost.
     *
     * @return the item cost
     */
    public float getItemCost() {
        return itemCost;
    }

    /**
     * Sets the item code.
     *
     * @param itemCode the item code to set
     */
    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * Sets the item name.
     *
     * @param itemName the item name to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Sets the item price.
     *
     * @param itemPrice the item price to set
     */
    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Sets the quantity of the item in stock.
     *
     * @param itemQuantityInStock the quantity of the item in stock to set
     */
    public void setItemQuantityInStock(int itemQuantityInStock) {
        this.itemQuantityInStock = itemQuantityInStock;
    }

    /**
     * Sets the item cost.
     *
     * @param itemCost the item cost to set
     */
    public void setItemCost(float itemCost) {
        this.itemCost = itemCost;
    }

    /**
     * Prompts the user to enter an item code and checks if it matches the current
     * item code.
     *
     * @param scanner the Scanner object to read user input
     * @return true if the entered item code matches the current item code, false
     *         otherwise
     */
    public boolean inputCode(Scanner scanner) {
        System.out.print("Enter the code for item: ");
        int code = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        return code == itemCode;
    }
}
