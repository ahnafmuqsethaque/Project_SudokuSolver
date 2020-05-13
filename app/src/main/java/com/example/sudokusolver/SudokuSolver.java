package com.example.sudokusolver;

import model.SudokuManager;

import java.util.ArrayList;
import java.util.*;


public class SudokuSolver {

    private int[][] board;
    public int[][] solvedBoard;
    public static final int BOARDWIDTH = 9;
    public static final int BOARDHEIGHT = 9;
    public SudokuManager manager;
    private ArrayList<int[][]> todo;



    public SudokuSolver(){
        board = new int[BOARDWIDTH][BOARDHEIGHT];
        solvedBoard = new int[BOARDWIDTH][BOARDHEIGHT];
        todo = new ArrayList<>();
        manager = new SudokuManager();

        // Initialize the board with zeros
        for(int row = 0; row < BOARDWIDTH; row++) {
            for(int col = 0; col < BOARDHEIGHT; col++) {
                board[row][col] = 0;
                solvedBoard[row][col] = 0;
            }
        }
    }


//    public int[][] solveBoard(int[][] board) {
//        if(manager.isComplete(board)) {
//            return board;
//        }
//
//        todo.addAll(manager.generateValidBoards(board));
//        return solveListOfBoards();
//    }
//
//    public int[][] solveListOfBoards() {
//        if (todo.size() == 0) {
//            return null; //no valid solution
//        }
//        int[][] temp = todo.get(0);
//        todo.remove(0);
//        return solveBoard(temp);
//    }

    public int[][] solveBoardv2(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                solvedBoard[i][j] = board[i][j]; //creating a copy of the initial board
            }
        }

        solvedBoard = manager.solveBoard(solvedBoard);
        return solvedBoard;
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
    public int[][] getSolvedBoard() {
        return solvedBoard;
    }

    public SudokuManager getManager() {
        return manager;
    }
}
