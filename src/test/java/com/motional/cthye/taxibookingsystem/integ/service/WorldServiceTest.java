package com.motional.cthye.taxibookingsystem.integ.service;

import com.motional.cthye.taxibookingsystem.configuration.UnknownCarTypeException;
import com.motional.cthye.taxibookingsystem.model.Booking;
import com.motional.cthye.taxibookingsystem.model.Car;
import com.motional.cthye.taxibookingsystem.model.Vehicle;
import com.motional.cthye.taxibookingsystem.model.World;
import com.motional.cthye.taxibookingsystem.util.VehicleFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorldServiceTest {

    private WorldService worldService;
    @InjectMocks
    private World world;
    @Mock
    private VehicleFactory vehicleFactory;
    private Vehicle driver1;
    private Vehicle driver2;
    private Vehicle driver3;

    @Before
    public void beforeMethod() throws UnknownCarTypeException {
        driver1 = new Car(1, 1, new Point());
        driver2 = new Car(2, 1, new Point());
        driver3 = new Car(3, 1, new Point());
        when(vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 1)).thenReturn(driver1);
        when(vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 2)).thenReturn(driver2);
        when(vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 3)).thenReturn(driver3);
        worldService = new WorldService(world);
        world.reset(vehicleFactory);
    }

    @Test
    public void testReset_InitialState_InitialState() {
        Booking booking1 = new Booking(new Point(0, 0), new Point(1, 1), driver1);
        boolean beforeReset = world.getAvailableVehicles().size() == 2;
        worldService.reset();
        boolean afterReset = world.getAvailableVehicles().size() == 3;
        assertTrue("Method should performed world reset", beforeReset && afterReset);
    }

    @Test
    public void testTick_VehicleIsAvailableAfterBookingIsCompleted_AllVehicleAvailableForBooking() {
        Booking booking1 = new Booking(new Point(0, 0), new Point(1, 1), driver1);
        boolean beforeBookingCompleted = world.getAvailableVehicles().size() == 2;
        worldService.tick();
        worldService.tick();
        boolean afterBookingCompleted = world.getAvailableVehicles().size() == 3;
        assertTrue("Method should performed clock movement for world", beforeBookingCompleted && afterBookingCompleted);
    }

}
