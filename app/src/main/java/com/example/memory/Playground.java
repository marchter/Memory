package com.example.memory;

import android.util.Log;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
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

        for (int i = 0; i <(nrCols*nrRows); i+=2)
        {
           createPairs(nrCols+1,nrRows+1,buttons);

        }


    }

    private void createPairs(int nrCols, int nrRows, ImageButton[][] buttons)
    {

        /*
        TODO pärchen setzten
        NOTE besser wärs mit Tag vom Button zu lösen  !!UMBEDINGT PROBIEREN
        */

        int randomx1 = getRandomx(nrCols).get(0);
        int randomy1 = getRandomy(nrRows).get(0);

        int randomx2 = getRandomx(nrCols).get(1);
        int randomy2 = getRandomy(nrRows).get(1);


        if (buttons[randomx1][randomy1].getTag(R.id.pair).toString()!="set" && buttons[randomx2][randomy2].getTag(R.id.pair).toString()!="set")
        {
            buttons[randomx1][randomy1].setImageResource(R.drawable.i001);
            buttons[randomx1][randomy1].setTag(R.id.pair,"set");

            buttons[randomx2][randomy2].setImageResource(R.drawable.i001);
            buttons[randomx2][randomy2].setTag(R.id.pair,"set");
        }
        if (randomx1==randomx2&&randomy1==randomy2)
        {
            Log.d("asdf","asdfsafd");
            buttons[randomx1][randomy1].setImageResource(R.drawable.i004);
            buttons[randomx1][randomy1].setTag(R.id.pair,"set");

            buttons[randomx2][randomy2].setImageResource(R.drawable.i004);
            buttons[randomx2][randomy2].setTag(R.id.pair,"set");
        }

    }



    private ArrayList<Integer> getRandomx(int nrCols)
    {
        //TODO checkn wie ma mit araylists umgeht "Index oout of B"
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 20) {

            int random = randomGenerator .nextInt(20);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
    }

    private ArrayList<Integer> getRandomy(int nrRows)
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 20) {

            int random = randomGenerator .nextInt(20);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
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
