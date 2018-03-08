package com.company;

/**
 * Created by Sudipta Banik on 9/8/2017.
 */
public class Cell {
    int parent_x = -1,parent_y = -1;
    double f_value =Double.MAX_VALUE , g_value = Double.MAX_VALUE , h_value = Double.MAX_VALUE;

    Cell(int parent_x,int parent_y,double f_value,double g_value,double h_value){
        this.parent_x = parent_x;
        this.parent_y = parent_y;
        this.g_value = g_value;
        this.h_value = h_value;
        this.f_value = f_value;
    }
    Cell(){}

    public void setAll(int parent_x,int parent_y,double f_value,double g_value,double h_value){
        this.parent_x = parent_x;
        this.parent_y = parent_y;
        this.g_value = g_value;
        this.h_value = h_value;
        this.f_value = f_value;
    }
}
