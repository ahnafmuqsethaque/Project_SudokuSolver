package com.company;
//import
public class ThrowawayMain {
    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();


        //insert bunch of jargon
        int k = 0;
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                sudokuSolver.getBoard()[row][col] = k;
                k++;
            }

        }

        // write your code here
        printBoard(sudokuSolver);
    }

    public static void printBoard(SudokuSolver sudokuSolver) {
//        int gap = 0;
//        if (gap % 3 == 0) {
//            for(int k = 0; k < 37; k++) {
//                System.out.print("-");
//            }
//        }
        for(int k = 0; k < 37; k++) {
            System.out.print("-");
        }
        System.out.println("");

        for(int i = 0; i < sudokuSolver.getBOARDWIDTH(); i++) {
            for(int j = 0; j < sudokuSolver.getBOARDHEIGHT(); j++) {
                System.out.print("| " + sudokuSolver.getBoard()[i][j] + " ");
            }
            System.out.println("|\n");

        }

        for(int k = 0; k < 37; k++) {
            System.out.print("-");
        }
    }
}
