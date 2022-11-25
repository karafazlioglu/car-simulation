package com.example.car.simulation;

import com.example.car.simulation.engine.pojo.Car;
import com.example.car.simulation.engine.pojo.CarStanding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Test002CarStandingTests
{
    @Test
    void carAndTimeTest()
    {

        Car car = new Car();
        CarStanding cst;
        cst = new CarStanding();
        Float time = 121.2f;
        cst.setTime(time);


        Assertions.assertEquals(time, cst.getTime());

    }
}
