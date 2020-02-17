package com.company;

import java.util.ArrayList;
import java.util.*;


public class SudokuSolver {

    private int[][] board;
    private static final int BOARDWIDTH = 9;
    private static final int BOARDHEIGHT = 9;



    public SudokuSolver(){
    board = new int[BOARDWIDTH][BOARDHEIGHT];

        // Initialize the board with zeros
    for(int row = 0; row < BOARDWIDTH; row++) {
        for(int col = 0; col < BOARDHEIGHT; col++) {
           board[row][col] = 0;
        }
    }

    }

    public void insert(int row, int col, int val) {
        board[row][col] = val;
    }

    public static int getBOARDWIDTH() {
        return BOARDWIDTH;
    }

    public static int getBOARDHEIGHT() {
        return BOARDHEIGHT;
    }

    public int[][] getBoard() {
        return board;
    }
}
