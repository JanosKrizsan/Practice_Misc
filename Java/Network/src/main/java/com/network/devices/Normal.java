package com.network.devices;

import com.network.Util;

public class Normal extends Device {

    private ScreenSize screenSize;
    private final int manufactureDate = Util.assignManufactureYear();

    public Normal() {
        this.setDevicetype(DeviceTypes.NORMAL);
        this.screenSize = Util.setScreen();
        setupDevice();
    }

    @Override
    public void calculateRemainingPower() {
        changeRemainingPower(-3);
        if (getManufactureDate() < 2000) {
            changeRemainingPower(-getRemainingPower());
        } else {
            changeRemainingPower(getRemainingPower());
        }
    }

    @Override
    public void ageDevice() {
        System.out.println(String.format("ManufactureDate: %d", getManufactureDate()));
        calculateRemainingPower();
        changeAge(-1);
        changeBatteryLife(-1);
    }

    public int getManufactureDate() {
        return manufactureDate;
    }
}
