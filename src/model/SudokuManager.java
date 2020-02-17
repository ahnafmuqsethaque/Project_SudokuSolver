package model;

import exceptions.InvalidBoardException;

public class SudokuManager {


    // PRE: None
    // EFFECTS: returns true if the board is valid, false otherwise
    public boolean validateBoard(int[][] board) {
        try {
            checkRows(board);
            checkCols(board);
            checkSquares(board);

        } catch (InvalidBoardException e) {
            return false;
        }
        return true;
    }

    // PRE: None
    // EFFECTS: Checks that no rows of the board contain duplicates, throws an exception if duplication exists
    public void checkRows(int[][] board) throws InvalidBoardException {
        for (int i = 0; i < 9; i ++){ //TODO: use static variable
            checkCombination(board[i]);
        }
    }

    //PRE: None
    //EFFECTS: Checks that the consumed combination is valid, throws an excpetion if duplication exists
    public void checkCombination(int[] board) throws InvalidBoardException {
        for (int i = 0; i < 9-1; i++) {
            for (int j = i+1; j < 9; j++) {
                if (board[i] == board[j]) {
                    throw new InvalidBoardException();
                }
            }
        }
    }

    //PRE: None
    //EFFECTS: Throws an exception if any columns contains duplicates
    public void checkCols(int[][] board) throws InvalidBoardException {
        for (int j = 0; j < 9; j++) {
            int[] temp = new int[9]; //TODO: replace with static variable

            for (int i = 0; i < 9; i++) {
                temp[i] = board[i][j];
            }

            checkCombination(temp);
        }
    }

    //PRE: None
    //EFFECTS: throws an exception if any squares contain duplicates
    public void checkSquares(int[][] board) throws InvalidBoardException {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j+= 3) {
                int rowIndex = i;
                int colIndex = j;
                int colMax = colIndex + 3;
                int[] temp = new int[9];
                int length = 0;
                while (length < 9) {
                    temp[length] = board[rowIndex][colIndex];
                    length++;
                    colIndex++;
                    if (colIndex >= colMax) {
                        colIndex = j;
                        rowIndex++;
                    }
                }
                checkCombination(temp);
            }
        }
    }


    // PRE: The board is valid
    // EFFECTS: returns true is the board is solved (has no zeros), false otherwise
    public boolean isComplete(int[][] board) {
        for (int i = 0; i < 9; i++) {  //TODO: Replace 9 with the static variable;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
