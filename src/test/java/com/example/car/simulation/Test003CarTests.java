package com.example.car.simulation;

import com.example.car.simulation.engine.pojo.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test003CarTests
{
    @Test
    void nameModelBrandDriverTest()
    {
        String name = "asdf";
        String brand = "jkjkl";
        String model = "yrteı";
        String driver = "ytyrl";

        Float acceleration = 1.0f;
        Float topSpeed = 110.0f;
        Integer handling = 2;

        Car car = new Car();

        car.setBrand(brand);
        car.setDriver(driver);
        car.setName(name);
        car.setAcceleration(acceleration);
        car.setModel(model);
        car.setTopSpeed(topSpeed);
        car.setHandling(handling);

        Assertions.assertEquals(name, car.getName());
        Assertions.assertEquals(brand, car.getBrand());
        Assertions.assertEquals(driver, car.getDriver());
        Assertions.assertEquals(acceleration, car.getAcceleration());
        Assertions.assertEquals(model, car.getModel());
        Assertions.assertEquals(topSpeed, car.getTopSpeed());
        Assertions.assertEquals(handling, car.getHandling());



    }
}
