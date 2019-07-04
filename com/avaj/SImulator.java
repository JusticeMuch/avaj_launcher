package com.avaj;

import java.io.*;
import com.avaj.WeatherTower;
import com.avaj.aircraft.*;

public class Simulator {

    public static PrintWriter writer;
    public static WeatherTower tower;
    public static void main(String[] args){
    tower = new WeatherTower();
    int cycles = 0;
    try{
            File file = new File("simulation.txt");
            writer = new PrintWriter(file);
       } catch(FileNotFoundException ex) {
           System.out.println("File not created");
    }
    String[] lines = null;
    String line;
        if (args.length < 1)
            return ;

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                cycles = Integer.parseInt(br.readLine());
                if (cycles < 1){
                    System.out.println("Cycles are too little ");
                    return ;
                }
                while ((line = br.readLine()) != null){
                    lines = line.split(" ");
                    Flyable temp = AircraftFactory.newAircraft(lines[0], lines[1], 
                        Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), 
                        Integer.parseInt(lines[4]));
                    temp.registerTower(tower);
                    
                }
                while (cycles > 0){
                    tower.conditionChanged();
                    cycles--;
                }
                br.close();
            }
            catch (FileNotFoundException ex){
                System.out.println("File not found");
            }
            catch (IOException ex){
                System.out.println(ex);
            }
        writer.close();
    }
}