package com.motional.cthye.taxibookingsystem.model;

import com.motional.cthye.taxibookingsystem.configuration.UnknownCarTypeException;
import com.motional.cthye.taxibookingsystem.util.VehicleFactory;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private Booking booking;
    private VehicleFactory vehicleFactory;
    private Point startingPoint;
    private Point endingPoint;
    private Car car;

    @Before
    public void beforeMethod() throws UnknownCarTypeException {
        vehicleFactory = new VehicleFactory();
        startingPoint = new Point(0, 0);
        endingPoint = new Point(5, 5);
        car = (Car) vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, Integer.MIN_VALUE);
        booking = new Booking(startingPoint, endingPoint, car);
    }

    @Test
    public void testCalculateTotalTime_InitialState_SumOfTravellingDistanceBetweenCustomerAndCarWithSourceAndDestination() {
        assertEquals("Method should return the total travelling distance between customer to driver and source to destination",
                10, booking.getTotalTime());
    }

    @Test
    public void testGetStartingPoint_InitialState_StartingPoint() {
        assertEquals("Method should return the starting point of the booking",
                startingPoint, booking.getStartingPoint());
    }

    @Test
    public void testSetStartingPoint_ChangedInitialState_SpecifiedPoint() {
        booking.setStartingPoint(new Point(3, 3));
        assertEquals("Method should return the specified starting point ",
                new Point(3, 3), booking.getStartingPoint());
    }

    @Test
    public void testGetEndingPoint_InitialState_EndingPoint() {
        assertEquals("Method should return the ending point of the booking",
                endingPoint, booking.getEndingPoint());
    }

    @Test
    public void testSetEndingPoint_ChangedInitialState_SpecifiedPoint() {
        booking.setEndingPoint(new Point(3, 3));
        assertEquals("Method should return the specified starting point ",
                new Point(3, 3), booking.getEndingPoint());
    }

    @Test
    public void testGetDriver_InitialState_Driver() {
        assertEquals("Method should return the initial driver of the booking",
                car, booking.getDriver());
    }

    @Test
    public void testSetDriver_ChangedInitialState_SportsCarDriver() throws UnknownCarTypeException {
        Vehicle vehicle = vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.SPORTS_CAR, 10);
        booking.setDriver(vehicle);
        assertEquals("Method should return the specified driver",
                vehicle, booking.getDriver());
    }

    @Test
    public void testSetTotalTime_ChangedInitialState_SpecifiedTime() {
        booking.setTotalTime(10);
        assertEquals("Method should return the specified driver",
                10, booking.getTotalTime());
    }


}
