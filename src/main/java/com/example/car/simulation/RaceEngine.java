package com.example.car.simulation;

import java.util.ArrayList;
import java.util.List;

public class RaceEngine
{
    Track track;
    ArrayList<Car> cars = new ArrayList<>();

    public void setTrack(Track track)
    {
        this.track = track;
    }

    public Track getTrack()
    {
        return track;
    }

    public void addCar(Car car)
    {
        cars.add(car);
    }

    public void removeCar(Car car)
    {
        cars.remove(car);
    }

    public ArrayList<Car> getCars()
    {
        return cars;
    }

    public SimulationResult simulation()
    {
        //TODO
        return new SimulationResult();
    }

}
