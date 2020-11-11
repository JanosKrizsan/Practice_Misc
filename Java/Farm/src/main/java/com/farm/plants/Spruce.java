package com.farm.plants;

import java.util.concurrent.ThreadLocalRandom;

public class Spruce extends Plant implements Leafable, RotShroomable{
    private int countMonths = 0;
    private boolean rotten = false;

    public Spruce() {
        setProduction(26);
        setName("Spruce");
    }

    public void growLeaves() {
        if(countMonths % 5 == 0) {
            updateProd(8);
        }
    }

    public void maxProductionReached() {
        if (getProduction() >= 70) {
            setProduction(70);
            System.out.println(String.format("%s at full production!", getName()));
        }
    }

    public void rot() {
        rotten = chanceCounter(4, 20);
    }

    public void shroom() {
        chanceCounter(5, 15);
    }

    public void produce() {
        updateProd(getDefaultGrowth());
        shroom();
        rot();
        maxProductionReached();
        countMonths++;
    }

    private boolean chanceCounter(int percent, int updateVal) {
        boolean chance = ThreadLocalRandom.current().nextInt(1, 100) < percent;
        if (chance) {
            updateProd(updateVal);
            return true;
        } else {
            return false;
        }
    }

    public boolean isRotten() {
        return rotten;
    }
}
