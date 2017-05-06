package com.example.asrabon.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asrab on 5/5/2017.
 */
public class Series {

    public static int nSum(int n) {
        return ((n*(n+1))/2);
    }

    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static int fibonacci(int n) {
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            do {
                int size = fibonacci.size();
                fibonacci.add(fibonacci.get(size-1) + fibonacci.get(size-2));
            } while(fibonacci.size()-1 != n);
        }
        return fibonacci.get(fibonacci.size()-1);
    }

}
