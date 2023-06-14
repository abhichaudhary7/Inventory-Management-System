import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents an inventory management system for food items.
 */
public class DriverClass {
    /**
     * The main method to run the inventory management system.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        //while loop to continue until user press option  and exit the loop
        while (!exit) {
            try {
                displayMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        inventory.addItem(scanner);
                        break;
                    case 2:
                        System.out.println(inventory.toString());
                        break;
                    case 3:
                        inventory.updateQuantity(scanner, true);
                        break;
                    case 4:
                        inventory.updateQuantity(scanner, false);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Please enter an integer between 1 and 5.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("********INVALID INPUT********\n"
                        + "Enter an integer between 1 and 5.");
                scanner.next();
            }
        }
    }

    /**
     * Displays the menu options for the inventory management system.
     */
    public static void displayMenu() {
        System.out.println("\n1: Add item to inventory");
        System.out.println("2: Display current inventory");
        System.out.println("3: Buy item(s)");
        System.out.println("4: Sell item(s)");
        System.out.println("5: To Exit");
        System.out.print("> ");
    }
}
