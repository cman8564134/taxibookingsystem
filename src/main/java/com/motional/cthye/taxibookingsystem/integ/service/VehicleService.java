package com.motional.cthye.taxibookingsystem.integ.service;

import com.motional.cthye.taxibookingsystem.integ.dto.BookingRequestDTO;
import com.motional.cthye.taxibookingsystem.integ.dto.BookingResponseDTO;
import com.motional.cthye.taxibookingsystem.model.Booking;
import com.motional.cthye.taxibookingsystem.model.Vehicle;
import com.motional.cthye.taxibookingsystem.model.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for Vehicle related functions
 */
@Service
public class VehicleService {

    private final World world;
    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleService.class);

    @Autowired
    public VehicleService(World world) {
        this.world = world;
    }

    /**
     * Book a ride if possible
     *
     * @param requestDTO The request DTO from API client
     * @return The response DTO which contains the booking information if successfully booked
     */
    public BookingResponseDTO bookARide(BookingRequestDTO requestDTO) {
        LOGGER.debug("Attempting to book a ride from " + requestDTO.getSource().toString() + " to " + requestDTO.getDestination().toString());
        Vehicle vehicle = world.getNearestAvailableVehicleFromPoint(requestDTO.getSource());
        BookingResponseDTO bookingResponseDTO = null;
        if (vehicle != null) {
            Booking booking = new Booking(requestDTO.getSource(), requestDTO.getDestination(), vehicle);
            bookingResponseDTO = new BookingResponseDTO(booking.getDriver().getID(), booking.getTotalTime());
        }
        return bookingResponseDTO;
    }

}
