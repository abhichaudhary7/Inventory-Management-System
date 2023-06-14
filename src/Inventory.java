import java.util.Scanner;

/**
 * Represents an inventory of food items.
 */
public class Inventory {
    /**
     * Private inventory
     */
    private FoodItem[] inventory;
    /**
     * Private int number of Items
     */
    private int numItems;

    /**
     * Default constructor for Inventory class. Initializes the inventory array with
     * a capacity of 80 and sets the number of items to 0.
     */
    public Inventory() {
        inventory = new FoodItem[80];
        numItems = 0;
    }

    /**
     * Checks if a food item with the same item code already exists in the
     * inventory.
     *
     * @param itemCode the FoodItem object to check for
     * @return the index of the existing item if found, -1 otherwise
     */
    public int alreadyExists(FoodItem itemCode) {
        for (int i = 0; i < numItems; i++) {
            if (inventory[i].isEqual(itemCode)) {
                return i; // Return the index of the existing item
            }
        }
        return -1; // Item does not exist in inventory
    }

    /**
     * Adds a new food item to the inventory by getting input from the user.
     *
     * @param scanner the Scanner object to read user input
     * @return true if the food item was successfully added, false otherwise
     */
    public boolean addItem(Scanner scanner) {

        System.out.print("Enter the type of item (Fruit: f, Vegetable: v, Preserve: p, Eggs: e): ");
        String type = scanner.next();
        if (!(type.equals("f") || type.equals("v") || type.equals("p") || type.equals("e"))) {
            System.out.println("*****Invalid Input*****");
            addItem(scanner);
        }
        FoodItem item = null;
        boolean added = false;


        switch (type) {
            case "f":
                item = new Fruit();
                added = item.addItem(scanner);
                break;
            case "v":
                item = new Vegetable();
                added = item.addItem(scanner);
                break;
            case "p":
                item = new Preserve();
                added = item.addItem(scanner);
                break;
            case "e":
                item = new Eggs();
                added = item.addItem(scanner);
                break;
            default:
                System.out.println("Invalid item type.");
                break;
        }

        if (added) {
            int index = alreadyExists(item);

            if (index != -1) {
                System.out.println("Item already exists in the inventory. Updating the quantity.");
                int quantity = item.getItemQuantityInStock();
                inventory[index].updateItem(quantity);
            } else {
                inventory[numItems] = item;
                numItems++;
            }
        }
        return added;
    }

    /**
     * Updates the quantity of a food item in the inventory by buying or selling a
     * specified quantity.
     *
     * @param scanner   the Scanner object to read user input
     * @param buyOrSell true if buying, false if selling
     * @return true if the quantity update was successful, false otherwise
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
        if(numItems==0) {
            System.out.println("Error..... could not "+(buyOrSell? "buy item." : "sell item."));
            return false;
        }

        System.out.print("Enter the item code: ");
        int code = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        int index = -1;

        for (int i = 0; i < numItems; i++) {
            if (inventory[i].getItemCode() == code) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Item with code " + code + " not found in the inventory.");
            return false;
        }

        System.out.print("Enter the quantity to " + (buyOrSell ? "buy: " : "sell: "));
        int quantity = scanner.nextInt();

        if (buyOrSell) {
            inventory[index].updateItem(quantity);
        } else {
            if (inventory[index].getItemQuantityInStock() < quantity) {
                System.out.println("Insufficient quantity available to sell.");
                return false;
            } else {
                quantity = (0-quantity);
                inventory[index].updateItem(quantity);
            }

        }

        return true;
    }

    /**
     * Generates a string representation of the inventory.
     *
     * @return the string representation of the inventory
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if (numItems == 0) {
            sb.append("There are no items in the inventory");
        } else {

            for (int i = 0; i < numItems; i++) {

                sb.append(inventory[i].toString());
            }

        }
        return sb.toString();
    }
}
