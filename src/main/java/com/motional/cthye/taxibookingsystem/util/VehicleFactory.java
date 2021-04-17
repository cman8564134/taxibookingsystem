package com.motional.cthye.taxibookingsystem.util;

import com.motional.cthye.taxibookingsystem.model.Car;
import com.motional.cthye.taxibookingsystem.model.Vehicle;

import java.awt.*;

public class VehicleFactory {
    public static String NORMAL_CAR = "NORMAL_CAR";

    public Vehicle getVehicle(String vehicleType, int ID){
        if(vehicleType.equals(NORMAL_CAR)){
            //Simulating a car factory in (0,0) which creates car with speed 1
            return new Car(ID, 1, new Point());
        } else{
            return null;
        }
    }
}
