package com.motional.cthye.taxibookingsystem.util;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class DistanceUtilTest {

    private Point CurrentPosition;

    @Before
    public void beforeMethod() {
        CurrentPosition = new Point(0, 0);
    }

    @Test
    public void testGetDistanceBetweenTwoPoints_PositiveXYDestination_Pass() {
        Point PositiveXY = new Point(10, 10);
        assertEquals("Method should return straight line distance of 2 points: " + CurrentPosition + " -> " + PositiveXY,
                Math.round(14.142135623730951), Math.round(DistanceUtil.getDistanceBetweenTwoPoints(CurrentPosition, PositiveXY)));
    }

    @Test
    public void testGetDistanceBetweenTwoPoints_PositiveXNegativeYDestination_Pass() {
        Point PositiveXNegativeY = new Point(10, -10);
        assertEquals("Method should return straight line distance of 2 points: " + CurrentPosition + " -> " + PositiveXNegativeY,
                Math.round(14.142135623730951), Math.round(DistanceUtil.getDistanceBetweenTwoPoints(CurrentPosition, PositiveXNegativeY)));
    }

    @Test
    public void testGetDistanceBetweenTwoPoints_NegativeXPositiveYDestination_Pass() {
        Point NegativeXPositiveY = new Point(-10, 10);
        assertEquals("Method should return straight line distance of 2 points: " + CurrentPosition + " -> " + NegativeXPositiveY,
                Math.round(14.142135623730951), Math.round(DistanceUtil.getDistanceBetweenTwoPoints(CurrentPosition, NegativeXPositiveY)));
    }

    @Test
    public void testGetDistanceBetweenTwoPoints_NegativeXYDestination_Pass() {
        Point NegativeXY = new Point(-10, -10);
        assertEquals("Method should return straight line distance of 2 points: " + CurrentPosition + " -> " + NegativeXY,
                Math.round(14.142135623730951), Math.round(DistanceUtil.getDistanceBetweenTwoPoints(CurrentPosition, NegativeXY)));
    }

    @Test
    public void testGetDistanceBetweenTwoPoints_MaxIntegerDestination_Pass() {
        Point maxIntPoint = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals("Method should return straight line distance of 2 points: " + CurrentPosition + " -> " + maxIntPoint,
                Math.round(3037000498.5618), Math.round(DistanceUtil.getDistanceBetweenTwoPoints(CurrentPosition, maxIntPoint)));
    }

    @Test
    public void testGetDistanceBetweenTwoPoints_OverIntegerLimitDestination_Fail() {
        Point pointOverIntLimitation = new Point();
        pointOverIntLimitation.setLocation(3147483649.0, 3147483649.0);
        assertEquals("Method should return the maximum possible distance (with integer X and Y) between 2 points: " + CurrentPosition + " -> " + pointOverIntLimitation,
                Math.round(3037000499.0), Math.round(DistanceUtil.getDistanceBetweenTwoPoints(CurrentPosition, pointOverIntLimitation)));
    }

    @Test
    public void testGetDistanceBetweenTwoPoints_CurrentLocationIsDestination_Pass() {
        assertEquals("Method should return zero distance for the same destination and source",
                0, Math.round(DistanceUtil.getDistanceBetweenTwoPoints(CurrentPosition, CurrentPosition)));
    }


    @Test
    public void testGetTravellingDistanceBetweenTwoPoints_PositiveXYDestination_Pass() {
        Point PositiveXY = new Point(10, 10);
        assertEquals("Method should return absolute traveling distance of 2 points: " + CurrentPosition + " -> " + PositiveXY,
                20, DistanceUtil.getTravellingDistanceBetweenTwoPoints(CurrentPosition, PositiveXY));
    }

    @Test
    public void testGetTravellingDistanceBetweenTwoPoints_PositiveXNegativeYDestination_Pass() {
        Point PositiveXNegativeY = new Point(10, -10);
        assertEquals("Method should return absolute traveling distance of 2 points: " + CurrentPosition + " -> " + PositiveXNegativeY,
                20, DistanceUtil.getTravellingDistanceBetweenTwoPoints(CurrentPosition, PositiveXNegativeY));
    }

    @Test
    public void testGetTravellingDistanceBetweenTwoPoints_NegativeXPositiveYDestination_Pass() {
        Point NegativeXPositiveY = new Point(-10, 10);
        assertEquals("Method should return absolute traveling distance of 2 points: " + CurrentPosition + " -> " + NegativeXPositiveY,
                20, DistanceUtil.getTravellingDistanceBetweenTwoPoints(CurrentPosition, NegativeXPositiveY));
    }

    @Test
    public void testGetTravellingDistanceBetweenTwoPoints_NegativeXYDestination_Pass() {
        Point NegativeXY = new Point(-10, -10);
        assertEquals("Method should return absolute traveling distance of 2 points: " + CurrentPosition + " -> " + NegativeXY,
                20, DistanceUtil.getTravellingDistanceBetweenTwoPoints(CurrentPosition, NegativeXY));
    }

    @Test
    public void testGetTravellingDistanceBetweenTwoPoints_MaxIntegerDestination_Fail() {
        Point maxIntPoint = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals("Method should return -2 travelling distance due to integer overflow" + CurrentPosition + " -> " + maxIntPoint,
                -2, DistanceUtil.getTravellingDistanceBetweenTwoPoints(CurrentPosition, maxIntPoint));
    }

    @Test
    public void testGetTravellingDistanceBetweenTwoPoints_OverIntegerLimitDestination_Fail() {
        Point pointOverIntLimitation = new Point();
        pointOverIntLimitation.setLocation(3147483649.0, 3147483649.0);
        assertEquals("Method should return -2 travelling distance due to integer overflow" + CurrentPosition + " -> " + pointOverIntLimitation,
                -2, DistanceUtil.getTravellingDistanceBetweenTwoPoints(CurrentPosition, pointOverIntLimitation));
    }

    @Test
    public void testGetTravellingDistanceBetweenTwoPoints_CurrentLocationIsDestination_Pass() {
        assertEquals("Method should return zero absolute travelling distance for the same destination and source",
                0, Math.round(DistanceUtil.getTravellingDistanceBetweenTwoPoints(CurrentPosition, CurrentPosition)));
    }


}
