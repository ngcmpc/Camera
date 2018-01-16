package com.develogical.camera;

public class Camera {

    private boolean isOn;
    private boolean isWriting;
    private Sensor sensor;
    private MemoryCard memoryCard;
    private WriteCompleteListener listener;

    Camera(Sensor _sensor, MemoryCard _memoryCard) {
        isOn = false;
        isWriting = false;
        sensor = _sensor;
        memoryCard = _memoryCard;
    }

    public void pressShutter() {
        if (!isOn) {
            return;
        }

        isWriting = true;
        byte[] data = sensor.readData();
        memoryCard.write(data, listener);
    }

    public void powerOn() {
        isOn = true;
        isWriting = false;
        sensor.powerUp();
    }

    public void powerOff() {
        if (isWriting) {
            return;
        }

        isOn = false;
        sensor.powerDown();
    }
}

