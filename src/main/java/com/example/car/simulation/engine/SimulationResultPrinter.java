package com.example.car.simulation.engine;

import com.example.car.simulation.engine.pojo.SimulationResult;

public class SimulationResultPrinter
{
    static public void print(SimulationResult simulationResult)
    {
        System.out.printf("\t\t\t\t\t\t\tRace just ended in %s\n \t\t\t\t\t\t  We have just received the results!!\n \t\t\t\t\t\tPOSITION\t\tDRIVER\t\t\t\tTIME",simulationResult.getTrack().getName());

        int position;
        for (int i = 0; i < simulationResult.getStandings().size(); i++)
        {
            position = i + 1;
            System.out.println("\n\t\t\t\t\t\t\t" + position + "\t\t\t" + simulationResult.getStandings().get(i).getCar().getDriver() + "\t\t\t" + simulationResult.getStandings().get(i).getTime());
        }
    }

}
