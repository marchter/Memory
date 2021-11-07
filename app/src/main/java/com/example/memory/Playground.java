package com.example.memory;

import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

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

    private void createPairs(int nrCols, int nrRows, ImageButton[][] buttons)
    {

        /*
        TODO pärchen setzten
        */



        Integer[] randomMat = new Integer[nrCols*nrRows];
        for (int i = 0; i < nrCols*nrRows; i++)
        {

            randomMat[i]=(int)(Math.random() * (nrCols*nrRows - 0) + 1) + 0;
            Log.d("asdf", randomMat[i].toString());
        }
        Collections.shuffle(Arrays.asList(randomMat));



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
