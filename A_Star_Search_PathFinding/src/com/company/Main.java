package com.company;

/**
 * Created by Sudipta Banik on 9/8/2017.
 */
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Grid size N x M : \n followed by the grid denoted by 1 and 0(inaccessible  cells)");
        int row = sc.nextInt();
        int col = sc.nextInt();
        GridMap game = new GridMap(row, col);

        game.scanGrid(sc);
        System.out.println("Set starting Point : (1 based indexing ) ");
        game.setStartingPoint(sc.nextInt()-1, sc.nextInt()-1);
        System.out.println("Set destination Point : (1 based indexing ) ");
        game.setDestinationPointPoint(sc.nextInt()-1, sc.nextInt()-1);
        game.searchPath(); // function searching the path and printing it if found

        /*
Sample Dataset
4 7
1 1 1 0 0 0 0
1 1 1 0 1 1 1
0 1 1 0 1 0 1
0 0 1 1 1 0 1
1 1
4 7

         */
    }
}
