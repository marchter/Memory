package com.example.memory;

import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class Playground extends AppCompatActivity {


    public Card[][] cards;
    private int whosOnTurn;
    private int[] score;
    private int nrRows;



    public Playground()
    {



    }



    public void init(int nrCols, int nrRows)
    {
        cards = new Card[nrCols+1][nrRows+1];
        this.nrRows=nrRows;

        //o createPairs(nrCols,nrRows,buttons);
         //  createPairsID(nrCols,nrRows);

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
                    //o if ((buttons[j][i].getTag(R.id.cardId)).equals(ii) || (buttons[j][i].getTag(R.id.cardId)).equals(ii+1))
                    if (cards[j][i].getValue()==ii || cards[j][i].getValue()==ii+1){
                        //o buttons[j][i].setTag(R.id.cardId,cardId);
                        cards[j][i].setValue(cardId);
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
                // oImageButton b = buttons[j][i];
                //o b.setTag(R.id.cardId,id[ii]);
                try {
                    cards[j][i].setValue(id[ii]);

                }catch (NullPointerException e){
                    continue;
                }
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


    public Card play(Position pos)
    {
        Card c = cards[pos.x][pos.y];
        c.setVisible(true);
        return c;
    }

    public boolean finished()
    {
        for (int i = 0; i < nrRows; i++) {
            for (Card[] card: cards)
            {
                if (!card[i].isVisible()){
                    return false;
                }
            }
        }
        return true;
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

        if (cards[pos1.x][pos1.y].getValue()==cards[pos2.x][pos2.y].getValue()){
            return true;
        }
        return false;
    }


    public Card getCard(Position pos)
    {

        return cards[pos.x][pos.y];

    }

    private int getNrPairs;
}
