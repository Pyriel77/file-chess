package com.codecool.chessopen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ChessResults {

    static class Competitor {
        private String name;
        private int points;
        
        public Competitor(String name, int points) {
            this.name = name;
            this.points = points;

        }
        public String getName() {
            return name;
        }
        public double getPoints() {
            return this.points;
        }
    }


    public List<String> getCompetitorsNamesFromFile(String fileName){

        List<Competitor> competitors = new ArrayList<>();
        List<String> names = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    String[] pieces = line.split(",");
                    competitors.add(new Competitor(pieces[0],
                            (Integer.parseInt(pieces[1])
                                    + Integer.parseInt(pieces[2])
                                    + Integer.parseInt(pieces[3])
                                    + Integer.parseInt(pieces[4])
                                    + Integer.parseInt(pieces[5]))));
                }
            }
            br.close();

        } catch (IOException e) {
            System.out.println("File not found!");
        }
        competitors.sort(Comparator.comparingDouble(Competitor::getPoints).reversed());

        for (Competitor competitor : competitors) {
            names.add(competitor.getName());
        }
        return names;
    }
}
