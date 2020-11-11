package com.farm.plants;

import java.util.concurrent.ThreadLocalRandom;

public class AlmondTree extends Plant implements RotShroomable {
    private boolean rotten = false;

    public AlmondTree() {
        setProduction(50);
        setName("com.codecool.jani.plants.AlmondTree");
    }

    public void rot() {
        rotten = chanceCounter(13, -18);
    }

    public void shroom() {
        chanceCounter(8, 10);
    }

    private void doubleProduction() {
        if (getProduction() < 40) {
            setProduction(getProduction() * 2);
        }
    }

    public void produce() {
        updateProd(getDefaultGrowth());
        doubleProduction();
        shroom();
        rot();
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
