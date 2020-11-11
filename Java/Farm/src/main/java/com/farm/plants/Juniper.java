package com.farm.plants;

public class Juniper extends Plant implements Leafable{
    private int countMonths = 0;

    public Juniper() {
        setProduction(14);
        setName("Juniper");
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

    public void produce() {
        updateProd(getDefaultGrowth());
        growLeaves();
        maxProductionReached();
        countMonths++;
    }
}
