package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer(sc.nextLine());
        Sentence s = new Sentence(sb);
        s.replaceFirstAndLastWords();
        s.printSentence();
    }
}
