package com.motional.cthye.taxibookingsystem.model;

import com.motional.cthye.taxibookingsystem.configuration.UnknownCarTypeException;
import com.motional.cthye.taxibookingsystem.util.DistanceUtil;
import com.motional.cthye.taxibookingsystem.util.VehicleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A single World that has many unique vehicles
 */
public class World {
    //there will always be only one world
    private static World World;
    //In this world, there are many unique vehicles
    private HashSet<Vehicle> Vehicles = new HashSet<>();
    //to manufacture vehicles we have factories around the world
    private VehicleFactory vehicleFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(World.class);

    private World() {
    }

    /**
     * Singleton pattern to ensure there will only be one world in the whole application
     *
     * @return the world object
     */
    public static World getInstance() {
        if (World == null) {
            World = new World();
        }
        return World;
    }

    /**
     * Adds the vehicle into this world
     *
     * @param vehicle vehicle to add to this world
     */
    public void addVehicleIntoWorld(Vehicle vehicle) {
        this.Vehicles.add(vehicle);
    }

    /**
     * Retrieves the nearest vehicle in this world from specific point, if exist any.
     *
     * @param point Specific point in the world
     * @return Nearest vehicle from the point, if any.
     */
    public Vehicle getNearestAvailableVehicleFromPoint(Point point) {
        LOGGER.debug("Attempting to get nearest available vehicle from point:" + point.toString());
        List<Vehicle> availableVehicles = getAvailableVehicles();
        Vehicle nearestVehicle = null;
        if (availableVehicles.size() > 0) {
            double nearestDistance = Double.MAX_VALUE;
            for (Vehicle vehicle : availableVehicles) {
                double currentDistance = DistanceUtil.getDistanceBetweenTwoPoints(point, vehicle.getCurrentPosition());
                if (currentDistance < nearestDistance || (currentDistance == nearestDistance && (nearestVehicle == null || vehicle.getID() < nearestVehicle.getID()))) {
                    nearestVehicle = vehicle;
                    nearestDistance = currentDistance;
                }
            }
        }
        return nearestVehicle;
    }

    /**
     * Retrieves all available driver vehicles in this world that are not booked
     *
     * @return A list of available driver vehicles
     */
    public List<Vehicle> getAvailableVehicles() {
        LOGGER.debug("Retrieving all available vehicle");
        return this.Vehicles.stream().distinct().filter(Vehicle::isAvailable).collect(Collectors.toList());
    }

    /**
     * Retrieves all driver vehicles in this world regardless of availability
     *
     * @return A set of all driver vehicles in this world
     */
    public HashSet<Vehicle> getAllVehicles() {
        LOGGER.debug("Retrieving all vehicle regardless of availability");
        return this.Vehicles;
    }

    /**
     * Moves this world's clock by one time unit
     */
    public void tick() {
        LOGGER.debug("Moving this world's clock by one time unit");
        for (Movable vehicle : Vehicles) {
            vehicle.move();
        }
    }

    /**
     * Reset this world into its initial state
     */
    public void reset() {
        LOGGER.debug("Resetting this world to its initial state");
        this.Vehicles = new HashSet<>();
        this.vehicleFactory = (vehicleFactory == null) ? new VehicleFactory() : vehicleFactory;
        try {
            Vehicle vehicle1 = this.vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 1);
            Vehicle vehicle2 = this.vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 2);
            Vehicle vehicle3 = this.vehicleFactory.getVehicle(VehicleFactory.VEHICLE_TYPE.NORMAL_CAR, 3);
            addVehicleIntoWorld(vehicle1);
            addVehicleIntoWorld(vehicle2);
            addVehicleIntoWorld(vehicle3);
        } catch (UnknownCarTypeException e) {
            LOGGER.error("Unknown car type was passed to the vehicle factory");
        }
    }


}
