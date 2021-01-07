package sample;// the extends keyword is used to extend a class (indicates that a class is inherited from another class)

public class U2 extends Rocket {

    private static int count = 0;

    private int id;

    public U2() {
        super(120, 18000, 29000);
        count++;
        this.id = count;
    }

    // Test whether launch was successful or not. @return true if launch is a success, false if launch fails.

    @Override
    public boolean launch() {
        int random = (int) (Math.random() * 100) + 1;
        return random > (4.0 * getCargoWeight() / (getMaxWeight() - getRocketWeight()));
    }

    //Test whether landing was successful or not. @return true if launch is a success, false if launch fails.

    @Override
    public boolean land() {
        int random = (int) (Math.random() * 100) + 1;
        return random > (8.0 * getCargoWeight() / (getMaxWeight() - getRocketWeight()));
    }


    public int getId() {
        return id;
    } //Returns the rocket ID number
}