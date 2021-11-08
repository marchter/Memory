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

    //asdfasdfasf
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





    private static int[] getPicsArray() {
        int[] c = new int[20];

        c[0] = R.drawable.i000;
        c[1] = R.drawable.i001;
        c[2] = R.drawable.i002;
        c[3] = R.drawable.i003;
        c[4] = R.drawable.i004;
        c[5] = R.drawable.i005;
        c[6] = R.drawable.i006;
        c[7] = R.drawable.i007;
        c[8] = R.drawable.i008;
        c[9] = R.drawable.i009;
        c[10] = R.drawable.i010;
        c[11] = R.drawable.i011;
        c[12] = R.drawable.i012;
        c[13] = R.drawable.i013;
        c[14] = R.drawable.i014;
        c[15] = R.drawable.i015;
        c[16] = R.drawable.i016;
        c[17] = R.drawable.i017;
        c[18] = R.drawable.i018;
        c[19] = R.drawable.i019;
        return c;
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


    public void play(Position pos, ImageButton[][] buttons)
    {
        //TODO fixen dass des mit Card geht!!(Lehrer fragen wie)
        buttons[pos.x][pos.y].setImageResource(getPicsArray()[(int) buttons[pos.x][pos.y].getTag(R.id.cardId)]);
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
