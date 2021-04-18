package com.motional.cthye.taxibookingsystem.integ.dto;

import javax.validation.constraints.NotNull;
import java.awt.*;

/**
 * Request Data Transfer Object (DTO) for Taxi Booking API
 */
public class BookingRequestDTO {

    @NotNull
    Point source;
    @NotNull
    Point destination;

    public BookingRequestDTO(@NotNull Point source, @NotNull Point destination) {
        this.source = source;
        this.destination = destination;
    }

    public BookingRequestDTO() {
    }

    public Point getSource() {
        return source;
    }

    public void setSource(Point source) {
        this.source = source;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }
}
