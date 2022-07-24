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
        CarStanding carStanding = new CarStanding();
        Float time = 0f;
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
            // TODO
            time = time + 1;
            //if (allFinished = true)
            //{
                //simulation().standings.add();
                //simulation().standings.add();
            //}


            //CarStanding carStanding = new CarStanding();

            //sortCarState(csg, 250);
            //while (300f > carStates.get(cars.indexOf(0)).getDistance() > 250f)
        }
        carStanding.setTime(time);

        SimulationResult simulationResult =  new SimulationResult();
        // TODO
        System.out.println(time);
        return simulationResult;
    }
    //private void sortCarState(d)
    //{
        //System.out.println("Both cars are ready to go.");
       // System.out.println("Set......Go! ");
        //int d = distancenew;

    //}
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
