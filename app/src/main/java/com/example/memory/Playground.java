package com.example.memory;

import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;

import javax.sql.ConnectionPoolDataSource;

public class Playground extends AppCompatActivity {


    private Card[][] cards;
    private int whosOnTurn;
    private int[] score;

    public Playground(int x, int y)
    {
        init(x,y);

    }



    public void init(int nrCols, int nrRows)
    {

        createPairs(nrCols,nrRows);

    }

    private void createPairs(int nrCols, int nrRows)
    {

        //TODO pärchen setzten

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
