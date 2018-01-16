package com.develogical.camera;

public class Camera {

    private Sensor sensor;

    Camera (Sensor _sensor) {
        sensor = _sensor;
    }

    public void pressShutter() {
        // not implemented
    }

    public void powerOn() {
        sensor.powerUp();
    }

    public void powerOff() {
       // not implemented
    }
}

