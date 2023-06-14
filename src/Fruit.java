import java.util.Scanner;
/**
 * Represents a Fruit item, which is a subclass of FoodItem.
 */
class Fruit extends FoodItem {
    /**
     * Private field to be used for name of Orchard
     */
    private String orchardName;


    /**
     * Constructs a new Fruit object with default values.
     */
    public Fruit() {
        super();
    }

    /**
     * Constructs a new Fruit object with the given orchard name.
     *
     * @param orchardName the name of the orchard supplier
     */
    public Fruit(String orchardName) {
        this.orchardName = orchardName;
    }

    /**
     * Returns the name of the orchard supplier.
     *
     * @return the orchard supplier name
     */
    public String getOrchardName() {
        return orchardName;
    }

    /**
     * Sets the name of the orchard supplier.
     *
     * @param orchardName the orchard supplier name to set
     */
    public void setOrchardName(String orchardName) {
        this.orchardName = orchardName;
    }

    @Override
    public String toString() {
        return super.toString() + "Orchard Supplier: " + orchardName;
    }

    /**
     * Adds a new Fruit item by taking user input.
     *
     * @param scanner the Scanner object used for user input
     * @return true if the item is successfully added, false otherwise
     */
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }

        System.out.print("Enter the name of the orchard supplier: ");
        //clear the input buffer.
        scanner.nextLine();
        String orchardName = scanner.nextLine();
        setOrchardName(orchardName);
        return true;
    }
}
