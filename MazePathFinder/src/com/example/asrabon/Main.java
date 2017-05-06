package com.example.asrabon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    public static void main (String[] args) {
        int length = -1;
        int width = -1;
        do {
            try{
                System.out.println("Enter the length of the maze you would like to create must be greater than or equal to 2.");
                length = in.nextInt();
                if (length <= 1) {
                    throw new InputMismatchException("The number must be an integer greater than or equal to 2.");
                }
            }catch (InputMismatchException Error) {
                System.out.println("Error: You must enter an integer greater than or equal to 2.");
                in.nextLine();
            }
        }while(length <= 1);

        do {
            try{
                System.out.println("Enter the width of the maze you would like to create must be greater than or equal to 2.");
                width = in.nextInt();
                if (width <= 1) {
                    throw new InputMismatchException("The number must be an integer greater than or equal to 2.");
                }
            }catch (InputMismatchException Error) {
                System.out.println("Error: You must enter an integer greater than or equal to 2.");
                in.nextLine();
            }
        }while(width <= 1);

        if((length%2) == 0) {
            length++;
        }
        if((width%2) == 0) {
            width++;
        }

        int movingLength = 1;//picks random start point for maze
        int movingWidth = 1;//picks random start point for maze

        //creates maze with pluses everywhere
        String[][] maze = new String[length+2][width+2];
        for (int i = 0; i <= (length+ 1); i++) {
            for (int j = 0; j <= (width+1); j++) {
                maze[i][j] = "+";
            }//exit for loop for width
        }//exit for loop for length

        makeMaze (length, width, maze, movingLength, movingWidth);
        solveMaze (length, width, maze, movingLength, movingWidth);
    }//exit of main

    public static void makeMaze (int length, int width, String[][] maze, int movingLength, int movingWidth) {

        //initializes all the variables that will be used to create the maze
        int whitespaceLength = 0;
        int whitespaceWidth = 0;
        int whitespaceLength2 = 0;
        int whitespaceWidth2 = 0;
        int direction = 0;//used to generate random numbers to tell the maze where to go
        boolean foundSpace = false;
        boolean upCheck = false;
        boolean downCheck = false;
        boolean leftCheck = false;
        boolean rightCheck = false;

        ArrayList<ArrayList<Integer>> mazeStack = new ArrayList<ArrayList<Integer>>();//makes arraylist to hold integers of where it has traveled used to mimic a stack

        //loop that goes through maze and carves a path
        do {
            while ((upCheck == false || downCheck == false || leftCheck == false || rightCheck == false) && foundSpace == false) {
                direction = rand.nextInt(4);
                if (direction == 0 && (movingLength - 2) >= 0 && maze[movingLength - 1][movingWidth] == "+" && maze[movingLength - 2][movingWidth] == "+") {
                    //maze[movingLength - 1][movingWidth] = " ";
                    whitespaceLength = movingLength -1;
                    whitespaceWidth = movingWidth;
                    whitespaceLength2 = movingLength -2;
                    whitespaceWidth2 = movingWidth;
                    foundSpace = true;
                }//checks if it can move up
                if (direction == 0){
                    upCheck = true;
                }
                if (direction == 1 && (movingLength + 2) <= (length+1) && maze[movingLength + 1][movingWidth] == "+" && maze[movingLength + 2][movingWidth] == "+") {
                    //maze[movingLength + 1][movingWidth] = " ";
                    whitespaceLength = movingLength +1;
                    whitespaceWidth = movingWidth;
                    whitespaceLength2 = movingLength +2;
                    whitespaceWidth2 = movingWidth;
                    foundSpace = true;
                }//checks if it can move down
                if (direction == 1) {
                    downCheck = true;
                }
                if (direction == 2 && (movingWidth - 2) >= 0 && maze[movingLength][movingWidth -1] == "+" && maze[movingLength][movingWidth-2] == "+") {
                    //maze[movingLength][movingWidth-1] = " ";
                    whitespaceLength = movingLength;
                    whitespaceWidth = movingWidth-1;
                    whitespaceLength2 = movingLength;
                    whitespaceWidth2 = movingWidth - 2;
                    foundSpace = true;
                }//checks if it can move left
                if (direction == 2) {
                    leftCheck = true;
                }
                if (direction == 3 && (movingWidth + 2) <= (width+1) && maze[movingLength][movingWidth +1] == "+" && maze[movingLength][movingWidth+2] == "+") {
                    //maze[movingLength][movingWidth+1] = " ";
                    whitespaceLength = movingLength;
                    whitespaceWidth = movingWidth +1;
                    whitespaceLength2 = movingLength;
                    whitespaceWidth2 = movingWidth+2;
                    foundSpace = true;
                }//checks if it can move right
                if (direction == 3) {
                    rightCheck = true;
                }
            }//exit of direction check while loop
            if (foundSpace == true) {
                movingLength = whitespaceLength2;
                movingWidth = whitespaceWidth2;
                maze[whitespaceLength][whitespaceWidth] = " ";
                maze[movingLength][movingWidth] = " ";
                mazeStack.add( new ArrayList<Integer>() );
                mazeStack.get(mazeStack.size() - 1).add(movingLength);
                mazeStack.get(mazeStack.size() - 1).add(movingWidth);
            }
            if (((upCheck == true && downCheck == true && leftCheck == true && rightCheck == true) && foundSpace == false)){
                mazeStack.remove((mazeStack.size()) - 1);
                if ((mazeStack.size() != 0)) {
                    movingLength = mazeStack.get((mazeStack.size()) - 1).get(0);
                    movingWidth = mazeStack.get((mazeStack.size()) - 1).get(1);
                }
            }
            leftCheck = false;
            rightCheck = false;
            upCheck = false;
            downCheck = false;
            foundSpace = false;
        }while (mazeStack.isEmpty() == false);
    }//end of makeMaze method

    public static void solveMaze (int length, int width, String[][] maze, int movingLength, int movingWidth) {
        System.out.println("This is the maze before it is solved.");
        for (int i = 0; i < (length+ 2); i++) {
            for (int j = 0; j < (width+2); j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        boolean upGood=false;
        boolean downGood=false;
        boolean leftGood=false;
        boolean rightGood=false;
        boolean alreadyTraveledfound = false;
        int removePastindex = 0;
        ArrayList<ArrayList<Integer>> intersection = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> alreadyTraveled = new ArrayList<ArrayList<Integer>>();//creates the already traveled arraylist
        ArrayList<ArrayList<Integer>> correctPath = new ArrayList<ArrayList<Integer>>();//creates the correct path array list
        correctPath.add( new ArrayList<Integer>() );
        correctPath.get(correctPath.size() - 1).add(movingLength);
        correctPath.get(correctPath.size() - 1).add(movingWidth);
        alreadyTraveled.add( new ArrayList<Integer>() );
        alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingLength);
        alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingWidth);
        int numberOfspaces = 0;

        while (movingLength != length || movingWidth != width) {
            if ((movingLength -1) >= 0 && maze[movingLength-1][movingWidth] == " ") {
                for (int i = 0; i < alreadyTraveled.size(); i++) {
                    if(alreadyTraveled.get(i).get(0) == (movingLength-1) && alreadyTraveled.get(i).get(1) == (movingWidth)) {
                        alreadyTraveledfound = true;
                    }
                }
                if (alreadyTraveledfound == false) {
                    numberOfspaces++;
                    upGood=true;
                }
                alreadyTraveledfound = false;
            }//if statement that searches for a space above
            if ((movingLength +1) <= length && maze[movingLength+1][movingWidth] == " ") {
                for (int i = 0; i < alreadyTraveled.size(); i++) {
                    if(alreadyTraveled.get(i).get(0) == (movingLength+1) && alreadyTraveled.get(i).get(1) == (movingWidth)) {
                        alreadyTraveledfound = true;
                    }
                }
                if (alreadyTraveledfound == false) {
                    numberOfspaces++;
                    downGood=true;
                }
                alreadyTraveledfound = false;
            }//if statement that searches for a space below
            if ((movingWidth -1) >= 0 && maze[movingLength][movingWidth - 1] == " ") {
                for (int i = 0; i < alreadyTraveled.size(); i++) {
                    if(alreadyTraveled.get(i).get(0) == (movingLength) && alreadyTraveled.get(i).get(1) == (movingWidth-1)) {
                        alreadyTraveledfound = true;
                    }
                }
                if (alreadyTraveledfound == false) {
                    numberOfspaces++;
                    leftGood=true;
                }
                alreadyTraveledfound = false;
            }//if statement that searches for a space left
            if ((movingWidth +1) >= 0 && maze[movingLength][movingWidth + 1] == " ") {
                for (int i = 0; i < alreadyTraveled.size(); i++) {
                    if(alreadyTraveled.get(i).get(0) == (movingLength) && alreadyTraveled.get(i).get(1) == (movingWidth+1)) {
                        alreadyTraveledfound = true;
                    }
                }
                if (alreadyTraveledfound == false) {
                    numberOfspaces++;
                    rightGood=true;
                }
                alreadyTraveledfound = false;
            }//if statement that searches for a space right
            if (numberOfspaces == 0) {
                if(intersection.get((intersection.size()-1)).get(0) == (movingLength) && intersection.get((intersection.size()-1)).get(1) == (movingWidth)) {
                    intersection.remove(intersection.size()-1);
                }//checks to see if the current coordinates are one of a intersection if it is get rid of it
                movingLength = intersection.get(intersection.size()-1).get(0);//sets the movingLength to the last known intersection
                movingWidth = intersection.get(intersection.size()-1).get(1);//sets the movingWidth to the last known intersection
                //removes everything past where the intersection you moved to from the correctPath arraylist
                for (int i = 0; i < correctPath.size(); i++) {
                    if (correctPath.get(i).get(0) == movingLength && correctPath.get(i).get(1) == movingWidth) {
                        removePastindex = i +1;
                    }
                }
                for (int i = removePastindex; i < correctPath.size(); removePastindex ++) {
                    correctPath.remove(i);
                }
            }
            else if (numberOfspaces == 1) {
                if(upGood == true) {
                    movingLength--;
                }
                else if(downGood == true) {
                    movingLength++;
                }
                else if(leftGood == true) {
                    movingWidth--;
                }
                else if (rightGood == true) {
                    movingWidth++;
                }
                correctPath.add( new ArrayList<Integer>() );
                correctPath.get(correctPath.size() - 1).add(movingLength);
                correctPath.get(correctPath.size() - 1).add(movingWidth);
                alreadyTraveled.add( new ArrayList<Integer>() );
                alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingLength);
                alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingWidth);
            }
            else {
                intersection.add( new ArrayList<Integer>() );
                intersection.get(intersection.size() - 1).add(movingLength);
                intersection.get(intersection.size() - 1).add(movingWidth);
                if(upGood == true) {
                    movingLength--;
                    correctPath.add( new ArrayList<Integer>() );
                    correctPath.get(correctPath.size() - 1).add(movingLength);
                    correctPath.get(correctPath.size() - 1).add(movingWidth);
                    alreadyTraveled.add( new ArrayList<Integer>() );
                    alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingLength);
                    alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingWidth);
                }
                else if(downGood == true) {
                    movingLength++;
                    correctPath.add( new ArrayList<Integer>() );
                    correctPath.get(correctPath.size() - 1).add(movingLength);
                    correctPath.get(correctPath.size() - 1).add(movingWidth);
                    alreadyTraveled.add( new ArrayList<Integer>() );
                    alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingLength);
                    alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingWidth);
                }
                else if(leftGood == true) {
                    movingWidth--;
                    correctPath.add( new ArrayList<Integer>() );
                    correctPath.get(correctPath.size() - 1).add(movingLength);
                    correctPath.get(correctPath.size() - 1).add(movingWidth);
                    alreadyTraveled.add( new ArrayList<Integer>() );
                    alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingLength);
                    alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingWidth);
                }
                else if (rightGood == true) {
                    movingWidth++;
                    correctPath.add( new ArrayList<Integer>() );
                    correctPath.get(correctPath.size() - 1).add(movingLength);
                    correctPath.get(correctPath.size() - 1).add(movingWidth);
                    alreadyTraveled.add( new ArrayList<Integer>() );
                    alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingLength);
                    alreadyTraveled.get(alreadyTraveled.size() - 1).add(movingWidth);
                }
            }//ends else statement handling the case of more than 1 space
            numberOfspaces = 0;
            upGood = false;
            downGood = false;
            leftGood = false;
            rightGood = false;
        }//exit of while statement to check if it is at the end
        //for loop to fill in the correctPath with check-marks
        for (int i = 0; i < correctPath.size(); i++) {
            maze[correctPath.get(i).get(0)][correctPath.get(i).get(1)] = "=";
        }
        //for loop to print out the maze after it is solved
        System.out.println("This is the maze after it is solved.");
        for (int i = 0; i < (length+ 2); i++) {
            for (int j = 0; j < (width+2); j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

}
