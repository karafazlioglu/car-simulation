package com.example.car.simulation;

import java.util.ArrayList;
import java.util.List;

public class SimulationResult
{
    Track track;

    ArrayList<CarStanding> standings = new ArrayList<>();

    public void setTrack(Track track)
    {
        this.track = track;
    }

    public Track getTrack()
    {
        return track;
    }

    public ArrayList<CarStanding> getStandings()
    {
        return standings;
    }



}
