package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Main extends Application {
    public static final String VERSION = "1.0";
    public static boolean VERBOSE = false;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
        if (args.length > 0 ) {
            if (args[0].equals("verbose") || args[0].equals("-v")) {
                Main.VERBOSE = true;
            } else if (args[0].contains("help") || args[0].contains("-h") || args[0].contains("-?")) {
                System.out.println("Mission to Mars version " + Main.VERSION);
                System.out.println(" ");
                System.out.println("Written by *Hussein SAAD*\n           *Najla OJEIMI*\n           *Wael Al-BASHA* ");
                System.out.println("Command line arguments: ");
                System.out.println("  -v or verbose: display simulation details");
                System.out.println("  -h or help:    display this message");
                System.out.println(" ");
                return;
            }
        }

        Simulation mission = new Simulation(); //Creating a new simulation object

        // U1 rockets phase 1
        if (Main.VERBOSE) {
            System.out.println("Phase 1: U1 Rockets");
            System.out.println(" ");
        }
        ArrayList<Item> u1Phase1 = mission.loadItems("phase-1.txt");
        ArrayList<Rocket> u1Rockets = mission.loadU1(u1Phase1);
        int u1Phase1Cost = mission.runSimulation(u1Rockets);

        // U1 rockets phase 2
        if (Main.VERBOSE) {
            System.out.println("Phase 2: U1 Rockets");
            System.out.println(" ");
        }
        ArrayList<Item> u1Phase2 = mission.loadItems("phase-2.txt");
        u1Rockets = mission.loadU1(u1Phase2);
        int u1Phase2Cost = mission.runSimulation(u1Rockets);

        // U2 rockets phase 1
        if (Main.VERBOSE) {
            System.out.println("Phase 1: U2 Rockets");
            System.out.println(" ");
        }
        ArrayList<Item> u2Phase1 = mission.loadItems("phase-1.txt");
        ArrayList<Rocket> u2Rockets = mission.loadU2(u2Phase1);
        int u2Phase1Cost = mission.runSimulation(u2Rockets);

        // U2 rockets phase 2
        if (Main.VERBOSE) {
            System.out.println("Phase 2: U2 Rockets");
            System.out.println(" ");
        }
        ArrayList<Item> u2Phase2 = mission.loadItems("phase-2.txt");
        u2Rockets = mission.loadU2(u2Phase2);
        int u2Phase2Cost = mission.runSimulation(u2Rockets);

        System.out.println("Results of the Simulation:");
        System.out.println(" ");

        // Display U1 rocket costs
        System.out.println("*******************************************");
        System.out.println("*  Phase 1 with U1: $" + NumberFormat.getNumberInstance(Locale.US).format(u1Phase1Cost)+"          *");
        System.out.println("*  Phase 2 with U1: $" + NumberFormat.getNumberInstance(Locale.US).format(u1Phase2Cost)+"          *");
        System.out.println("*  Total with U1: $" + NumberFormat.getNumberInstance(Locale.US).format((u1Phase1Cost + u1Phase2Cost))+"          *");

        System.out.println("*******************************************");
        System.out.println("                                            ");
        // Display U2 rocket costs
        System.out.println("*******************************************");
        System.out.println("*  Phase 1 with U2: $" + NumberFormat.getNumberInstance(Locale.US).format(u2Phase1Cost)+"          *");
        System.out.println("*  Phase 2 with U2: $" + NumberFormat.getNumberInstance(Locale.US).format(u2Phase2Cost)+"          *");
        System.out.println("*  Total with U2: $" + NumberFormat.getNumberInstance(Locale.US).format((u2Phase1Cost + u2Phase2Cost))+"          *");
        System.out.println("*******************************************");
    }
}
