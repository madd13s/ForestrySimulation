import java.util.Random;

/**
 * Represents a tree with species, year planted, height, and growth rate.
 * @author Madelyn Steinour
 * @version 1.0
 * @see Tree
 */
public class Tree {

    // Constants
    private static final int MINIMUM_YEAR_PLANTED = 2000;
    private static final int MAXIMUM_YEAR_PLANTED = 25;
    private static final double MINIMUM_HEIGHT = 10.0;
    private static final double MAXIMUM_HEIGHT = 20.0;
    private static final double MINIMUM_GROWTH_RATE = 10.0;
    private static final double MAXIMUM_GROWTH_RATE = 20.0;

    // Variables
    public enum Species { Birch, Maple, Fir }
    private Species species; // The species of the tree
    private int yearPlanted; // The year the tree was planted
    private double height; // The height of the tree in feet
    private double growthRate; // The growth rate as a percentage

    /**
     * Constructor to initialize Tree variables.
     *
     * @param species Species of the Tree.
     * @param yearPlanted Year the Tree was planted.
     * @param height Height of the Tree in feet.
     * @param growthRate Growth rate as a percentage.
     * @see Tree
     */
    public Tree(Species species, int yearPlanted, double height, double growthRate) {
        this.species = species;
        this.yearPlanted = yearPlanted;
        this.height = height;
        this.growthRate = growthRate;

    }// End of Tree constructor

    /**
     * Generates a random tree.
     *
     * @return Tree A tree with random species, year planted, height, and growth rate.
     * @see Tree
     */
    public static Tree generateRandomTree() {
        Random random = new Random();
        Species[] speciesArray = Species.values();
        Species species = speciesArray[random.nextInt(speciesArray.length)];

        int yearPlanted = MINIMUM_YEAR_PLANTED + random.nextInt(MAXIMUM_YEAR_PLANTED); // Year between 2000 and 2024
        double height = MINIMUM_HEIGHT + random.nextDouble() * MAXIMUM_HEIGHT; // Height between 10 and 20 feet
        double growthRate = MINIMUM_GROWTH_RATE + random.nextDouble() * MAXIMUM_GROWTH_RATE; // Growth rate between 10% and 20%

        return new Tree(species, yearPlanted, height, growthRate);

    }// End of generateRandomTree method

    /**
     * Simulates a year of growth based on a Tree's growth rate.
     *
     * @see Tree
     */
    public void simulateYear() {
        height *= 1 + growthRate / 100;

    }// End of simulateYear method

    /**
     * Retrieve the height of a tree.
     *
     * @return height The Tree height in feet.
     * @see Tree
     */
    public double getHeight() {
        return height;

    }// End of getHeight method

    /**
     * Converts the Tree variables to CSV format.
     *
     * @return string Tree species, year planted, height, and growth rate in CSV format.
     * @see Tree
     */
    public String toCSV() {
        return species + "," + yearPlanted + "," + height + "," + growthRate;

    }// End of toCSV method

    /**
     * Constructs a string of the Tree information.
     *
     * @return string Tree species, year planted, height, and growth rate.
     * @see Tree
     */
    @Override
    public String toString() {
        return species + " " + yearPlanted + " " + String.format("%.2f", height) + "' " + String.format("%.1f", growthRate) + "%";

    }// End of toString method

}// End of Tree class


