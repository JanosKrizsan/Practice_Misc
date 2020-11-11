package com.network.devices;

import com.network.Networkable;

public class Connected extends Device {

    private static int deviceCount = 0;
    private Networkable networkable;  // starts out as null


    public Connected() {
        deviceCount++;
        setupDevice();
        this.setDevicetype(DeviceTypes.CONNECTED);
    }

    public static int getDeviceCount() {
        return deviceCount;
    }

    @Override
    public void calculateRemainingPower() {
        changeRemainingPower(getDeviceCount() * 20);
        changeRemainingPower(-7);
    }

    @Override
    public void ageDevice() {
        String.format("Number of Total com.jani.network.devices.Connected devices: %d", getDeviceCount());
        calculateRemainingPower();
        changeAge(-1);
        changeBatteryLife(-1);
    }

    public void registerNetworkable(Networkable networkable) {
        this.networkable = networkable;
    }
}
