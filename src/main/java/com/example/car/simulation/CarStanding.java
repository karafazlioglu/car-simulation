package com.example.car.simulation;

public class CarStanding
{
    Car car;
    Float time;
    public void setCar(Car car)
    {
        this.car = car;
    }
    public Car getCar()
    {
        return car;
    }
    public void setTime(Float time)
    {
        this.time = time;
    }
    public Float getTime()
    {
        return time;
    }
    public String toString()
    {
        return String.format("%s ended the race in %7.2f seconds ", car.getName(), time);
    }

}
