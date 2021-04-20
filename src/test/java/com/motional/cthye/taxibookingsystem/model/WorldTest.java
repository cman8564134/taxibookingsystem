package com.motional.cthye.taxibookingsystem.model;

import com.motional.cthye.taxibookingsystem.configuration.UnknownCarTypeException;
import com.motional.cthye.taxibookingsystem.util.VehicleFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorldTest {
    @InjectMocks
    private World world;
    private Vehicle driver1;
    private Vehicle driver2;
    private Vehicle driver3;
    @Mock
    private VehicleFactory vehicleFactory;

    @Before
    public void beforeMethod() throws UnknownCarTypeException {
        driver1 = new Car(1, 1, new Point());
        driver2 = new Car(2, 1, new Point());
        driver3 = new Car(3, 1, new Point());
        when(vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 1)).thenReturn(driver1);
        when(vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 2)).thenReturn(driver2);
        when(vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 3)).thenReturn(driver3);
        world.reset(vehicleFactory);
    }


    @Test
    public void testReset_InitialState_3Vehicles() {
        assertTrue("World should have only 3 vehicles in its initial state", world.getAllVehicles().size() == 3);
    }

    @Test
    public void testReset_InitialState_FailedWithException() throws UnknownCarTypeException {
        when(vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 3)).thenThrow(new UnknownCarTypeException("Incorrect Vehicle Type"));
        world.reset(vehicleFactory);
        assertTrue("World should have 0 vehicles because the getVehicle has failed with exception", world.getAllVehicles().size() == 0);
    }

    @Test
    public void testAddVehicleIntoTheWorld_CustomSportsVehicle_4Vehicles() throws UnknownCarTypeException {
        Vehicle vehicle = vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.SPORTS_CAR, 4);
        world.addVehicleIntoWorld(vehicle);
        assertTrue("World should have 4 vehicles after adding the new custom vehicle", world.getAllVehicles().size() == 4);
    }

    @Test
    public void testGetAvailableVehicles_BookedOneTaxi_2Vehicles() {
        Booking booking1 = new Booking(new Point(), new Point(), driver1);
        assertTrue("World should have 2 vehicles available after one vehicle is booked", world.getAvailableVehicles().size() == 2);
    }

    @Test
    public void testGetAvailableVehicles_BookedAllTaxi_0Vehicles() {
        Booking booking1 = new Booking(new Point(), new Point(), driver1);
        Booking booking2 = new Booking(new Point(), new Point(), driver2);
        Booking booking3 = new Booking(new Point(), new Point(), driver3);
        assertTrue("World should have no vehicles available after all 3 vehicle is booked", world.getAvailableVehicles().size() == 0);
    }

    @Test
    public void testGetNearestAvailableVehicleFromPoint_AllTaxiAvailableFromFactory_Vehicle1() {
        assertTrue("World should assign driver 1 with lowest ID and nearest travelling distance",
                world.getNearestAvailableVehicleFromPoint(new Point(1, 1)) == driver1);
    }

    @Test
    public void testGetNearestAvailableVehicleFromPoint_OneTaxiBookedFromFactory_Vehicle2() {
        Booking booking1 = new Booking(new Point(), new Point(), driver1);
        assertTrue("World should assign driver 2 with the next lowest ID and nearest travelling distance",
                world.getNearestAvailableVehicleFromPoint(new Point(1, 1)) == driver2);
    }

    @Test
    public void testGetNearestAvailableVehicleFromPoint_AllTaxiBooked_FailedWithNoAvailableDriver() {
        Booking booking1 = new Booking(new Point(), new Point(), driver1);
        Booking booking2 = new Booking(new Point(), new Point(), driver2);
        Booking booking3 = new Booking(new Point(), new Point(), driver3);
        assertTrue("World should not able to assign any taxi because it does not have any available driver",
                world.getNearestAvailableVehicleFromPoint(new Point(1, 1)) == null);
    }

    @Test
    public void testTick_OneTaxiBookedAndInProgress_Driver1WillNotBeAvailableFor2Ticks() {
        Booking booking1 = new Booking(new Point(0, 0), new Point(1, 1), driver1);
        world.tick();
        assertFalse("Driver 1 should booked and not be available", driver1.isAvailable());
    }

    @Test
    public void testTick_OneTaxiBookedFor2TimeUnit_TaxiWillBecomeAvailableAfter2Ticks() {
        Booking booking1 = new Booking(new Point(0, 0), new Point(1, 1), driver1);
        world.tick();
        world.tick();
        assertTrue("Driver 1 should be available after booking is completed", driver1.isAvailable());
    }

    @Test
    public void testTick_OneTaxiBookedFor2TimeUnitAndLatestLocationIsAtDestination_TaxiLocationWillBeAtPointOfLatestDestination() {
        Booking booking1 = new Booking(new Point(0, 0), new Point(1, 1), driver1);
        world.tick();
        world.tick();
        assertTrue("Driver 1 should be available after booking is completed", driver1.getCurrentPosition().equals(booking1.getEndingPoint()));
    }


}
