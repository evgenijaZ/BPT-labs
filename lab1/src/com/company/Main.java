package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Function f = new Function();
        Scanner in = new Scanner(System.in);
        System.out.println("Input m:");
        int m = in.nextInt();
        System.out.println("Input n:");
        int n = in.nextInt();
        System.out.println("Result: " + f.Calculate(m,n));

    }
}
