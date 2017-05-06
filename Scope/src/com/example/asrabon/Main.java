package com.example.asrabon;

public class Main {

    public static void main(String[] args) {
        String privateVar = "this is private to main()";

        ScopeCheck scopeCheck = new ScopeCheck();
        System.out.println("scopeInstance privateVar is " + scopeCheck.getPrivateVar());
        System.out.println(privateVar);

        scopeCheck.timesTwo();
    }
}
