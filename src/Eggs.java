import java.util.Scanner;

/**
 * The Preserve class represents a food item that is Eggs. It extends the
 * FoodItem class and adds a numTrays attribute.
 */
class Eggs extends FoodItem {
    /**
     * Private field number of trays
     */
    private int numTrays;

    /**
     * Constructs a new Eggs object with default values. Calls the superclass
     * constructor.
     */
    public Eggs() {
        super();
    }

    /**
     * Sets the number of trays
     *
     * @param numTrays the number of trays
     */
    public void setnumTrays(int numTrays) {
        this.numTrays = numTrays;
    }

    /**
     * Returns a string representation of the Eggs object. Includes the
     * superclass toString result and the number of trays
     *
     * @return a string representation of the Eggs object
     */
    @Override
    public String toString() {
        return super.toString() + "Number of trays: " + numTrays;
    }

    /**
     * Prompts the user to add details of the Eggs item. Reads the details from
     * the scanner and sets the number of trays.
     *
     * @param scanner the Scanner object used for user input
     * @return true if the item is successfully added, false otherwise
     */
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }

        System.out.print("Enter the number of trays(12 eggs/tray): ");
        int numTrays = scanner.nextInt();
        setnumTrays(numTrays);

        return true;
    }
}
