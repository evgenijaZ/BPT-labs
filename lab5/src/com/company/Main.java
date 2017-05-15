package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album Disc = new Album();
        Disc.add("Don't Stop", "pop", 215);
        Disc.add("Let's not pretended", "rock", 230);
        Disc.add("Mister,Mister", "indie", 215);
        Disc.add("I am", "rock", 203);
        Disc.add("Heaven", "pop", 225);

        //  System.out.println("Total length in ms:"+Disc.totalLength());
        int h = Disc.totalLength() / 3600;
        int m = (Disc.totalLength() % 3600) / 60;
        int s = Disc.totalLength() % 60;
        System.out.println("Total length: " + h + 'h' + m + 'm' + s + 's');

        Disc.sort();
        System.out.println("Sorted by genre album :");
        for (int i = 0; i < Disc.size(); i++) {
            Song t = Disc.get(i);
            t.print();
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the search range in ms: ");
        int a = in.nextInt();
        int b = in.nextInt();

        if (Disc.search(a, b).size() == 0) {
            System.out.println("Not found");
        } else {
            for (int i = 0; i < Disc.getSearchResult().size(); i++)
                Disc.getSearchResult(i).print();
        }
    }
}

