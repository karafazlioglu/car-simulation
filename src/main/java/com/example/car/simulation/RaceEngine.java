package com.example.car.simulation;

import javax.xml.namespace.QName;
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



        List<CarState> carStates = new ArrayList<>();

        for (Car c : cars)
        {
            CarState carState = new CarState();
            carState.setCar(c);
            carState.setDistance(0f);
            carState.setSpeed(0f);
            carState.setTime(0f);

            carStates.add(carState);
        }


        for (CarState cs : carStates)
        {
            updateCarState(cs);

        }

        //TODO
        return new SimulationResult();
    }

    private void updateCarState(CarState cs)
    {
        // TODO
        System.out.println("Car name: " + cs.getCar().getName() + " Distance: " + cs.getDistance() + " Speed: " + cs.getSpeed() + " Time: " + cs.getTime());

    }


}
