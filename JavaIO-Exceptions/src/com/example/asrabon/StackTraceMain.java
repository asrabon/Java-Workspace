package com.example.asrabon;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by asrab on 5/22/2017.
 */
public class StackTraceMain {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch(ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }
    }

    private static int divide() {
        int x,y;
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x/y;
//        } catch(NoSuchElementException e) {
//            throw new NoSuchElementException("No suitable input");
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("Attempt to divide by zero");
//        }
    }

    private static int getInt() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter an integer.");
        while(true) {
            try {
                return in.nextInt();
            } catch (InputMismatchException e) {
                in.nextLine();
                System.out.println("Please enter a number using only the digits 0-9");
            }
        }
    }
}
