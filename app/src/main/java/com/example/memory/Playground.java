package com.example.memory;

import android.util.Log;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class Playground extends AppCompatActivity {


    public Card[][] cards;
    private int whosOnTurn;
    private int[] score = new int[3];
    private int nrRows;
    private int nrCols;


    public Playground()
    {



    }



    public void init(int nrCols, int nrRows)
    {
        cards = new Card[nrCols+1][nrRows+1];
        this.nrRows=nrRows;
        this.nrCols=nrCols;

        int cnt = 1;
        for(int i = 1; i <= nrRows; i++)
        {
            for(int j = 1; j <= nrCols; j++)
            {
                    cards[j][i] = new Card();
                    cards[j][i].setValue(cnt);
                    cards[j][i].setVisible(false);
                    cnt++;
            }
        }

        createPairs(nrCols,nrRows);


    }




    private void createPairs(int nrCols, int nrRows)
    {

        createPairsID(nrCols,nrRows);
        for (int i = 1; i <= nrRows; i++)
        {
            for (int j = 1; j <= nrCols; j++)
            {
                int cardId = 0;
                for (int ii = 1; ii <= nrCols*nrRows; ii+=2) {
                    if (cards[j][i].getValue()==ii || cards[j][i].getValue()==ii+1){
                        cards[j][i].setValue(cardId);
                        Log.d("asdf",String.valueOf(cards[j][i].getValue()));
                    }
                cardId++;
                }

            }

        }


    }




    private void createPairsID(int nrCols, int nrRows)
    {

        int ii=0;
        Integer[] id = randomMat(nrCols, nrRows);
        for (int i = 1; i <= nrRows; i++)
        {
            for (int j = 1; j <= nrCols; j++)
            {
                cards[j][i].setValue(id[ii]);
                ii++;
            }
        }




    }


    private Integer[] randomMat (int nrCols, int nrRows)
    {

        Integer[] arr = new Integer[((nrCols*nrRows))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        Collections.shuffle(Arrays.asList(arr));

        return arr;

    }


    public boolean finished()
    {
        for (int i = 1; i <= nrRows; i++) {
            for (int j = 1; j <= nrCols; j++) {
                if (!cards[j][i].isVisible()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPair(Position pos1, Position pos2)
    {

        if (cards[pos1.x][pos1.y].getValue()==cards[pos2.x][pos2.y].getValue()){
            return true;
        }
        return false;
    }



    public int getWhosOnTurn() {
        return whosOnTurn;
    }

    public void setWhosOnTurn(int whosOnTurn) {
        this.whosOnTurn = whosOnTurn;
    }

    public int getScore(int player) {
        return score[player];
    }

    public void setScore(int player, int score) {
        this.score[player] = score;
    }

    public int getNrPairs() {
        return getNrPairs;
    }

    public void setNrPairs(int getNrPairs) {
        this.getNrPairs = getNrPairs;
    }



    public Card getCard(Position pos)
    {

        return cards[pos.x][pos.y];

    }

    private int getNrPairs;
}
