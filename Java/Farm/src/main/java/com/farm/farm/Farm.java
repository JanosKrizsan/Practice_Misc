package com.farm.farm;

import com.farm.plants.AlmondTree;
import com.farm.plants.Juniper;
import com.farm.plants.Plant;
import com.farm.plants.Spruce;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private int productionOverall = 0;
    private int productionTotal;
    private int monthCount = 0;
    private List<Plant> plants = new ArrayList<>();
    private List<String> monthlyTotals = new ArrayList<>();

    public Farm (int months, int plantNumEach) {
        SimulateMonths(months, plantNumEach);
    }

    private void SimulateMonths(int months, int plantNumEach) {
        generateField(plantNumEach);

        while (monthCount != months) {
            monthCount++;
            boolean anyRotten = false;
            int total = 0;
            for(Plant plant : plants) {
                plant.produce();
                total += plant.getProduction();
                if (plantChecker(plant)) {
                    anyRotten = true;
                }
            }
            if (anyRotten) {
                productionTotal = 0;
            } else {
                productionTotal = total;
                productionOverall += total;
            }
            printResults();
        }
    }

    private void printResults() {
        String report = String.format("The month is at %d and our production is at %d units.", monthCount, productionTotal);
        monthlyTotals.add(report);
        System.out.println(report);
    }

    private void generateField(int plantNumEach) {
        for (int i = 0; i < plantNumEach ; i++) {
            plants.add(new Juniper());
            plants.add(new Spruce());
            plants.add(new AlmondTree());
        }
    }

    private boolean plantChecker(Plant plant) {
        if (plant.getName().equals("com.codecool.jani.plants.Spruce")) {
            Spruce spruce = (Spruce)plant;
            return spruce.isRotten();
        } else if (plant.getName().equals("com.codecool.jani.plants.AlmondTree")) {
            AlmondTree almondTree = (AlmondTree)plant;
            return almondTree.isRotten();
        } else {
            return false;
        }
    }

    public void printResultAtEndOfRun() {
        String totalOfTotals = String.format("The full amount produced overall is: %d fruits.", productionOverall);
        System.out.println("\n\n");
        System.out.println("== PLEASE FIND OUR REPORT FROM THE FARMS YE HA HOO HA ==");
        System.out.println("\n\n");
        for (String report : monthlyTotals) {
            System.out.println(report);
        }
        System.out.println("\n\n");
        System.out.println(totalOfTotals);
        System.out.println("\n\n");
        System.out.println("== END OF THE REPORT, FRIEND-O ==");
    }
}
