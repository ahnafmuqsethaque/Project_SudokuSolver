package com.company;

import model.SudokuManager;

import java.util.ArrayList;

public class SudokuSolver {

    private int[][] board;
    public static final int BOARDWIDTH = 9;
    public static final int BOARDHEIGHT = 9;
    private SudokuManager manager;
    private ArrayList<int[][]> todo;


    public SudokuSolver(){
        board = new int[BOARDWIDTH][BOARDHEIGHT];
        todo = new ArrayList<>();
        manager = new SudokuManager();

        // Initialize the board with zeros
        for(int row = 0; row < BOARDWIDTH; row++) {
            for(int col = 0; col < BOARDHEIGHT; col++) {
                board[row][col] = 0;
            }
        }
    }

    public int[][] solveBoard(int[][] board) {
        if(manager.isComplete(board)) {
            return board;
        }

        todo.addAll(manager.generateValidBoards(board));
        return solveListOfBoards();
    }

    public int[][] solveListOfBoards() {
        if (todo.size() == 0) {
            return null; //no valid solution
        }
        int[][] temp = todo.get(0);
        todo.remove(0);
        return solveBoard(temp);
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
