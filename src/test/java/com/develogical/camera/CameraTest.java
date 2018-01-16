package com.develogical.camera;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class CameraTest {
    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {

        Sensor sen = mock(Sensor.class);
        Camera cam = new Camera(sen);

        cam.powerOn();
        verify(sen).powerUp();
    }
}
