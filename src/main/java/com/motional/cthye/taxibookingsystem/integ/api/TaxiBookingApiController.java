package com.motional.cthye.taxibookingsystem.integ.api;

import com.motional.cthye.taxibookingsystem.integ.dto.BookingRequestDTO;
import com.motional.cthye.taxibookingsystem.integ.dto.BookingResponseDTO;
import com.motional.cthye.taxibookingsystem.integ.service.VehicleService;
import com.motional.cthye.taxibookingsystem.integ.service.WorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TaxiBookingApiController {
    private final VehicleService vehicleService;
    private final WorldService worldService;
    //Ideally we would use a logger with traceability ID to trace the issue end to end
    private static final Logger LOGGER = LoggerFactory.getLogger(TaxiBookingApiController.class);

    @Autowired
    public TaxiBookingApiController(VehicleService vehicleService, WorldService worldService) {
        super();
        this.vehicleService = vehicleService;
        this.worldService = worldService;
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponseDTO book(@RequestBody @Valid BookingRequestDTO requestDTO) {
        LOGGER.debug("Received request to book a taxi");
        return vehicleService.bookARide(requestDTO);
    }

    @PostMapping("/tick")
    @ResponseStatus(HttpStatus.OK)
    public void tick() {
        LOGGER.debug("Received request to tick world clock");
        worldService.tick();
    }

    @PutMapping("/reset")
    @ResponseStatus(HttpStatus.OK)
    public void reset() {
        LOGGER.debug("Received request to reset the world");
        worldService.reset();
    }


}
