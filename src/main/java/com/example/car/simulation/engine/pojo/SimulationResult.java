package com.example.car.simulation.engine.pojo;

import java.util.ArrayList;

public class SimulationResult
{
    private Track track;

    private ArrayList<CarStanding> standings = new ArrayList<>();

    public void setTrack(Track track)
    {
        this.track = track;
    }

    public Track getTrack()
    {
        return track;
    }
    public void addCarStanding(CarStanding CarStanding)
    {
        standings.add(CarStanding);
    }
    public void removeCarStanding(CarStanding Carstanding)
    {
        standings.remove(Carstanding);
    }
    public void clearCarStanding(CarStanding Carstanding)
    {
        standings.clear();
    }
    public ArrayList<CarStanding> getStandings()
    {
        return standings;
    }



}
