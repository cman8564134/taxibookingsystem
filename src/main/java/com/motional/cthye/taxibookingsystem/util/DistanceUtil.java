package com.motional.cthye.taxibookingsystem.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * Utility class for distance related function
 */
public final class DistanceUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceUtil.class);

    /**
     * Calculates the straight line distance between 2 coordinates
     *
     * @param co1 First Coordinate
     * @param co2 Second Coordinate
     * @return the distance between 2 coordinates
     */
    public static double getDistanceBetweenTwoPoints(Point co1, Point co2) {
        LOGGER.debug("Calculating straight line distance between " + co1.toString() + " and " + co2.toString());
        return co1.distance(co2);
    }

    /**
     * Calculates the travelling distance between 2 coordinates
     *
     * @param co1 First coordinate
     * @param co2 Second Coordinate
     * @return the rounded up travelling distance between 2 coordinates
     */
    public static double getTravellingDistanceBetweenTwoPoints(Point co1, Point co2) {
        LOGGER.debug("Calculating travelling distance between " + co1.toString() + " and " + co2.toString());
        double XDistance = Math.abs(co1.getX() - co2.getX());
        double YDistance = Math.abs(co1.getY() - co2.getY());
        return Math.round(XDistance + YDistance);
    }
}
