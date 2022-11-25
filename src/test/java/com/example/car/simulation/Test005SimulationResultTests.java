package com.example.car.simulation;

import com.example.car.simulation.engine.pojo.SimulationResult;
import com.example.car.simulation.engine.pojo.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test005SimulationResultTests
{
    @Test
    void trackTest()
    {
        SimulationResult sr = new SimulationResult();

        String name = "asd";
        Integer length = 123;

        Track t = new Track(name, length);
        sr.setTrack(t);

        Assertions.assertEquals(t, sr.getTrack());

    }
}
