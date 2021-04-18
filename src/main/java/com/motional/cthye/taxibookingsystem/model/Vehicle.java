package com.motional.cthye.taxibookingsystem.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.LinkedList;

/**
 * Abstract parent class for all vehicle that can exist in the world
 */
public abstract class Vehicle implements Movable {
    private Point currentPosition;
    private final LinkedList<Point> Destinations = new LinkedList<>();
    private int ID;
    private int Speed;
    private boolean Available = true;
    private static final Logger LOGGER = LoggerFactory.getLogger(Vehicle.class);

    /**
     * to ensure that all vehicles have required information during instantiation
     */
    private Vehicle() {
    }

    public Vehicle(int ID, int speed, Point pos) {
        this.ID = ID;
        this.Speed = speed;
        this.currentPosition = pos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public LinkedList<Point> getDestinationList() {
        return this.Destinations;
    }

    public void addToDestinationList(Point point) {
        LOGGER.debug("Adding to destination list for point: " + point.toString());
        this.Destinations.add(point);
        setAvailable(false);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            return this.ID == ((Vehicle) obj).ID;
        }
        return false;
    }

    /**
     * Updates the availability of the driver vehicle
     */
    protected void updateAvailability() {
        LOGGER.debug("Attempting to update the driver vehicle's availability");
        if (this.currentPosition.equals(this.Destinations.peek())) {
            Destinations.removeFirst();
            if (Destinations.isEmpty()) {
                setAvailable(true);
            }
        }
    }
}
