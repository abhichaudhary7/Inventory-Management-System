import java.util.Scanner;

/**
 * The Vegetable class represents a food item that is a vegetable. It extends
 * the FoodItem class and adds a farmName attribute.
 */
class Vegetable extends FoodItem {
    /**
     * Private field name of the farm
     */
    private String farmName;

    /**
     * Retrieves the name of the farm.
     *
     * @return the name of the farm
     */
    public String getFarmName() {
        return farmName;
    }

    /**
     * Constructs a new Vegetable object with the specified farm name. Sets the farm
     * name.
     *
     * @param farmName the name of the farm
     */
    public Vegetable(String farmName) {
        this.farmName = farmName;
    }

    /**
     * Sets the name of the farm.
     *
     * @param farmName the name of the farm
     */
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    /**
     * Constructs a new Vegetable object with default values.
     */
    public Vegetable() {
    }

    /**
     * Returns a string representation of the Vegetable object. Includes the
     * superclass's toString result and the farm name.
     *
     * @return a string representation of the Vegetable object
     */
    @Override
    public String toString() {
        return super.toString() + "Farm name: " + farmName;
    }

    /**
     * Prompts the user to add details of the Vegetable item. Reads the details from
     * the scanner and sets the farm name.
     *
     * @param scanner the Scanner object used for user input
     * @return true if the item is successfully added, false otherwise
     */
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }

        System.out.println("Enter the name of the farm supplier: ");
        scanner.nextLine();
        String farmName = scanner.nextLine();
        setFarmName(farmName);

        return true;
    }
}
