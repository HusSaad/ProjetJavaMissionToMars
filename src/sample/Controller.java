package sample;

import javafx.event.ActionEvent;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Controller {

    public void btn(ActionEvent event){

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
    public void btnu1(ActionEvent event){
        Simulation mission = new Simulation(); //Creating a new simulation object

        // U1 rockets phase 1

        System.out.println("Phase 1: U1 Rockets");
        System.out.println(" ");

        ArrayList<Item> u1Phase1 = mission.loadItems("phase-1.txt");
        ArrayList<Rocket> u1Rockets = mission.loadU1(u1Phase1);
        int u1Phase1Cost = mission.runSimulation(u1Rockets);
        System.out.println("*  Phase 1 with U1: $" + NumberFormat.getNumberInstance(Locale.US).format(u1Phase1Cost)+" *");

        // U1 rockets phase 2

        System.out.println("Phase 2: U1 Rockets");
        System.out.println(" ");
        ArrayList<Item> u1Phase2 = mission.loadItems("phase-2.txt");
        u1Rockets = mission.loadU1(u1Phase2);
        int u1Phase2Cost = mission.runSimulation(u1Rockets);
        System.out.println("*  Phase 2 with U1: $" + NumberFormat.getNumberInstance(Locale.US).format(u1Phase2Cost)+" *");
        System.out.println(" ");
        System.out.println("-----------------------------------------------");
        System.out.println(" Total budget of U1: ");
        System.out.println("*  Total Budget of U1: $" + NumberFormat.getNumberInstance(Locale.US).format((u1Phase1Cost + u1Phase2Cost))+"    *");
    }

    public void btnu2(ActionEvent event){
        Simulation mission = new Simulation(); //Creating a new simulation object

        // U2 rockets phase 1

        System.out.println("Phase 1: U2 Rockets");
        System.out.println(" ");

        ArrayList<Item> u2Phase1 = mission.loadItems("phase-1.txt");
        ArrayList<Rocket> u2Rockets = mission.loadU1(u2Phase1);
        int u2Phase1Cost = mission.runSimulation(u2Rockets);
        System.out.println("*  Phase 1 with U2: $" + NumberFormat.getNumberInstance(Locale.US).format(u2Phase1Cost)+" *");

        // U2 rockets phase 2
        System.out.println("---------------");
        System.out.println("Phase 2: U2 Rockets");
        System.out.println(" ");
        ArrayList<Item> u2Phase2 = mission.loadItems("phase-2.txt");
        u2Rockets = mission.loadU1(u2Phase2);
        int u2Phase2Cost = mission.runSimulation(u2Rockets);
        System.out.println("*  Phase 2 with U2: $" + NumberFormat.getNumberInstance(Locale.US).format(u2Phase2Cost)+" *");
        System.out.println(" ");
        System.out.println("-----------------------------------------------");
        System.out.println(" Total budget of U2: ");
        System.out.println("*  Total Budget of U2: $" + NumberFormat.getNumberInstance(Locale.US).format((u2Phase1Cost + u2Phase2Cost))+"    *");
    }

    // U1 PHASE 2 AND U2 PHASE2
    public void btn3(ActionEvent event) {
        Simulation mission = new Simulation(); //Creating a new simulation object
        // U1 rockets phase 2

            System.out.println("Phase 2: U1 Rockets");
            System.out.println(" ");

        ArrayList<Item> u1Phase2 = mission.loadItems("phase-2.txt");
        ArrayList<Rocket> u1Rockets = mission.loadU1(u1Phase2);
        int u1Phase2Cost = mission.runSimulation(u1Rockets);
        System.out.println("*  Phase 2 with U1: $" + NumberFormat.getNumberInstance(Locale.US).format(u1Phase2Cost)+" *");
        System.out.println(" ");
        System.out.println("-----------------------------------------------");
        System.out.println(" Total budget of U1: ");

        // U2 rockets phase 2
        System.out.println("---------------");
        System.out.println("Phase 2: U2 Rockets");
        System.out.println(" ");
        ArrayList<Item> u2Phase2 = mission.loadItems("phase-2.txt");
        ArrayList<Rocket> u2Rockets = mission.loadU1(u2Phase2);
        int u2Phase2Cost = mission.runSimulation(u2Rockets);
        System.out.println("*  Phase 2 with U2: $" + NumberFormat.getNumberInstance(Locale.US).format(u2Phase2Cost)+" *");
        System.out.println(" ");
        System.out.println("-----------------------------------------------");
        System.out.println(" Total budget of U2: ");
        System.out.println("*  Total Budget of PHASE 2 : $" + NumberFormat.getNumberInstance(Locale.US).format((u1Phase2Cost + u2Phase2Cost))+"    *");


    }
    // U1 PHASE 1 AND U2 PHASE1
    public void btn4(ActionEvent event) {
        Simulation mission = new Simulation(); //Creating a new simulation object
        // U1 rockets phase 1

        System.out.println("Phase 1: U1 Rockets");
        System.out.println(" ");

        ArrayList<Item> u1Phase1 = mission.loadItems("phase-1.txt");
        ArrayList<Rocket> u1Rockets = mission.loadU1(u1Phase1);
        int u1Phase1Cost = mission.runSimulation(u1Rockets);
        System.out.println("*  Phase 1 with U1: $" + NumberFormat.getNumberInstance(Locale.US).format(u1Phase1Cost)+" *");
        System.out.println(" ");
        System.out.println("-----------------------------------------------");
        System.out.println(" Total budget of U1: ");

        // U2 rockets phase 1
        System.out.println("---------------");
        System.out.println("Phase 1: U2 Rockets");
        System.out.println(" ");
        ArrayList<Item> u2Phase1 = mission.loadItems("phase-1.txt");
        ArrayList<Rocket> u2Rockets = mission.loadU1(u2Phase1);
        int u2Phase1Cost = mission.runSimulation(u2Rockets);
        System.out.println("*  Phase 1 with U2: $" + NumberFormat.getNumberInstance(Locale.US).format(u2Phase1Cost)+" *");
        System.out.println(" ");
        System.out.println("-----------------------------------------------");
        System.out.println(" Total budget of U2: ");
        System.out.println("*  Total Budget of PHASE 1: $" + NumberFormat.getNumberInstance(Locale.US).format((u1Phase1Cost + u2Phase1Cost))+"    *");


    }
}
