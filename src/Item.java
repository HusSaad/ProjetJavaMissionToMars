/**
 *Creating an item class  which will be carried by the rockets
 */
public class Item {

    private String name;
    private int weight;

    //Item constructor containing 2 parameters
    public Item(String name,  int weight) {
        this.name = name; //name of the Item
        this.weight = weight; //weight of the Item in kilograms
    }

    //Returns the name of the Item
    public String getName() {
        return name;
    }

    /**
     public void setName(String name) {
     this.name = name;
     }
     */

    //Returns the weight of the Item in kilograms
    public int getWeight() {
        return weight;
    }
    /**
    public void setWeight(int weight) {
        this.weight = weight;
    }
     */
}
