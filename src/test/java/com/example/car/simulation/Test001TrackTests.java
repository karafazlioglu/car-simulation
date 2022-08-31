package com.example.car.simulation;

import com.example.car.simulation.engine.pojo.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test001TrackTests
{
    @Test
    void nameAndLengthTest()
    {
        String name = "asd";
        Integer length = 123;

        Track t = new Track( name, length);

        Assertions.assertEquals(name, t.getName());
        Assertions.assertEquals(length, t.getLength());

    }
}
