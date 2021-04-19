package com.motional.cthye.taxibookingsystem.model;

import com.motional.cthye.taxibookingsystem.configuration.UnknownCarTypeException;
import com.motional.cthye.taxibookingsystem.util.VehicleFactory;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {
    private Car car;
    private VehicleFactory vehicleFactory;

    @Before
    public void beforeMethod() throws UnknownCarTypeException {
        vehicleFactory = new VehicleFactory();
        car = (Car) vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, Integer.MIN_VALUE);
    }

    @Test
    public void testGetID_NewlyCreatedCarVehicle_AsSpecified() {
        assertEquals("Method should return specified ID during creation via factory", Integer.MIN_VALUE, car.getID());
    }

    @Test
    public void testSetID_ChangeInitialID_AsSpecified() {
        car.setID(1);
        assertEquals("Method should return specific modified ID", 1, car.getID());
    }

    @Test
    public void testGetSpeed_NormalCarInitiateState_AsSpecifiedInInitialState() {
        assertEquals("Method should return specified speed during creation via factory", 1, car.getSpeed());
    }

    @Test
    public void testSetSpeed_ChangeInitiateStateSpeed_AsSpecified() {
        car.setSpeed(3);
        assertEquals("Method should return specified modified speed", 3, car.getSpeed());
    }

    @Test
    public void testIsAvailable_InitiateState_True() {
        assertTrue("Method should return available upon creation via factory", car.isAvailable());
    }

    @Test
    public void testIsAvailable_BookedCar_False() {
        Booking booking1 = new Booking(new Point(), new Point(), car);
        assertFalse("Method should return not available upon booking", car.isAvailable());
    }

    @Test
    public void testSetAvailable_ChangeInitialState_False() {
        car.setAvailable(false);
        assertFalse("Method should return not available after setting it to false", car.isAvailable());
    }

    @Test
    public void testGetCurrentPosition_InitialState_PointByFactory() {
        assertEquals("Method should return position as defined in factory", new Point(0, 0), car.getCurrentPosition());
    }

    @Test
    public void testSetCurrentPosition_ChangeInitialState_AsSpecified() {
        Point newPoint = new Point(5, 5);
        car.setCurrentPosition(newPoint);
        assertEquals("Method should return position as specified", newPoint, car.getCurrentPosition());
    }

    @Test
    public void testGetDestinationList_InitialState_Empty() {
        assertTrue("Method should return empty destination list", car.getDestinationList().isEmpty());
    }

    @Test
    public void testGetDestinationList_addedADestination_SpecifiedDestinationAtTop() {
        Point newPoint = new Point(5, 5);
        car.addToDestinationList(newPoint);
        assertEquals("Method should not be available upon booking", newPoint, car.getDestinationList().removeFirst());
    }

    @Test
    public void testEquals_SameIDVehicle_True() throws UnknownCarTypeException {
        Car car2 = (Car) vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, Integer.MIN_VALUE);
        assertEquals("Method should return true for vehicles with same ID", car2, car);
    }

    @Test
    public void testEquals_DifferentIDVehicle_False() throws UnknownCarTypeException {
        Car car2 = (Car) vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, Integer.MAX_VALUE);
        assertFalse("Method should return true for vehicles with same ID", car2.equals(car));
    }

    @Test
    public void testMove_BookedVehicleTowardsDestinationAndInitiateMovementOnce_VehicleCoordinateChangesTowardsDestination() {
        Booking booking1 = new Booking(new Point(0, 0), new Point(5, 5), car);
        car.move();
        assertEquals("Method should move the vehicle according to strategy by one time unit", new Point(1, 0), car.getCurrentPosition());
    }

    @Test
    public void testUpdateAvailability_BookedVehicleCompletedBooking_AvailabilityBecomesTrue() {
        Booking booking1 = new Booking(new Point(0, 0), new Point(1, 1), car);
        car.move();
        car.move();
        assertTrue("Method should change the vehicle availability after booking is completed", car.isAvailable());
    }

}
