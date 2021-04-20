package com.motional.cthye.taxibookingsystem.integ.dto;

import com.motional.cthye.taxibookingsystem.model.Vehicle;

import javax.validation.constraints.NotNull;

/**
 * Response Data Transfer Object (DTO) for Taxi Booking API
 */
public class BookingResponseDTO {
    @NotNull
    int car_id;
    @NotNull
    int total_time;

    public BookingResponseDTO(@NotNull int car_ID, @NotNull int total_Time) {
        this.car_id = car_ID;
        this.total_time = total_Time;
    }

    public BookingResponseDTO() {
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getTotal_time() {
        return total_time;
    }

    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BookingResponseDTO){
            BookingResponseDTO responseDTO = (BookingResponseDTO) obj;
            return this.car_id == responseDTO.getCar_id() && this.total_time == responseDTO.getTotal_time();
        }
        return false;
    }
}
