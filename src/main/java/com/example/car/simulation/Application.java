package com.example.car.simulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        RaceEngine raceEngine = new RaceEngine();

        System.out.println(Track.usage());
        Track track1 = new Track("Bostancı E5", 402);
        raceEngine.setTrack(track1);

        Car car1 = new Car();
        car1.setName("Karaşimşek");
        car1.setBrand("Tofaş");
        car1.setModel("Şahin");
        car1.setAcceleration(15.3f);
        car1.setTopSpeed(200.5f);
        car1.setHandling(6);

        Car car2 = new Car();
        car2.setName("Ağlatıcı");
        car2.setBrand("BMW");
        car2.setModel("720d");
        car2.setAcceleration(26.5f);
        car2.setTopSpeed(300.5f);
        car2.setHandling(8);

        raceEngine.addCar(car1);
        raceEngine.addCar(car2);

        ArrayList<Car> cars = raceEngine.getCars();
        for (int i = 0; i < cars.size(); i++)
        {
            Car c = cars.get(i);
            System.out.println(c.getName());
        }

        Iterator<Car> it = cars.iterator();
        while (it.hasNext())
        {
            Car c = it.next();
            System.out.println(c.getName());
        }
        for (Car c : cars) {
            System.out.println(c.getBrand());
        }

        raceEngine.simulation();
    }
}
