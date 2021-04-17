package com.motional.cthye.taxibookingsystem.model;

import java.awt.*;

public class Car extends Vehicle {

    public Car(int ID, int speed, Point point) {
        super(ID, speed, point);
    }

    /**
     * Car's movement. The change of coordinate point that is based on vehicle's speed.
     */
    @Override
    public void move() {
        travelToNextDestinationWithNoOfStep(getSpeed());
    }

    /**
     * The strategy of movement for car starts by travelling the X axis and then the Y axis towards its destination.
     * @param totalNoOfSteps remaining travelling steps towards destination
     */
    private void travelToNextDestinationWithNoOfStep(int totalNoOfSteps){
        Point currentDestination = getDestinationList().peek();
        if(currentDestination != null){
            int XAxisDistanceWithDirection = (currentDestination.x - getCurrentPosition().x);
            int remainingSteps = totalNoOfSteps - Math.abs(XAxisDistanceWithDirection);
            int YAxisDistanceWithDirection = (currentDestination.y - getCurrentPosition().y);

            // case 3&4: if the totalNoOfSteps is above the travelling distance to destination
            if(remainingSteps > Math.abs(YAxisDistanceWithDirection)){
                // We make the vehicle reach its destination and attempt to update status
                getCurrentPosition().x = currentDestination.x;
                getCurrentPosition().y = currentDestination.y;
                updateAvailability();
                // if there are still remaining destination in the list we recurse back to top of function
                // until there is no remaining steps or no remaining destination
                if(!Available){
                    travelToNextDestinationWithNoOfStep(remainingSteps - Math.abs(YAxisDistanceWithDirection));
                }
            }
            // case 2: totalNoOfSteps above distance to destination for X axis but within distance for Y axis
            else if(totalNoOfSteps > Math.abs(XAxisDistanceWithDirection)){
                getCurrentPosition().x = currentDestination.x;
                remainingSteps = (YAxisDistanceWithDirection>0)? remainingSteps : remainingSteps *-1;
                getCurrentPosition().y = getCurrentPosition().y + remainingSteps;
            }
            //case 1: totalNoOfSteps within distance to destination for X axis
            else {
                totalNoOfSteps = (XAxisDistanceWithDirection>0)? totalNoOfSteps : totalNoOfSteps *-1;
                getCurrentPosition().x = getCurrentPosition().x + totalNoOfSteps;
            }
            updateAvailability();
        }
    }

}
