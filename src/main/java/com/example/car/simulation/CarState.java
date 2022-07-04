package com.example.car.simulation;

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

}
