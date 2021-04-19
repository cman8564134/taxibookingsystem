package com.motional.cthye.taxibookingsystem.util;

import com.motional.cthye.taxibookingsystem.configuration.UnknownCarTypeException;
import com.motional.cthye.taxibookingsystem.model.Car;
import com.motional.cthye.taxibookingsystem.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * Factory class to generate vehicles using concrete classes of vehicles
 */
public class VehicleFactory {
    public enum VEHICLE_TYPE {NORMAL_CAR, SPORTS_CAR, UNKNOWN_CAR_TYPE}

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleFactory.class);

    /**
     * Method to create different types of vehicles
     *
     * @param vehicleType Types of Vehicle based on selection in factory
     * @param ID          Unique ID of the vehicle
     * @return Concrete object of vehicle based on specified vehicle type
     */
    public Vehicle getVehicle(VEHICLE_TYPE vehicleType, int ID) throws UnknownCarTypeException {
        LOGGER.debug("Attempting to create vehicle:" + vehicleType.toString() + " with ID: " + ID);
        if (vehicleType == VEHICLE_TYPE.NORMAL_CAR) {
            //Simulating a car factory at (0,0) which creates car with speed 1
            return new Car(ID, 1, new Point());
        } else if (vehicleType == VEHICLE_TYPE.SPORTS_CAR) {
            //Simulating a sports car factory at (5,5) which creates sports car with speed 5 (may not be relevant to this case)
            return new Car(ID, 5, new Point(5, 5));
        } else {
            throw new UnknownCarTypeException("Incorrect Vehicle Type");
        }
    }
}
