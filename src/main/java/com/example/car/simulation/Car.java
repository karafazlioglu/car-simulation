package com.example.car.simulation;

import javax.naming.Name;

public class Car
{
    String name;
    String brand;
    String model;

    Float acceleration;
    Float topSpeed;
    Integer handling;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }

    public void setAcceleration(Float acceleration)
    {
        this.acceleration = acceleration;
    }

    public Float getAcceleration()
    {
        return acceleration;
    }

    public void setTopSpeed(Float topSpeed)
    {
        this.topSpeed = topSpeed;
    }

    public Float getTopSpeed()
    {
        return topSpeed;
    }

    public void setHandling(Integer handling)
    {
        this.handling = handling;
    }

    public Integer getHandling()
    {
        return handling;
    }
}
