package com.motional.cthye.taxibookingsystem.model;

import java.awt.*;
import java.util.LinkedList;

public abstract class Vehicle implements Movable {
    private Point currentPosition;
    private LinkedList<Point> Destinations = new LinkedList<>();
    protected int ID;
    protected int Speed;
    boolean Available = true;

    /**
     * to ensure that all vehicles have these information available
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
        this.Destinations.add(point);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle){
            return this.ID == ((Vehicle) obj).ID;
        }
        return false;
    }

    /**
     * Checks the status of the driver whether all destinations has been arrived.
     */
    protected void updateAvailability(){
        if(this.currentPosition.equals(this.Destinations.peek())){
            Destinations.removeFirst();
            if(Destinations.isEmpty()){
                setAvailable(true);
            }
        }
    }
}
