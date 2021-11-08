package com.example.memory;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class Playground extends AppCompatActivity {


    private Card[][] cards;
    private int whosOnTurn;
    private int[] score;



    public Playground()
    {


    }



    public void init(int nrCols, int nrRows, ImageButton[][] buttons)
    {

           createPairs(nrCols,nrRows,buttons);



    }

    @SuppressLint("ResourceType")
    private void createPairs(int nrCols, int nrRows, ImageButton[][] buttons)
    {

        /*
        TODO pärchen setzten
        */

        int id[] = randomMat(nrCols,nrRows);
        int ii = 0;

        for(int i = 1; i <= nrRows; i++)
        {
            for (int j = 1; j <= nrCols; j++)
            {
                ImageButton b = buttons[j][i];
            //Funkt nit
                b.setTag(R.id.cardId,id[ii]);
                ii+=1;

            }
        }


    }


private int[] randomMat (int nrCols, int nrRows)
{
    int[] randomMat = new int[(nrCols*nrRows)];
    for (int i = 0; i < nrCols*nrRows; i++)
    {

        randomMat[i]=(int)(Math.random() * (nrCols*nrRows - 0) + 1) + 0;
    }
    Collections.shuffle(Arrays.asList(randomMat));
    return randomMat;

}


    public Card play(Position pos)
    {
        return null;

    }

    public boolean finished()
    {
        return false;

    }

    @Override
    public String toString() {
        return "Playground [cards=" + Arrays.toString(cards) + ", whosOnTurn=" + whosOnTurn + ", score="
                + Arrays.toString(score) + ", getNrPairs=" + getNrPairs + ", finished()=" + finished() + ", getCards()="
                + Arrays.toString(getCards()) + ", getWhosOnTurn()=" + getWhosOnTurn() + ", getScore()="
                + Arrays.toString(getScore()) + ", getGetNrPairs()=" + getGetNrPairs() + ", getCard()=" + getCard()
                + "]";
    }

    public Card[][] getCards() {
        return cards;
    }

    public void setCards(Card[][] cards) {
        this.cards = cards;
    }

    public int getWhosOnTurn() {
        return whosOnTurn;
    }

    public void setWhosOnTurn(int whosOnTurn) {
        this.whosOnTurn = whosOnTurn;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public int getGetNrPairs() {
        return getNrPairs;
    }

    public void setGetNrPairs(int getNrPairs) {
        this.getNrPairs = getNrPairs;
    }

    public boolean isPair(Position pos1, Position pos2)
    {
        return false;

    }

    public Card getCard()
    {
        return null;

    }

    private int getNrPairs;
}
