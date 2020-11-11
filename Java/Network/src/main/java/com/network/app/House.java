package com.network.app;

import com.network.Network;
import com.network.devices.Connected;
import com.network.devices.Device;
import com.network.devices.Normal;
import com.network.devices.Smart;

import java.util.ArrayList;
import java.util.List;

public class House {

    private static List<Device> devices = new ArrayList<>();

    public static void main(String[] args) {

        House house =new House();

        Network wifi5G = new Network();

        house.purchaseDevices(8, wifi5G);

        wifi5G.connectDevices(house.devices);

        ageDevices(100);
    }

    public void purchaseDevices(int perTypePurchase, Network network) {
        for (int i = 0; i < perTypePurchase; i++) {
            devices.add(new Connected());
            devices.add(new Normal());
            devices.add(new Smart(network));
        }
    }

    public static void ageDevices(int ageing) {
        int ageCounter = 0;
        while (ageCounter < ageing) {
            ageCounter++;
            List<Device> toBeThrown = new ArrayList<>();
            for (Device device : devices) {
                device.ageDevice();
                if (device.getRemainingPower() <= 0) {
                    device.changeBattery();
                }
                if (device.getAge() <= 0 || device.getBatteryLife() <= 0) {
                    toBeThrown.add(device);
                }
            }
            for (Device device : toBeThrown) {
                devices.remove(device);
            }
        }
        printResults();
    }

    public static void printResults() {
        System.out.println("These are your current devices: ");
        System.out.println("=====================");
        for (Device device : devices) {
            System.out.println(String.format("Age: %d, Battery Life: %d, Remaining Power: %d, com.jani.network.devices.Device Type: %s "
                    , device.getAge(), device.getBatteryLife(), device.getRemainingPower(), device.getDevicetype()));
        }
        System.out.println("=====================");
        System.out.println("====END=OF=REPORT====");
    }

}


