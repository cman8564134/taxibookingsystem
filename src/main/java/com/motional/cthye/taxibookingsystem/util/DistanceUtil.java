package com.motional.cthye.taxibookingsystem.util;

import java.awt.*;

public final class DistanceUtil {

    /**
     * This functions calculates the distance between 2 coordinates
     * @param co1 First Coordinate
     * @param co2 Second Coordinate
     * @return the distance between 2 coordinates
     */
    public static double getDistanceBetweenTwoPoints(Point co1, Point co2){
        return co1.distance(co2);
    }
}
