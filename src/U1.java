
// the extends keyword is used to extend a class (indicates that a class is inherited from another class)

public class U1 extends Rocket {

    private static int count = 0;

    private int id;

    public U1() {
        super(100, 10000, 18000);//The super keyword refers to superclass (parent) objects
        count++;
        this.id = count;
    }


     // Test whether launch was successful or not. @return true if launch is a success, false if launch fails.

    @Override
    public boolean launch() {
        int random = (int) (Math.random() * 100) + 1;
        return random > (5.0 * getCargoWeight() / (getMaxWeight() - getRocketWeight()));
    }

    //Test whether landing was successful or not. @return true if launch is a success, false if launch fails.

    @Override
    public boolean land() {
        int random = (int) (Math.random() * 100) + 1;
        return random > (1.0 * getCargoWeight() / (getMaxWeight() - getRocketWeight()));
    }


    public int getId() {
        return id;
    } //Returns the rocket ID number
}
