package com.develogical.camera;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CameraTest {

    private Camera camera;
    private Sensor sensor;
    private MemoryCard memoryCard;

    @Before
    public void prepareCamera() {
        sensor = mock(Sensor.class);
        memoryCard = mock(MemoryCard.class);
        camera = new Camera(sensor, memoryCard);
    }

    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {
        camera.powerOn();
        verify(sensor).powerUp();
    }

    @Test
    public void switchingTheCameraOffPowersDownTheSensor() {
        camera.powerOff();
        verify(sensor).powerDown();
    }

    @Test
    public void pressingTheShutterWhenThePowerIsOffDoesNothing() {
        camera.powerOff();
        verify(sensor).powerDown();
        camera.pressShutter();
        verifyNoMoreInteractions(sensor);
    }

    @Test
    public void pressingTheShutterWhenThePowerIsOnCopiesDataFromSensor() {
        camera.powerOn();
        verify(sensor).powerUp();

        byte[] data = "1234567890".getBytes();
        when(sensor.readData()).thenReturn(data);

        camera.pressShutter();

        verify(memoryCard).write(eq(data), any() );
    }


}
