package com.example.car.simulation;

import com.example.car.simulation.engine.pojo.Car;
import com.example.car.simulation.engine.pojo.CarStanding;
import com.example.car.simulation.engine.pojo.CarState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test004CarStateTests
{
    @Test
    void carDistanceTimeSpeedTest()
    {
        Car car = new Car();

        Float distance = 250.5f;
        Float time = 5.5f;
        Float speed = 98.9f;

        CarState cs;
        cs = new CarState();

        cs.setTime(time);
        cs.setDistance(distance);
        cs.setSpeed(speed);
        cs.setCar(car);

        Assertions.assertEquals(time, cs.getTime());
        Assertions.assertEquals(distance, cs.getDistance());
        Assertions.assertEquals(speed, cs.getSpeed());



    }
}
