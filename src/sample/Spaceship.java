package sample;

/**
 * Creating an interface containing the definitions of the methods that will be used in this project
 */
public interface Spaceship {
    /** Indicates whether a launch was successful. */
    public boolean launch();
    /** Indicates whether a landing was successful. */
    public boolean land();
    /** Indicates whether a rocket can carry an Item. */
    public boolean canCarry(Item item);
    /** Adds Item weight to a rocket's current weight,
    ie. loads a rocket. */
    public void carry(Item item);
}
