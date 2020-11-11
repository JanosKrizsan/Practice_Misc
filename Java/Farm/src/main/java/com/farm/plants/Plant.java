package com.farm.plants;

public abstract class Plant {

    private int production = 0;
    private static final int defaultGrowth = 4;
    private String name;

    public int getProduction() {
        return production;
    }

    public void updateProd(int value) {
        if (value < 0) {
            this.production -= value;
        } else {
            this.production += value;
        }
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public abstract void produce();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getDefaultGrowth() {
        return defaultGrowth;
    }
}
