import java.util.ArrayList; //import the ArrayList class

//implement the interface Spaceship
// nb the implements keyword is used to implement an interface

public class Rocket implements Spaceship {
//the class is with private attributes fields
    private ArrayList<Item> items;
    private int cost;
    private double rocketWeight;
    private double maxWeight;
    private int id;


    //Rocket constructor
    public Rocket(int cost, double rocketWeight, double maxWeight) {
        items = new ArrayList<>(); //create an Arraylist object items
        this.id = -1;
        this.cost = cost;// cost of rocket in Millions ($)
        this.rocketWeight = rocketWeight;// weight of unloaded rocket in kilograms
        this.maxWeight = maxWeight;// max weight of rocket including cargo in kilograms
    }


    public int getCost() {
        return cost;
    } //Returns the cost of the rocket in millions $

    /**
    public void setCost(int cost) {
        this.cost = cost;
    }
    */

    public double getRocketWeight() {
        return rocketWeight;
    } //Returns weight of unloaded rocket in kilograms.

    /**
    public void setRocketWeight(double rocketWeight) {
        this.rocketWeight = rocketWeight;
    }
     */

    public double getMaxWeight() {
        return maxWeight;
    } //Returns maximum weight of rocket plus cargo in kilograms.

    /**
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
    */


    public int getId() {
        return id;
    } //Returns the rocket ID number

    /**
    public void setId(int id) {
        this.id = id;
    }
     */

    /** when u1 and u2 extend the rocket class ,they will override these methods to return true or false
     based on the actual probability of each type */

    @Override
    public boolean launch() {
        return true;
    } //launch is a boolean method to test if launch was successful and has not crashed and should always return true


    @Override
    public boolean land() {
        return true;
    } //land is a boolean method to test if the landing was successful and should always return true

    /** Indicates whether a rocket can carry an Item
     * @param item the Item object to be loaded
     * @return true if the Item object can be loaded, false if the Item object cannot be loaded.
     */

    @Override
    public boolean canCarry(Item item) {
        return (getCargoWeight() + item.getWeight()) <= (maxWeight - rocketWeight);
    }

    /**
     * Add Item object to rocket's cargo
     * @param item the Item object to add.
     */
    @Override
    public void carry(Item item) {
        items.add(item);
    }

    /**
     * Calculate and return the combined weight of all Item objects loaded onto a rocket.
     * @return the combined weight of of all Item objects loaded onto a rocket
     */
    public double getCargoWeight() {
        double cargoWeight = 0;
        for (Item cargoItem : items) {
            cargoWeight = cargoWeight + cargoItem.getWeight();
        }
        return cargoWeight;
    }

}
