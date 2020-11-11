package com.network;

import com.network.devices.ScreenSize;

import java.util.concurrent.ThreadLocalRandom;

public final class Util {

    public static ScreenSize setScreen() {
        int num = ThreadLocalRandom.current().nextInt(1, 4);
        switch(num) {
            case 1:
                return ScreenSize.EDTV;
            case 2:
                return ScreenSize.HD;
            case 3:
                return ScreenSize.FULL_HD;
            case 4:
                return ScreenSize.UHD;
        }
        return ScreenSize.HD;
    }

    public static int setPower() {
        return ThreadLocalRandom.current().nextInt(500, 5000);
    }

    public static int setAge() {
        return ThreadLocalRandom.current().nextInt(20, 200);
    }

    public static int assignManufactureYear() {
        return ThreadLocalRandom.current().nextInt(1950, 2050);
    }

}
