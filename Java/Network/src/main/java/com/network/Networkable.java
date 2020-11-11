package com.network;

import com.network.devices.Device;

import java.util.List;

public interface Networkable {

    List<Device> connectedDevices();
}
