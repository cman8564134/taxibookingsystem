package com.motional.cthye.taxibookingsystem.model;

import java.awt.*;

public abstract class Vehicle implements Movable {
    private Point currentPosition;
    private Point destination;
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

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle){
            return this.ID == ((Vehicle) obj).ID;
        }
        return false;
    }

    protected void updateStatus(){
        if(this.currentPosition.equals(this.destination)){
            setAvailable(true);
            setDestination(null);
        }
    }
}
