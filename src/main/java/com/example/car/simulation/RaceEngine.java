package com.example.car.simulation;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class RaceEngine
{
    Track track;
    ArrayList<Car> cars = new ArrayList<>();

    List<CarState> carStates = new ArrayList<>();

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
        for (Car c : cars)
        {
            CarState carState = new CarState();
            carState.setCar(c);
            carState.setDistance(0f);
            carState.setSpeed(0f);
            carState.setTime(0f);

            carStates.add(carState);
        }



        // TODO
        // Yarışın bittiğini nasıl anlıycaz.
        for (int i = 0; i < 1; i++)
        {
            for (CarState cs : carStates)
                updateCarState(cs, 1f);
        }

        //TODO
        return new SimulationResult();
    }

    private void updateCarState(CarState cs, Float timeInterval)
    {
        System.out.println("Car name: " + cs.getCar().getName() + " Distance: " + cs.getDistance() + " Speed: " + cs.getSpeed() + " Time: " + cs.getTime());

        Integer maxDistance = track.getLength();
        Integer acceleration = cs.getCar().getAcceleration();
        Float speed = cs.getSpeed();
        Float time = cs.getTime();
        Float distance = cs.getDistance();

        //TODO
        //speedOld + acc*time = speedNew
        //(speedOld+speedNew) / 2) * time + distanceOld
        //Top speed hesaplamaya katılacak
        //Track biterse ne olur
        Float speedNew = 0f;
        Float timeNew = time + timeInterval;
        Float distanceNew = 0f;

        cs.setSpeed(speedNew);
        cs.setTime(timeNew);
        cs.setDistance(distanceNew);
    }


}
