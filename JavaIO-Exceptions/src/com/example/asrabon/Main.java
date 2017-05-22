package com.example.asrabon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int x = 90;
//        int y = 0;
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFP(x,y));
//        System.out.println(divide(x,y));
        int x = getIntLBYL();
        System.out.println("x is " + x);
    }

    private static int getInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private static int getIntLBYL() {
        Scanner in = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter a integer.");
        String input = in.next();
        for(char c: input.toCharArray()) {
            if(!Character.isDigit(c)) {
                isValid = false;
            }
        }
        if(isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a integer");
        try {
            return in.nextInt();
        }catch (InputMismatchException e) {
            return 0;
        }
    }

    private static int divideLBYL(int x, int y) {
        if(y != 0) {
            return x/y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        try {
            return x/y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y) {
        return x/y;
    }
}
