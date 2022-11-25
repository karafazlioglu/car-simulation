package com.example.car.simulation;

import com.example.car.simulation.engine.RaceEngine;
import com.example.car.simulation.engine.pojo.Car;
import com.example.car.simulation.engine.pojo.CarState;
import com.example.car.simulation.engine.pojo.SimulationResult;
import com.example.car.simulation.engine.pojo.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Test006RaceEngineTests
{
    @Test
    void trackCarsCarStatesTest()
    {

        String name = "asd";
        Integer length = 123;

        Track t = new Track(name, length);

        RaceEngine re = new RaceEngine();

        re.setTrack(t);

        Assertions.assertEquals(t, re.getTrack());



    }
}
