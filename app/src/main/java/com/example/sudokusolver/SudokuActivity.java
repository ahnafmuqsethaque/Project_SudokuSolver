package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.tensorflow.lite.Interpreter;


public class SudokuActivity extends AppCompatActivity {

    public static SudokuSolver sudokuSolver = new SudokuSolver();
    //public static SudokuSolver machineSudokuSolver = new SudokuSolver();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);

        final EditText editText[][] = new EditText[9][9];

        Button submitButton = (Button) findViewById(R.id.submitButton);
        Button resetButton = (Button) findViewById(R.id.resetButton);



        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < 9; i++) {
                    for(int j = 0; j < 9; j++) {

                        String etID = "et" + i + j;
                        int resID = getResources().getIdentifier(etID,"id", getPackageName());

                        editText[i][j] = (EditText) findViewById(resID);
                        editText[i][j].setText("");

                    }
                }
            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitButtonPressed(editText);
                Intent next = new Intent(SudokuActivity.this, SolvedActivity.class);
                startActivity(next);
            }
        });


    }

    private void onSubmitButtonPressed(EditText[][] editText) {

        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                String etID = "et" + i + j;
                int resID = getResources().getIdentifier(etID,"id", getPackageName());

                editText[i][j] = (EditText) findViewById(resID);
                int toPut = Integer.parseInt(editText[i][j].getText().toString());

                sudokuSolver.getBoard()[i][j] = toPut;
                //machineSudokuSolver.getBoard()[i][j] = toPut;
                /////pass in information to the next activity

            }
        }

        sudokuSolver.solveBoardv2(sudokuSolver.getBoard());

    }


}
