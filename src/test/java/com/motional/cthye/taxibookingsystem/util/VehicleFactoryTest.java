package com.motional.cthye.taxibookingsystem.util;

import com.motional.cthye.taxibookingsystem.configuration.UnknownCarTypeException;
import com.motional.cthye.taxibookingsystem.model.Vehicle;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class VehicleFactoryTest {

    private VehicleFactory factory;

    @Before
    public void beforeMethod() {
        factory = new VehicleFactory();
    }

    @Test
    public void testGetVehicle_NormalCarWithID_NormalCar() throws UnknownCarTypeException {
        Vehicle vehicle = factory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, Integer.MIN_VALUE);
        boolean conditionsForNewNormalCarVehicle =
                (vehicle.getSpeed() == 1) && (vehicle.getCurrentPosition().equals(new Point(0, 0))) &&
                        (vehicle.getID() == Integer.MIN_VALUE) && (vehicle.getDestinationList().isEmpty()) && (vehicle.isAvailable());
        assertTrue("Method should return vehicle that fulfills all conditions of a normal car upon creation", conditionsForNewNormalCarVehicle);
    }

    @Test
    public void testGetVehicle_SportsCarWithID_SportsCar() throws UnknownCarTypeException {
        Vehicle vehicle = factory.getVehicle(VehicleFactory.VEHICLE_TYPE.SPORTS_CAR, Integer.MIN_VALUE);
        boolean conditionsForNewSportsCarVehicle =
                (vehicle.getSpeed() == 5) && (vehicle.getCurrentPosition().equals(new Point(5, 5))) &&
                        (vehicle.getID() == Integer.MIN_VALUE) && (vehicle.getDestinationList().isEmpty()) && (vehicle.isAvailable());
        assertTrue("Method should return vehicle that fulfills all conditions of a sports car upon creation", conditionsForNewSportsCarVehicle);
    }

    @Test
    public void testGetVehicle_UnknownCarWithID_FailWithException() {
        Exception exception = assertThrows(UnknownCarTypeException.class, () -> {
            factory.getVehicle(VehicleFactory.VEHICLE_TYPE.UNKNOWN_CAR_TYPE, Integer.MIN_VALUE);
        });
        assertEquals("Method should throw exception when invalid vehicle type is passed", "Incorrect Vehicle Type", exception.getMessage());
    }
}
