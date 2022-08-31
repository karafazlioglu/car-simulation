package com.example.car.simulation;

public class Track
{
    private final String name;
    private final Integer length;

    public Track(String name, Integer length)
    {
        this.name = name;
        this.length = length;
    }

    public String getName()
    {
        return name;
    }

    public Integer getLength()
    {
        return length;
    }

}
