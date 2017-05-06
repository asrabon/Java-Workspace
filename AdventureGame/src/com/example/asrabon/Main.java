package com.example.asrabon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();
    private static final String[] validDirection = {"north", "south", "east", "west", "quit"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> tempExits = null;
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExits));

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescritpion());
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String chosenDirection = in.nextLine().toUpperCase();

            boolean directionFound = false;
            if(chosenDirection.length() > 1) {
                String[] chosenDirectionArray = chosenDirection.split(" ");

                for(String word: chosenDirectionArray) {
                    for(String direction: validDirection) {
                        if(word.equalsIgnoreCase(direction)) {
                            chosenDirection = "" + word.charAt(0);
                            directionFound = true;
                            break;
                        }
                    }
                }
            }

            if(!directionFound) {
                System.out.println("Invalid direction try again.");
            }

            if(exits.containsKey(chosenDirection)) {
                loc = exits.get(chosenDirection);
            } else {
                System.out.println("You can not go in that direction.");
            }
        }
    }
}
