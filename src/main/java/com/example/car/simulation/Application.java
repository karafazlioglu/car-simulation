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
        car1.setAcceleration(2f);
        car1.setTopSpeed(500.5f);
        car1.setHandling(6);
        car1.setDriver("Hakkinen");
        raceEngine.addCar(car1);

        Car car2 = new Car();
        car2.setName("Ağlatıcı  ");
        car2.setBrand("BMW");
        car2.setModel("720d");
        car2.setAcceleration(3f);
        car2.setTopSpeed(200.5f);
        car2.setHandling(8);
        car2.setDriver("Schumacher");
        raceEngine.addCar(car2);

        ArrayList<Car> cars = raceEngine.getCars();
        for (int i = 0; i < cars.size(); i++)
        {
            Car c = cars.get(i);
            System.out.println(c.getName());
            //System.out.println(c.getDriver());
        }

        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            System.out.println(c.getName());
            //System.out.println(c.getDriver());
        }
        for (Car c : cars) {
            System.out.println(c.getBrand());
            System.out.println(c.getTopSpeed());
            System.out.println(c.getModel());
        }

        SimulationResult simulationResult = raceEngine.simulation();

        simulationResult.toStringHeader();
        simulationResult.toStringResults();

        //System.out.printf("\t\t\t\t\t\t\tRace just ended in %s", simulationResult.getTrack().getName());
       // System.out.println(" ");
       // System.out.println("\t\t\t\t\t\t  We have just received the results!!");
       // System.out.println("\t\t\tFirst place  " + simulationResult.getStandings().get(0));
       // System.out.println("\t\t\tSecond place " + simulationResult.getStandings().get(1));









    }
}
