
import java.io.File;//Import the File class
import java.io.FileNotFoundException;// Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner;// Import the Scanner class to read text files

public class Simulation {

    //Loads all items from the given text file.
    // Format of the file is "itemName=weightInKilograms" and filling up the rockets.

    public ArrayList<Item> loadItems(String filename) {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(filename);

        try {
            Scanner in = new Scanner(file);//we use the Scanner class to read the contents of the text file

            while (in.hasNextLine()) { // check if there is a next line
                String line = in.nextLine();
                // The indexOf() method returns the position of the first occurrence of specified character(s) in a string.
                int index = line.indexOf("=");//the index is the character "="
                String name = line.substring(0, index);//the name is the part before the "="
                int weight =  Integer.parseInt(line.substring(index + 1));//the weight is the part after the "="
                Item item = new Item(name, weight);
                items.add(item);//adding the new object
            }
            //The catch keyword catches exceptions generated by try statement above.
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File " + filename + " not found!");
        }

        return items;
    }

    /**
     * Load items into U1 rockets
     * @param items an ArrayList of Item objects
     * @return an ArrayList of Rocket objects loaded with the given Item objects
     */
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        while(items.size() > 0) {
            // create new U1
            U1 u1 = new U1();

            if (Main.VERBOSE) {

                System.out.println("  U1 rocket #" + u1.getId());
                System.out.println("  ****************************** ");
            }

            // fill U1 with items until full
            for (int i = items.size() - 1; i >= 0; i--) {
                if (u1.canCarry(items.get(i))) {
                    u1.carry(items.get(i));
                    if (Main.VERBOSE) {
                        System.out.println("  " + items.get(i).getName() + " " + items.get(i).getWeight());
                    }
                    items.remove(i);
                }
            }

            // add U1 to list
            rockets.add(u1);
            if (Main.VERBOSE) {
                System.out.println("  Total Cargo: " + u1.getCargoWeight());
                System.out.println("");
            }
        }

        return rockets;
    }

    /**
     * Load items into U2 rockets
     * @param items an ArrayList of Item objects
     * @return an ArrayList of Rocket objects loaded with the given Item objects
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        while(items.size() > 0) {
            // create new U2
            U2 u2 = new U2();

            if (Main.VERBOSE) {
                System.out.println("  U2 rocket #" + u2.getId());
                System.out.println("  ****************************** ");
            }

            // fill U2 with items until full
            for (int i = items.size() - 1; i >= 0; i--) {
                if (u2.canCarry(items.get(i))) {
                    u2.carry(items.get(i));
                    if (Main.VERBOSE) {
                        System.out.println("  " + items.get(i).getName() + " " + items.get(i).getWeight());
                    }
                    items.remove(i);
                }
            }

            // add U2 to list
            rockets.add(u2);
            if (Main.VERBOSE) {
                System.out.println("  Total Cargo: " + u2.getCargoWeight());
                System.out.println("");
            }
        }

        return rockets;
    }

    //Launches the rockets. If a rocket fails on launch or fails to land, the rocket is relaunched.
    public int runSimulation(ArrayList<Rocket> rockets) {
        //@param rockets an ArrayList of Rocket objects to launch
        int totalCost = 0;

        for (int i = rockets.size() - 1; i >= 0; i--) {
            boolean launch;
            boolean land;
            do {
                totalCost = totalCost + rockets.get(i).getCost();
                // A running tally of rocket cost is tabulated including the cost of failed rockets.
                launch = rockets.get(i).launch();
                land = rockets.get(i).land();
                if (Main.VERBOSE) {
                    if (!launch) {
                        System.out.println(" The Rocket " + rockets.get(i).getId() + " has exploded on launch! we will try to build and launch the rocket again .");
                    } else {
                        System.out.print("  The Rocket " + rockets.get(i).getId() + " successfully launched !! ");
                        if (!land) {
                            System.out.println(" but crashed on landing! we Will rebuild the rocket and try to launch it again.");
                        } else {
                            System.out.println(" and successfully landed on destination !! ");
                        }
                    }

                }
            } while (!launch || !land);
            rockets.remove(i);
        }

        if (Main.VERBOSE) {
            System.out.println("");
        }

        return totalCost * 1000000;//Return the total cost to launch all rockets, including failed rockets.
    }
}