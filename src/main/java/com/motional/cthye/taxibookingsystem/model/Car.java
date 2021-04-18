package com.motional.cthye.taxibookingsystem.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * A concrete implementation of Vehicle that simulates a road based machine that travels according to the axis.
 */
public class Car extends Vehicle {
    private static final Logger LOGGER = LoggerFactory.getLogger(Car.class);

    public Car(int ID, int speed, Point point) {
        super(ID, speed, point);
    }

    /**
     * Car's implementation of movement based on its speed.
     */
    @Override
    public void move() {
        LOGGER.debug("Moving the car");
        travelToNextDestinationWithNoOfStep(getSpeed());
    }

    /**
     * The strategy of movement for car starts by travelling the X axis and then the Y axis towards its destination.
     *
     * @param totalNoOfSteps The number of step (or remaining step) this vehicle can perform in one time unit towards its destination(s).
     */
    private void travelToNextDestinationWithNoOfStep(int totalNoOfSteps) {
        LOGGER.debug("Travelling according to movement strategy with step count: " + totalNoOfSteps);
        Point currentDestination = getDestinationList().peek();
        if (currentDestination != null) {
            int XAxisDistanceWithDirection = (currentDestination.x - getCurrentPosition().x);
            int remainingSteps = totalNoOfSteps - Math.abs(XAxisDistanceWithDirection);
            int YAxisDistanceWithDirection = (currentDestination.y - getCurrentPosition().y);

            // case 3&4: if the totalNoOfSteps is above the travelling distance to destination
            if (remainingSteps > Math.abs(YAxisDistanceWithDirection)) {
                // We make the vehicle reach its destination and attempt to update status
                setCurrentPosition(new Point(currentDestination.x, currentDestination.y));
                updateAvailability();
                // if there are still remaining destination in the list we recurse back to top of function
                // until there is no remaining steps or no remaining destination
                if (!isAvailable()) {
                    travelToNextDestinationWithNoOfStep(remainingSteps - Math.abs(YAxisDistanceWithDirection));
                }
            }
            // case 2: totalNoOfSteps above distance to destination for X axis but within distance for Y axis
            else if (totalNoOfSteps > Math.abs(XAxisDistanceWithDirection)) {
                remainingSteps = (YAxisDistanceWithDirection > 0) ? remainingSteps : remainingSteps * -1;
                setCurrentPosition(new Point(currentDestination.x, (getCurrentPosition().y + remainingSteps)));
            }
            //case 1: totalNoOfSteps within distance to destination for X axis
            else {
                totalNoOfSteps = (XAxisDistanceWithDirection > 0) ? totalNoOfSteps : totalNoOfSteps * -1;
                getCurrentPosition().x = getCurrentPosition().x + totalNoOfSteps;
            }
            updateAvailability();
        }
    }

}
