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

        for (int i = 0; i < 43; i++)
        {
            for (CarState cs : carStates)
                updateCarState(cs, 1f);
        }

        //TODO
        return new SimulationResult();
    }

    private void updateCarState(CarState cs, Float timeInterval)
    {
        System.out.print("Car State before. Car name: " + cs.getCar().getName());
        System.out.printf(" Distance: %7.2f", cs.getDistance());
        System.out.printf(" Speed: %7.3f", cs.getSpeed());
        System.out.printf(" Time: %5.1f", cs.getTime());
        System.out.println();
        Float maxDistance = track.getLength(); // m
        Float acceleration = cs.getCar().getAcceleration();  // m/s2
        Float speed = cs.getSpeed();  // km/hr
        Float time = cs.getTime(); // second
        Float distance = cs.getDistance();  // m
        Float topSpeed = cs.getCar().getTopSpeed();

        //TODO
        //Track biterse ne olur



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

        if (distanceNew > maxDistance)
            distanceNew = maxDistance;


        cs.setSpeed(speedNew);
        cs.setTime(timeNew);
        cs.setDistance(distanceNew);
        System.out.print("Car state after.  Car name: " + cs.getCar().getName());
        System.out.printf(" Distance: %7.2f", cs.getDistance());
        System.out.printf(" Speed: %7.3f", cs.getSpeed());
        System.out.printf(" Time: %5.1f", cs.getTime());
        System.out.println();
    }

}
