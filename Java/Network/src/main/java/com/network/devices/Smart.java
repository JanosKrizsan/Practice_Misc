package com.network.devices;

import com.network.Networkable;
import com.network.Util;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Smart extends Device {

    private ScreenSize screenSize;
    private String deviceName;
    private static int deviceNum;
    private Networkable network;

    public Smart(Networkable network) {
        this.network = network;
        this.setDevicetype(DeviceTypes.SMART);
        generateUniqueName();
        this.screenSize = Util.setScreen();
        setupDevice();
    }

    private void generateUniqueName() {
        deviceNum++;
        this.deviceName = getDevicetype().toString() + "/S_M_A_R_T/" + deviceNum;
    }

    public void getDifferingPoweredNormals(List<Device> devices, int powerDiffRange) {
        int count = 0;
        for (Device device : devices) {
            if (device.getDevicetype().equals(DeviceTypes.NORMAL)) {
                if (checkIfInRange(device.getRemainingPower(), powerDiffRange)) {
                    count++;
                    System.out.println(String.format("com.jani.network.devices.Device Type: %s, com.jani.network.devices.Device Age: %s, com.jani.network.devices.Device Power: %s"
                            , device.getDevicetype(), device.getAge(), device.getRemainingPower()));
                }
            }
        }
        System.out.println(String.format("Number of such devices is: %d , in range:   %d ", count, powerDiffRange));
    }

    @Override
    public void calculateRemainingPower() {
        changeRemainingPower(-15);
        changeRemainingPower(screenSize.getValue());
    }

    @Override
    public void ageDevice() {
        int range = ThreadLocalRandom.current().nextInt(50, 500);
        getDifferingPoweredNormals(network.connectedDevices(), range);
        calculateRemainingPower();
        changeAge(-1);
        changeBatteryLife(-1);
    }

    private boolean checkIfInRange(int targetNum, int range) {
        return targetNum > getRemainingPower() && targetNum < getRemainingPower() + range || targetNum < getRemainingPower() && targetNum > getRemainingPower() - range;
    }

    public ScreenSize getScreenSize() {
        return screenSize;
    }

    public String getDeviceName() {
        return deviceName;
    }

}
