package com.network.devices;

public enum ScreenSize {
    EDTV,
    HD,
    FULL_HD,
    UHD;

    public int getValue() {
        switch (this) {
            case EDTV:
                return -5;
            case HD:
                return -10;
            case FULL_HD:
                return -15;
            case UHD:
                return -20;
        }
        return 0;
    }
}
