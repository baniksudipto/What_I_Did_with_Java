package com.company;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Sudipta Banik on 9/8/2017.
 */

class GridMap {
    private int row, col;
    private PriorityQueue<Triplet> openList = new PriorityQueue<>((o1, o2) -> (int) (o1.f_value - o2.f_value));
    private boolean[][] closedList = null;
    int[][] gridDetails = null;
    private Pair startingPoint = null;
    private Pair destinationPoint = null;

    GridMap(int _row, int _col) {
        this.row = _row;
        this.col = _col;
        gridDetails = new int[row][col];
        closedList = new boolean[row][col];
        for (int i = 0; i < row; i++) for (int j = 0; j < col; j++) closedList[i][j] = false;
    }

    void scanGrid(Scanner sc) {
        if (sc == null) sc = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                gridDetails[i][j] = sc.nextInt();
            }
        }
    }

    private void tracePath(Cell[][] cellDetails) {
        int r = destinationPoint.First;
        int c = destinationPoint.Second;
        int t_x, t_y;
        Stack<Pair> stack = new Stack<>();

        while (!(cellDetails[r][c].parent_x == r && cellDetails[r][c].parent_y == c)) {
            stack.push(new Pair(r, c));
            t_x = cellDetails[r][c].parent_x;
            t_y = cellDetails[r][c].parent_y;
            r = t_x;
            c = t_y;
        }

        System.out.println("The Path To Destination :\n");
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            System.out.print("[ " + top.First + " ][ " + top.Second + " ] ");
            if (!stack.isEmpty()) System.out.print(" -> ");
        }
    }

    boolean searchPath() {

        if (startingPoint == null || destinationPoint == null || gridDetails == null || startingPoint == destinationPoint
                || !isValid(startingPoint.First, startingPoint.Second) || !isValid(destinationPoint.First, destinationPoint.Second) ||
                !isFree(startingPoint.First, startingPoint.Second) || !isFree(destinationPoint.First, destinationPoint.Second)) {
            return false;
        }
        Cell[][] cellDetails = new Cell[this.row][this.col];
        for (int i = 0; i < row; i++) for (int j = 0; j < col; j++) cellDetails[i][j] = new Cell();

        Triplet startingCell = new Triplet(0, startingPoint.First, startingPoint.Second);
        cellDetails[startingPoint.First][startingPoint.Second].setAll(startingPoint.First, startingPoint.Second, 0, 0, 0);
        Triplet top = null;
        openList.add(startingCell);
        while (!openList.isEmpty()) {
            top = openList.poll();
            int i = top.x;
            int j = top.y;
            closedList[i][j] = true;
            double tempG, tempH, tempF;
            if (isValid(i - 1, j)) {
                if (isDestination(i - 1, j)) {
                    cellDetails[i - 1][j].parent_x = i;
                    cellDetails[i - 1][j].parent_y = j;
                    System.out.print("The destination cell is found\n");
                    tracePath(cellDetails);
                    break;
                } else if (isFree(i - 1, j) && !closedList[i - 1][j]) {
                    tempG = cellDetails[i][j].g_value + 1.0;
                    tempH = H_cost(i - 1, j);
                    tempF = tempG + tempH;

                    if (cellDetails[i - 1][j].f_value > tempF) {
                        openList.add(new Triplet(tempF, i - 1, j));
                        cellDetails[i - 1][j].setAll(i, j, tempF, tempG, tempH);
                    }
                }
            }
            if (isValid(i + 1, j)) {
                if (isDestination(i + 1, j)) {
                    cellDetails[i + 1][j].parent_x = i;
                    cellDetails[i + 1][j].parent_y = j;
                    System.out.print("The destination cell is found\n");
                    tracePath(cellDetails);
                    break;
                } else if (isFree(i + 1, j) && !closedList[i + 1][j]) {
                    tempG = cellDetails[i][j].g_value + 1.0;
                    tempH = H_cost(i + 1, j);
                    tempF = tempG + tempH;

                    if (cellDetails[i + 1][j].f_value > tempF) {
                        openList.add(new Triplet(tempF, i + 1, j));
                        cellDetails[i + 1][j].setAll(i, j, tempF, tempG, tempH);
                    }
                }
            }
            if (isValid(i, j + 1)) {
                if (isDestination(i, j + 1)) {
                    cellDetails[i][j + 1].parent_x = i;
                    cellDetails[i][j + 1].parent_y = j;
                    System.out.print("The destination cell is found\n");
                    tracePath(cellDetails);
                    break;
                } else if (isFree(i, j + 1) && !closedList[i][j + 1]) {
                    tempG = cellDetails[i][j].g_value + 1.0;
                    tempH = H_cost(i, j + 1);
                    tempF = tempG + tempH;

                    if (cellDetails[i][j + 1].f_value > tempF) {
                        openList.add(new Triplet(tempF, i, j + 1));
                        cellDetails[i][j + 1].setAll(i, j, tempF, tempG, tempH);
                    }
                }
            }
            if (isValid(i, j - 1)) {
                if (isDestination(i, j - 1)) {
                    cellDetails[i][j - 1].parent_x = i;
                    cellDetails[i][j - 1].parent_y = j;
                    System.out.print("The destination cell is found\n");
                    tracePath(cellDetails);
                    break;
                } else if (isFree(i, j - 1) && !closedList[i][j - 1]) {
                    tempG = cellDetails[i][j].g_value + 1.0;
                    tempH = H_cost(i, j - 1);
                    tempF = tempG + tempH;

                    if (cellDetails[i][j - 1].f_value > tempF) {
                        openList.add(new Triplet(tempF, i, j - 1));
                        cellDetails[i][j - 1].setAll(i, j, tempF, tempG, tempH);
                    }
                }
            }

        }

        return true;
    }

    void setStartingPoint(int _x, int _y) {
        startingPoint = new Pair(_x, _y);
    }

    void setDestinationPointPoint(int _x, int _y) {
        destinationPoint = new Pair(_x, _y);
    }

    private double H_cost(int x1, int y1) {
        return Math.abs(x1 - destinationPoint.First) + Math.abs(y1 - destinationPoint.Second);
    }

    private boolean isValid(int x, int y) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }

    private boolean isFree(int x, int y) {
        return gridDetails[x][y] == 1;
    }

    private boolean isDestination(int _x, int _y) {
        return _x == destinationPoint.First && _y == destinationPoint.Second;
    }
}
