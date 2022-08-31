package com.example.car.simulation.engine.pojo;

public class CarStanding
{
    private Car car;
    private Float time;
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
        return String.format(" %s finished the race in %7.2f seconds", car.getName(), time);
    }

}
