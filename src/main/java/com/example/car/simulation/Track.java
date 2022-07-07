package com.example.car.simulation;

public class Track
{
    public static String usage()
    {
        return "Bu bir yol sınıfıdır. Yarışın yapılacağı yolu belirtir. ";
    }
    String name;
    Float length;

    public Track(String name, Float length)
    {
        this.name = name;
        this.length = length;
    }

    public String getName()
    {
        return name;
    }

    public Float getLength()
    {
        return length;
    }

}
