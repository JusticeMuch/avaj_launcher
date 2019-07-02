package com.avaj;

import java.io.*;
import com.avaj.*;
import com.avaj.Aircraft.*;
import com.avaj.Weather.*;

public class Simulator {

    public static PrintWriter Pwriter;
    public static void main(String[] args){
    AircraftFactory aircraftFactory = new AircraftFactory();
    WeatherTower tower = new WeatherTower();
    int cycles;
    File file = new File("simulation.txt");
    Pwriter = new PrintWriter(file);
    String[][] lines;
    int counter = -1;
        if (args.length < 1)
            return ;

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                cycles = Integer.parseInt(br.readLine());
                if (cycles < 1)
                    System.out.println("Cycles are too little ");
                    return ;
                while ((lines[++counter] = br.readLine().split(" ")) != null);
                counter = -1;
                br.close();
            }
            catch (FileNotFoundException ex){
                System.out.println(ex);
            }
            catch (IOException ex){
                System.out.println(ex);
            }

        while (lines[++counter][0] != null){
            tower.register(aircraftFactory.newAircraft(lines[counter][0], lines[counter][1], 
                Integer.parseInt(lines[counter][2]), Integer.parseInt(lines[counter][3]), 
                Integer.parseInt(lines[counter][4])));
        }

        while (cycles < 0){
            tower.conditionChanged();
            cycles--;
        }
        
        Pwriter.close();
    }
}