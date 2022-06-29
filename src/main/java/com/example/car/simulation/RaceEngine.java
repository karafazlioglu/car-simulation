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
        // initial states
        // TODO create carState for ever car and a a List<CarState>;
        for(Car c : cars)
        {
            CarState carState = new CarState();
            // carState.set(c)
        }

        for(CarState cs : carStates)
        {
            updateCarState(cs);
        }

        //TODO
        return new SimulationResult();
    }

    private void updateCarState(CarState cs)
    {
        // TODO

    }


}
