package com.example.car.simulation.engine.pojo;

public class CarState
{
    private Car car;
    private Float distance; // meter
    private Float time;  // second
    private Float speed; // km/h

    public void setCar(Car car)
    {
        this.car = car;
    }
    public Car getCar()
    {
        return car;
    }
    public void setDistance(Float distance)
    {
        this.distance = distance;
    }
    public Float getDistance()
    {
        return distance;
    }
    public void setTime(Float time)
    {
        this.time = time;
    }
    public Float getTime()
    {
        return time;
    }
    public void setSpeed(Float speed)
    {
        this.speed = speed;
    }
    public Float getSpeed()
    {
        return speed;
    }

    public String toString()
    {
        return String.format("Car name: %s Distance: %7.2f Speed: %7.3f Time: %5.4f ", car.getName(), distance, speed, time);
    }

}
