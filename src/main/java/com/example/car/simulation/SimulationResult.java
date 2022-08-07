package com.example.car.simulation;

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

    public void printHeader()
    {
        System.out.printf("\t\t\t\t\t\t\tRace just ended in %s\n \t\t\t\t\t\t  We have just received the results!!\n \t\t\t\t\t\tPOSITION\t\tDRIVER\t\t\t\tTIME",track.getName());
    }
    public void printResults()
    {
        int position;
        for (int i = 0; i < standings.size(); i++)
        {
            position = i + 1;
            System.out.println("\n\t\t\t\t\t\t\t" + position + "\t\t\t" + standings.get(i).getCar().getDriver() + "\t\t\t" + standings.get(i).getTime());
        }
    }

}
