package com.network.devices;

import com.network.Util;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Device {

    private int age = Util.setAge();
    private int batteryLife = Util.setAge();
    private int remainingPower = Util.setPower();
    private DeviceTypes devicetype;

    public abstract void calculateRemainingPower();
    public abstract void ageDevice();

    public int getAge() {
        return age;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public int getRemainingPower() {
        return remainingPower;
    }

    public void setDevicetype(DeviceTypes devicetype) {
        this.devicetype = devicetype;
    }

    public void changeRemainingPower(int change) {
        if (change > 0) {
            this.remainingPower += change;
        } else {
            this.remainingPower -= change;
        }
    }

    public DeviceTypes getDevicetype() {
        return devicetype;
    }

    public void changeAge(int age) {
        if(age > 0) {
            this.age += age;
        } else {
            this.age -= age;
        }
    }

    public void changeBatteryLife(int batteryLife) {
        if(batteryLife > 0) {
            this.batteryLife += batteryLife;
        } else {
            this.batteryLife -= batteryLife;
        }
    }

    public void setupDevice() {
        this.age = ThreadLocalRandom.current().nextInt(50, 300);
        this.batteryLife = ThreadLocalRandom.current().nextInt(10, 60);
    }

    public void changeBattery() {
        this.batteryLife = Util.setAge();
    }
}
