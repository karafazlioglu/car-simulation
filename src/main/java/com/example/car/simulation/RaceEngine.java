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

        for (int i = 0; i < 100; i++)
        {
            for (CarState cs : carStates)
                updateCarState(cs, 1f);
        }

        //TODO
        return new SimulationResult();
    }

    private void updateCarState(CarState cs, Float timeInterval)
    {
        System.out.println("Car State before. Car name: " + cs.getCar().getName() + " Distance: " + cs.getDistance() + " m" + " Speed: " + cs.getSpeed() + " km/hr" + " Time: " + cs.getTime() + " s");

        Integer maxDistance = track.getLength(); // m
        Float acceleration = cs.getCar().getAcceleration();  // m/s2
        Float speed = cs.getSpeed();  // km/hr
        Float time = cs.getTime(); // second
        Float distance = cs.getDistance();  // m
        Float topSpeed = cs.getCar().getTopSpeed();
        Integer trackLength = track.getLength();




        Float accelerationInterval = timeInterval;
        Float intervalForTopSpeed = ((topSpeed - speed) / acceleration ) / 3.6f;
        if (timeInterval > intervalForTopSpeed)
        {
            accelerationInterval = intervalForTopSpeed;
        }
        Float topSpeedInterval = timeInterval - accelerationInterval;


        Float speedNew = speed + (acceleration * accelerationInterval) * 3.6f;
        Float distanceNew = distance + ((speedNew + speed) / 2.0f * accelerationInterval + topSpeedInterval * topSpeed) / 3.6f;
        Float timeNew = time + timeInterval;


        //TODO
        //Track biterse ne olur

        cs.setSpeed(speedNew);
        cs.setTime(timeNew);
        cs.setDistance(distanceNew);

        System.out.println("Car state after.  Car name: " + cs.getCar().getName() + " Distance: " + cs.getDistance() + " m" + " Speed: " + cs.getSpeed() + " km/hr" + " Time: " + cs.getTime() + " s");

    }

}
