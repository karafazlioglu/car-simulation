package com.example.car.simulation;

import com.example.car.simulation.engine.RaceEngine;
import com.example.car.simulation.engine.SimulationResultPrinter;
import com.example.car.simulation.engine.pojo.Car;
import com.example.car.simulation.engine.pojo.SimulationResult;
import com.example.car.simulation.engine.pojo.Track;

import java.util.ArrayList;
import java.util.Iterator;

public class Application
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        RaceEngine raceEngine = new RaceEngine();

        Track track1 = new Track("Bostancı E5", 2000);
        raceEngine.setTrack(track1);

        Car car1 = new Car();
        car1.setName("Karaşimşek");
        car1.setBrand("Tofaş");
        car1.setModel("Şahin");
        car1.setAcceleration(2.5f);
        car1.setTopSpeed(400.5f);
        car1.setHandling(6);
        car1.setDriver("Hakkinen");
        raceEngine.addCar(car1);

        Car car2 = new Car();
        car2.setName("Ağlatıcı  ");
        car2.setBrand("BMW");
        car2.setModel("720d");
        car2.setAcceleration(3f);
        car2.setTopSpeed(200.5f);
        car2.setHandling(5);
        car2.setDriver("Schumacher");
        raceEngine.addCar(car2);

        Car car3 = new Car();
        car3.setName("Yaramaz   ");
        car3.setBrand("Chevrolet Corvette  ");
        car3.setModel("Z06");
        car3.setAcceleration(3f);
        car3.setTopSpeed(400.5f);
        car3.setHandling(9);
        car3.setDriver("Vettel  ");
        raceEngine.addCar(car3);

        Car car4 = new Car();
        car4.setName("Terminator");
        car4.setBrand("Ford");
        car4.setModel("Mustang");
        car4.setAcceleration(2f);
        car4.setTopSpeed(500.5f);
        car4.setHandling(4);
        car4.setDriver("Hamilton");
        raceEngine.addCar(car4);

        Car car5 = new Car();
        car5.setName("Tuğla     ");
        car5.setBrand("Volvo");
        car5.setModel("2000");
        car5.setAcceleration(4f);
        car5.setTopSpeed(100.5f);
        car5.setHandling(6);
        car5.setDriver("Alonso  ");
        raceEngine.addCar(car5);



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

        System.out.println("10  9   8   7   6   5   4   3   2   1 ... GO!!");

        SimulationResult simulationResult = raceEngine.simulation();

        SimulationResultPrinter.print(simulationResult);

        //System.out.printf("\t\t\t\t\t\t\tRace just ended in %s", simulationResult.getTrack().getName());
       // System.out.println(" ");
       // System.out.println("\t\t\t\t\t\t  We have just received the results!!");
       // System.out.println("\t\t\tFirst place  " + simulationResult.getStandings().get(0));
       // System.out.println("\t\t\tSecond place " + simulationResult.getStandings().get(1));









    }
}
