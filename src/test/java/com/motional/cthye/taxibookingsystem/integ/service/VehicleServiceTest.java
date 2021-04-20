package com.motional.cthye.taxibookingsystem.integ.service;

import com.motional.cthye.taxibookingsystem.integ.dto.BookingRequestDTO;
import com.motional.cthye.taxibookingsystem.integ.dto.BookingResponseDTO;
import com.motional.cthye.taxibookingsystem.model.Car;
import com.motional.cthye.taxibookingsystem.model.Vehicle;
import com.motional.cthye.taxibookingsystem.model.World;
import com.motional.cthye.taxibookingsystem.util.VehicleFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {

    private VehicleService vehicleService;
    BookingRequestDTO requestDTO;
    BookingResponseDTO responseDTO;
    @Mock
    private World world;
    @Mock
    private VehicleFactory vehicleFactory;

    @Before
    public void beforeMethod() {
        Vehicle driver1 = new Car(0, 0, new Point());
        vehicleService = new VehicleService(world);
        world.reset(vehicleFactory);
        when(world.getNearestAvailableVehicleFromPoint(any(Point.class))).thenReturn(driver1);
        responseDTO = new BookingResponseDTO(driver1.getID(), 2);
        requestDTO = new BookingRequestDTO(new Point(0, 0), new Point(1, 1));
    }

    @Test
    public void testBookARide_OnlyDriver1AvailableAsMocked_AsSpecified() {
        BookingResponseDTO responseDTO = vehicleService.bookARide(requestDTO);
        assertEquals("Method should return the correct driver according to assignment strategy", this.responseDTO, responseDTO);
    }
}
