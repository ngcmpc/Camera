package com.develogical.camera;

public class Camera {

    private boolean isOn;
    private Sensor sensor;
    private MemoryCard memoryCard;

    Camera(Sensor _sensor, MemoryCard _memoryCard) {
        isOn = false;
        sensor = _sensor;
        memoryCard = _memoryCard;
    }

    public void pressShutter() {
        if (!isOn) {
            return;
        }

        byte[] data = sensor.readData();
        memoryCard.write(data, null);
    }

    public void powerOn() {
        isOn = true;
        sensor.powerUp();
    }

    public void powerOff() {
        isOn = false;
        sensor.powerDown();
    }
}

