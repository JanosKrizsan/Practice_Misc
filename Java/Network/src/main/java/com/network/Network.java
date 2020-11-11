package com.network;

import com.network.devices.Connected;
import com.network.devices.Device;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network implements Networkable{

    private List<Device> connectedDevices = new ArrayList<>();

    public Network() {

    }

    public List<Device> getConnectedDevices() {
        return Collections.unmodifiableList(connectedDevices);
    }

    public void connectDevice(Device device) {
        connectedDevices.add(device);
        if (device instanceof Connected) {
            Connected connected = (Connected)device;
            connected.registerNetworkable(this::getConnectedDevices);
        }
    }

    public void disconnectDevice(Device device) {
        connectedDevices.remove(device);
    }

    public void connectDevices(List<Device> devices) {
        devices.forEach(this::connectDevice);
    }

    public void disconnectAll() {
        this.connectedDevices = new ArrayList<>();
    }

    @Override
    public List<Device> connectedDevices() {
        return getConnectedDevices();
    }
}
