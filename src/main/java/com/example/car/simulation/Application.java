package com.example.car.simulation;

import java.util.ArrayList;
import java.util.Iterator;

public class Application
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        RaceEngine raceEngine = new RaceEngine();

        System.out.println(Track.usage());
        Track track1 = new Track("Bostancı E5", 2000);
        raceEngine.setTrack(track1);

        Car car1 = new Car();
        car1.setName("Karaşimşek");
        car1.setBrand("Tofaş");
        car1.setModel("Şahin");
        car1.setAcceleration(4f);
        car1.setTopSpeed(500.5f);
        car1.setHandling(6);
        car1.setDriver("Hakkinen");

        Car car2 = new Car();
        car2.setName("Ağlatıcı  ");
        car2.setBrand("BMW");
        car2.setModel("720d");
        car2.setAcceleration(3f);
        car2.setTopSpeed(800.5f);
        car2.setHandling(8);
        car2.setDriver("Schumacher");

        raceEngine.addCar(car1);
        raceEngine.addCar(car2);

        ArrayList<Car> cars = raceEngine.getCars();
        for (int i = 0; i < cars.size(); i++)
        {
            Car c = cars.get(i);
            System.out.println(c.getName());
            System.out.println(c.getDriver());
        }

        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            System.out.println(c.getName());
            System.out.println(c.getDriver());
        }
        for (Car c : cars) {
            System.out.println(c.getBrand());
            System.out.println(c.getTopSpeed());
            System.out.println(c.getModel());
        }

        SimulationResult simulationResult = raceEngine.simulation();

        simulationResult.setTrack(track1);

       // CarState cs = new CarState();
       // cs.setTime();
       // System.out.println(cs.getTime());

        CarStanding carStanding1 = new CarStanding();

        carStanding1.setCar(car1);
        carStanding1.setTime(31.6228f);


        CarStanding carStanding2 = new CarStanding();
        carStanding2.setCar(car2);
        carStanding2.setTime(36.5148f);


        simulationResult.standings.add(carStanding1);
        simulationResult.standings.add(carStanding2);


        //for (CarStanding csg : simulationResult.standings)
        //{
           // simulationResult.standings.add(csg);
           // System.out.println(simulationResult.standings);
       // }









        System.out.printf("Race just ended in %s", simulationResult.getTrack().name);
        System.out.println(" ");
        System.out.println("Now we received the results!" + simulationResult.getStandings());

    }
}
