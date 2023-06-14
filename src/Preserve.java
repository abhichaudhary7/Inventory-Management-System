import java.util.Scanner;

/**
 * The Preserve class represents a food item that is preserved. It extends the
 * FoodItem class and adds a jarSize attribute.
 */
class Preserve extends FoodItem {
    /**
     * Private field size of jar
     */
    private int jarSize;

    /**
     * Constructs a new Preserve object with default values. Calls the superclass
     * constructor.
     */
    public Preserve() {
        super();
    }

    /**
     * Constructs a new Preserve object with the specified jar size. Calls the
     * superclass constructor and sets the jar size.
     *
     * @param jarSize the size of the jar
     */
    public Preserve(int jarSize) {
        this.jarSize = jarSize;
    }

    /**
     * Retrieves the size of the jar.
     *
     * @return the size of the jar
     */
    public int getJarSize() {
        return jarSize;
    }

    /**
     * Sets the size of the jar.
     *
     * @param jarSize the size of the jar
     */
    public void setJarSize(int jarSize) {
        this.jarSize = jarSize;
    }

    /**
     * Returns a string representation of the Preserve object. Includes the
     * superclass's toString result and the jar size.
     *
     * @return a string representation of the Preserve object
     */
    @Override
    public String toString() {
        return super.toString() + "Orchard Supplier: " + jarSize;
    }

    /**
     * Prompts the user to add details of the Preserve item. Reads the details from
     * the scanner and sets the jar size.
     *
     * @param scanner the Scanner object used for user input
     * @return true if the item is successfully added, false otherwise
     */
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }

        System.out.print("Enter the Size of Jar in millilitres: ");
        int jarSize = scanner.nextInt();
        setJarSize(jarSize);

        return true;
    }
}