package ru.spbstu.telematics.java;

import java.util.Arrays;

public class ArrClass {
    int col;
    int row;
    int[][] arr;

    public ArrClass(int c_col, int c_row){
        col = c_col;
        row = c_row;
        arr = new int[c_col][c_row];
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

}
