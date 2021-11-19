package com.example.memory;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
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

    private void createPairs(int nrCols, int nrRows, ImageButton[][] buttons)
    {

        createPairsID(nrCols,nrRows,buttons);
        for (int i = 1; i <= nrRows; i++)
        {
            for (int j = 1; j <= nrCols; j++)
            {
                int cardId = 0;
                for (int ii = 1; ii <= nrCols*nrRows; ii+=2) {
                    if ((buttons[j][i].getTag(R.id.cardId)).equals(ii) || (buttons[j][i].getTag(R.id.cardId)).equals(ii+1))
                    {
                        buttons[j][i].setTag(R.id.cardId,cardId);
                    }
                cardId++;
                }

            }

        }


    }




    private void createPairsID(int nrCols, int nrRows, ImageButton[][] buttons)
    {

        int ii=0;

        Integer[] id = randomMat(nrCols, nrRows);
        for (int i = 1; i <= nrRows; i++)
        {

            for (int j = 1; j <= nrCols; j++)
            {
                ImageButton b = buttons[j][i];
                b.setTag(R.id.cardId,id[ii]);
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


    public Card play(Position pos, ImageButton[][] buttons)
    {
        //TODO fixen dass des mit Card geht!!(Lehrer fragen wie)
        //buttons[pos.x][pos.y].setImageResource(getPicsArray()[(int) buttons[pos.x][pos.y].getTag(R.id.cardId)]);
        Card c = new Card();
        c.setValue(MainActivity.getPicsArray()[(int) buttons[pos.x][pos.y].getTag(R.id.cardId)]);
        return c;
    }

    public boolean finished()
    {
        return false;

    }

    @Override
    public String toString() {
     return "";
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

    public Card getCard(Position pos)
    {

        Card c = new Card();



        return c;

    }

    private int getNrPairs;
}
