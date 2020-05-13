package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.widget.EditText;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

//import static com.example.sudokusolver.SudokuActivity.machineSudokuSolver;
import static com.example.sudokusolver.SudokuActivity.sudokuSolver;

public class SolvedActivity extends AppCompatActivity {

    //Interpreter tflite;
    private EditText[][] editTextSolved;

    //= sudokuSolver.solveBoard(sudokuSolver.getBoard());;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solved);

        // ADDEd tensorflow
//        try {
//            tflite = new Interpreter(loadModelFile());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        editTextSolved = new EditText[9][9];

//        int[][] copyArray = new int[9][9];
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                copyArray[i][j] = sudokuSolver.getBoard()[i][j];
//            }
//        }


        //int[][] potentialSolution = doInference(machineSudokuSolver.getBoard());

        //trying out code
        displayBoard(sudokuSolver);


//        if(machineSudokuSolver.getManager().validateBoard(potentialSolution)) {
//            System.out.println("used AI");
//            displayMachineBoard(machineSudokuSolver);
//        } else {
//            sudokuSolver.solvedBoard = sudokuSolver.solveBoard(sudokuSolver.getBoard());
//            displayBoard(sudokuSolver);
//        }

    }

//    private boolean validateSolution(int[][] potentialSolution) {
//        return false;
//    }

    private void displayBoard(SudokuSolver sudokuSolver) {
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                String etID = "et" + i + j;
                int resID = getResources().getIdentifier(etID,"id", getPackageName());

                editTextSolved[i][j] = (EditText) findViewById(resID);
                String setVal = String.valueOf(sudokuSolver.getSolvedBoard()[i][j]);
                editTextSolved[i][j].setText(setVal);

            }
        }
    }

//    private void displayMachineBoard(SudokuSolver sudokuSolver) {
//        for (int i = 0; i < 9; i++) {
//            for(int j = 0; j < 9; j++) {
//
//                String etID = "et" + i + j;
//                int resID = getResources().getIdentifier(etID,"id", getPackageName());
//
//                editTextSolved[i][j] = (EditText) findViewById(resID);
//                String setVal = String.valueOf(sudokuSolver.getBoard()[i][j]);
//                editTextSolved[i][j].setText(setVal);
//
//            }
//        }
//    }


    // change appropriately depending on neural network
//    public int[][] doInference(int[][] arr) {
//        //input from model
//        double[][][] convertedArr = standardize(arr);
//
//
//        //output from model
//        double[][] outputVal = new double[81][1];
//        tflite.run(convertedArr, outputVal);
//
//        int[][] inferredVal = convertOutput(outputVal);
//        //read
//        //float inferredValue = outputVal[0][0];
//        return inferredVal;
//
//    }

//    private double[][][] standardize(int[][] arr) {
//        double[][][] result = new double[9][9][1];
//        for(int i = 0; i < 9; i++) {
//            for(int j = 0; j < 9; j++) {
//                double x = (double)arr[i][j];
//                result[i][j][0] = (x/9) - 0.5;
//            }
//        }
//        return result;
//    }
//
//    private int[][] convertOutput(double[][] arr) {
//        int[][] result = new int[9][9];
//        for(int i = 0; i < 81; i++) {
//            int p = i/9;
//            int q = i % 9;
//            result[p][q] = (int)arr[i][0];
//        }
//        return result;
//    }

    // ADDED tensorflow file
//    private MappedByteBuffer loadModelFile() throws IOException {
//        System.out.println("here in loadModelFile");
//        AssetFileDescriptor fileDescriptor = this.getAssets().openFd("TrainedSudoku.tflite");
//        System.out.println("Read files successfullt from path");
//        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
//        FileChannel fileChannel = inputStream.getChannel();
//        long startOffset = fileDescriptor.getStartOffset();
//        long declaredLength = fileDescriptor.getDeclaredLength();
//        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
//    }



}
