package com.motional.cthye.taxibookingsystem.model;

import com.motional.cthye.taxibookingsystem.util.DistanceUtil;

import java.awt.*;


public class Booking {
    Point StartingPoint;
    Point EndingPoint;
    Vehicle Driver;
    int totalTime;

    public Booking(Point startingPoint, Point endingPoint, Vehicle driver, int totalTime) {
        this.StartingPoint = startingPoint;
        this.EndingPoint = endingPoint;
        this.Driver = driver;
        this.totalTime = calculateTotalTime();
    }

    private int calculateTotalTime(){
        //distance from driver to customer location
        double distance1 = DistanceUtil.getDistanceBetweenTwoPoints(this.Driver.getCurrentPosition(), this.StartingPoint);
        //distance from customer location to destination
        double distance2 = DistanceUtil.getDistanceBetweenTwoPoints(this.StartingPoint, this.EndingPoint);
        return (int) Math.round(distance1 + distance2);
    }


}
