package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input text:");
        StringBuffer sb = new StringBuffer(sc.nextLine());
        Text s = new Text(sb);
        System.out.println("Result is:");
        s.replaceFirstAndLastWords();
        s.printText();
    }
}
