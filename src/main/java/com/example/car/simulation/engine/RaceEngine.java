package com.example.car.simulation.engine;

import com.example.car.simulation.engine.pojo.*;

import java.util.ArrayList;
import java.util.Comparator;

public class RaceEngine
{
    private Track track;
    private ArrayList<Car> cars = new ArrayList<>();

    private ArrayList<CarState> carStates = new ArrayList<>();

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
    public ArrayList<CarState> getCarStates()
    {
        return carStates;
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

        boolean allFinished = false;
        while (!allFinished)
        {
            allFinished = true;
            for (CarState cs : carStates)
            {
                boolean isUpdated = updateCarState(cs, 1f);
                if(isUpdated)
                    allFinished = false;
            }
            sortCarStates(carStates);
        }

        SimulationResult simulationResult =  new SimulationResult();
        simulationResult.setTrack(getTrack());
        for (CarState cs : carStates)
        {
            CarStanding carStanding = new CarStanding();
            carStanding.setCar(cs.getCar());
            carStanding.setTime(cs.getTime());
            simulationResult.addCarStanding(carStanding);
        }

        return simulationResult;
    }

    private void sortCarStates(ArrayList<CarState> carStates)
    {
        // TODO check: is sort method working

//        carStates.sort(Comparator.comparing(CarState::getDistance));
        carStates.sort(Comparator.comparing(CarState::getDistance).reversed());
        

//        boolean allSorted = false;
//        int loopCount = 0;
//
//        while (!allSorted)
//        {
//            allSorted = true;
//            for (int i = 0; i < carStates.size() - 1; i++)
//            {
//                if (carStates.get(i).getDistance() < carStates.get(i + 1).getDistance())
//                {
//                    allSorted = false;
//                    CarState cst = carStates.get(i);
//                    carStates.set(i, carStates.get(i + 1));
//                    carStates.set(i + 1, cst);
//                    loopCount += 1;
//                }
//
//                //System.out.println(carStates.get(i).getDistance() + "\n" + carStates.get(i + 1).getDistance() );
//            }
//        }

    }

    private boolean updateCarState(CarState cs, Float timeInterval)
    {
//        System.out.printf("Car State before. Car name: %s Distance: %7.2f Speed: %7.3f Time: %5.1f \n",
//                cs.getCar().getName(),
//                cs.getDistance(),
//                cs.getSpeed(),
//                cs.getTime()
//        );
        Float maxDistance = Float.valueOf(track.getLength()); // m
        Float acceleration = cs.getCar().getAcceleration();  // m/s2
        Float speed = cs.getSpeed();  // km/hr
        Float time = cs.getTime(); // second
        Float distance = cs.getDistance();  // m
        Float topSpeed = cs.getCar().getTopSpeed();

        if (distance >= maxDistance)
        {
            // hesaba gerek yok yarisi coktan bitirmis
            return false;
        }

        Float accelerationInterval = timeInterval;
        Float intervalForTopSpeed = ((topSpeed - speed) / acceleration ) / 3.6f;
        if (timeInterval > intervalForTopSpeed)
        {
            accelerationInterval = intervalForTopSpeed;
        }
        Float topSpeedInterval = timeInterval - accelerationInterval;

        Float speedNew = speed + (acceleration * accelerationInterval) * 3.6f;
        Float distanceAcc = ((speedNew + speed) / 2.0f * accelerationInterval) / 3.6f;
        Float distanceTopSpeed = (topSpeedInterval * topSpeed) / 3.6f;
        Float distanceNew = distance + distanceAcc + distanceTopSpeed;
        Float timeNew = time + timeInterval;

        if (distanceNew > maxDistance)
        {
            if (distance + distanceAcc >= maxDistance)
            {
                float d = maxDistance - distance;
                accelerationInterval = ((-speed / 3.6f) + (float) Math.sqrt(2 * acceleration * d + speed * speed / 3.6f / 3.6f) ) / acceleration;

                distanceNew = maxDistance;
                timeNew = time + accelerationInterval;
                speedNew = speed + (acceleration * accelerationInterval) * 3.6f;
            }
            else
            {
                float d = maxDistance - ( distance + distanceAcc);
                topSpeedInterval = (d / speed) * 3.6f;
                distanceNew = maxDistance;
                speedNew = topSpeed;
                timeNew = time + accelerationInterval + topSpeedInterval;
            }
        }

//        float distanceError = distanceNew - maxDistance;
//
//
//        if (distanceError > 0)
//        {
//            if (distanceError < 0.00001 )
//            {
//                distanceNew = maxDistance;
//            }
//            else
//            {
//                updateCarState(cs, timeInterval/2);
//                updateCarState(cs, timeInterval/2);
//                return;
//            }
//        }

        cs.setSpeed(speedNew);
        cs.setTime(timeNew);
        cs.setDistance(distanceNew);

        System.out.println("Car State after.  " + cs);
        return true;
    }
}
