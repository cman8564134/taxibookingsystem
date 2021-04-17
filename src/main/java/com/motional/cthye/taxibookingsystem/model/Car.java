package com.motional.cthye.taxibookingsystem.model;

import java.awt.*;

public class Car extends Vehicle {

    public Car(int ID, int speed, Point point) {
        super(ID, speed, point);
    }

    /**
     * Car's movement which means its change of coordinate point based on speed. The strategy of movement for car starts
     *  with X axis then Y axis towards its destination.
     */
    @Override
    public void move() {
        if(!Available){
            int remainingDistanceForXWithDirection = (getDestination().x - getCurrentPosition().x);
            if(getSpeed() > Math.abs(remainingDistanceForXWithDirection)){
                // to facilitate if speed larger than remainingDistanceForX but lesser than remainingDistanceForY
                // in another words, in a single move, it reached the destination's X point and moved towards Y point
                // we added this 2 lines to cover that case
                getCurrentPosition().x = getDestination().x;
                int leftOverSpeed = getSpeed() - Math.abs(remainingDistanceForXWithDirection);

                int remainingDistanceForYWithDirection = (getDestination().y - getCurrentPosition().y);
                int travelDistanceWithDirection = (remainingDistanceForYWithDirection>0)? leftOverSpeed : leftOverSpeed *-1;
                getCurrentPosition().y = getCurrentPosition().y + travelDistanceWithDirection;
            } else {
                int travelDistanceWithDirection = (remainingDistanceForXWithDirection>0)? getSpeed() : getSpeed() *-1;
                getCurrentPosition().x = getCurrentPosition().x + travelDistanceWithDirection;
            }
            updateStatus();
        }
    }

}
