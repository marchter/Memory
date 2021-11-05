package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MemoryActivity extends AppCompatActivity {

    private static int[] pics;
    private Playground field;
    private Position previouseCard;
    private ImageButton[][] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    private void generateGrid(int nrCols, int nrRows)
    {

    }

    private void generateAndAddRows(int row, int nrCols)
    {

    }


    private ImageButton generateButton(Position pos)
    {
        return null;
    }


    private int[] getPicsArray(){
        return null;
    }


    public void onClick(View view)
    {

    }


    public void closeCards(Position pos1, Position pos2)
    {

    }
}