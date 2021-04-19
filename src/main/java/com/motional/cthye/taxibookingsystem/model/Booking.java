package com.motional.cthye.taxibookingsystem.model;

import com.motional.cthye.taxibookingsystem.util.DistanceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * Concrete class to contain booking information
 */
public class Booking {
    private Point StartingPoint;
    private Point EndingPoint;
    private Vehicle Driver;
    private int totalTime;
    private static final Logger LOGGER = LoggerFactory.getLogger(Booking.class);

    public Booking(Point startingPoint, Point endingPoint, Vehicle driver) {
        this.StartingPoint = startingPoint;
        this.EndingPoint = endingPoint;
        this.Driver = driver;
        this.totalTime = calculateTotalTime();

        //once booking is created, we add the destinations to the driver
        this.Driver.addToDestinationList(startingPoint);
        this.Driver.addToDestinationList(endingPoint);
    }

    public Point getStartingPoint() {
        return StartingPoint;
    }

    public void setStartingPoint(Point startingPoint) {
        StartingPoint = startingPoint;
    }

    public Point getEndingPoint() {
        return EndingPoint;
    }

    public void setEndingPoint(Point endingPoint) {
        EndingPoint = endingPoint;
    }

    public Vehicle getDriver() {
        return Driver;
    }

    public void setDriver(Vehicle driver) {
        Driver = driver;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    /**
     * Calculates the total time needed for driver vehicle to complete the booking.
     *
     * @return total time needed for driver vehicle to complete the booking
     */
    private int calculateTotalTime() {
        LOGGER.debug("Calculating the total time for this booking");
        //distance from driver to customer location
        int distance1 = DistanceUtil.getTravellingDistanceBetweenTwoPoints(this.Driver.getCurrentPosition(), this.StartingPoint);
        //distance from customer location to destination
        int distance2 = DistanceUtil.getTravellingDistanceBetweenTwoPoints(this.StartingPoint, this.EndingPoint);
        return distance1 + distance2;
    }
}
