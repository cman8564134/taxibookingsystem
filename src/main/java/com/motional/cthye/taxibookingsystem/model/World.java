package com.motional.cthye.taxibookingsystem.model;

import com.motional.cthye.taxibookingsystem.util.DistanceUtil;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class World {
    //there will always be only one world
    private static World World;
    //In this world, there are many unique vehicles
    HashSet<Vehicle> Vehicles = new HashSet<>();

    private World(){}

    public static World getInstance(){
        if(World== null){
            World = new World();
        }
        return World;
    }

    /**
     * function that simulates the time unit has moved by one
     */
    public void tick(){
        for (Movable vehicle: Vehicles){
            vehicle.move();
        }
    }

    public void addVehicleIntoWorld(Vehicle vehicle){
        Vehicles.add(vehicle);
    }

    public Vehicle getNearestAvailableVehicleFromPoint(Point point){
        List<Vehicle> availableVehicles = getAvailableVehicles();
        Vehicle nearestVehicle = null;
        if(availableVehicles.size() >0){
            double nearestDistance = Double.MAX_VALUE;
            for(Vehicle vehicle: availableVehicles){
                double currentDistance = DistanceUtil.getDistanceBetweenTwoPoints(point, vehicle.getCurrentPosition());
                if(currentDistance < nearestDistance || (currentDistance == nearestDistance && (nearestVehicle == null || vehicle.ID < nearestVehicle.ID))){
                    nearestVehicle = vehicle;
                    nearestDistance = currentDistance;
                }
            }
        }
        return nearestVehicle;
    }

    public List<Vehicle> getAvailableVehicles(){
        return this.Vehicles.stream().distinct().filter(Vehicle::isAvailable).collect(Collectors.toList());
    }


}
