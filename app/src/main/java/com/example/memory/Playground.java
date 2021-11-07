package com.example.memory;

import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;

import javax.sql.ConnectionPoolDataSource;

public class Playground extends AppCompatActivity {


    private Card[][] cards;
    private int whosOnTurn;
    private int[] score;

    public Playground()
    {


    }



    public void init(int nrCols, int nrRows, ImageButton[][] buttons)
    {

        createPairs(nrCols,nrRows, buttons);

    }

    private void createPairs(int nrCols, int nrRows, ImageButton[][] buttons)
    {

        /*
        TODO pärchen setzten
        NOTE besser wärs mit Tag vom Button zu lösen  !!UMBEDINGT PROBIEREN
        */
        int[] randomx = new int[2];
        int[] randomy = new int[2];

        for (int i = 0; i < randomx.length; i++)
        {
            for (int j = 0; j < randomy.length; j++)
            {
                randomy[j] = (int) (Math.random() * (nrRows - 1) + 1);

            }
            randomx[i] = (int) (Math.random() * (nrCols - 1) + 1);

        }
        if (randomy[0]==randomy[1])
        {
            createPairs(nrCols,nrRows,buttons);
        }else{
            //funkt aber nit mit ID
            //buttons[randomx[0]][randomy[0]].setImageResource(R.drawable.i000);
            //buttons[randomx[1]][randomy[1]].setImageResource(R.drawable.i000);

            //Mit ID probieren
            ImageButton simpleImageButton = (ImageButton)findViewById();
            simpleImageButton.setImageResource(R.drawable.i000);

        }




            int posx= (int) (Math.random() * (nrCols - 1) + 1);
            int posy= (int) (Math.random() * (nrCols - 1) + 1);








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
