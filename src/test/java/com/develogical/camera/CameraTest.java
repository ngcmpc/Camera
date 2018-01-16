package com.develogical.camera;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class CameraTest {
    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {
        Sensor sensor = mock(Sensor.class);
        Camera camera = new Camera(sensor);

        camera.powerOn();
        verify(sensor).powerUp();
    }

    @Test
    public void switchingTheCameraOffPowersDownTheSensor() {
        Sensor sensor = mock(Sensor.class);
        Camera camera = new Camera(sensor);

        camera.powerOff();
        verify(sensor).powerDown();
    }

    @Test
    public void pressingTheShutterWhenThePowerIsOffDoesNothing() {
        Sensor sensor = mock(Sensor.class);
        Camera camera = new Camera(sensor);

        camera.powerOff();
        verify(sensor).powerDown();
        camera.pressShutter();
        verifyNoMoreInteractions(sensor);
    }
}
