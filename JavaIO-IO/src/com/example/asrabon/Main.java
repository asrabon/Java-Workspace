package com.example.asrabon;

import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = Locations.getLocationsInstance();
    private static final String[] validDirection = {"north", "south", "east", "west", "quit"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

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

            if(!exits.containsKey(chosenDirection) && !directionFound) {
                System.out.println("You can not go in that direction.");
            } else {
                loc = exits.get(chosenDirection);
            }
        }
    }
}
