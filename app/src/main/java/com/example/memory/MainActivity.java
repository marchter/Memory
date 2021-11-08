package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static int[] pics;
    private Playground field;
    private Position previouseCard;

    int nrCols = 4;
    int nrRows = 4;
    int cardID = 1;

    private ImageButton[][] buttons = new ImageButton[nrCols+1][nrRows+1];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateGrid(nrCols,nrRows);
        field = new Playground();
        field.init(nrCols,nrRows,buttons);



    }


    private TableRow generateAndAddRows(int row,int nrCols)
    {

        TableRow.LayoutParams tableRowParams= new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT);
        TableRow tr = new TableRow(this);

            for (int i = 1; i <= nrCols; i++) {

                tr.setLayoutParams(tableRowParams);
                Position p = new Position(i,row);
                ImageButton button = generateButton(p);
                buttons[p.x][p.y] = button;
                tr.addView(button);

            }
        return tr;
    }

    private void generateGrid(int nrCols, int nrRows)
    {
        TableLayout playField = findViewById(R.id.cardTable);

        for (int i = 1; i <= nrRows; i++)
        {
            TableRow tr = generateAndAddRows(i,nrCols);
            playField.addView(tr);
        }
    }


    private ImageButton generateButton(Position p)
    {
        ImageButton b = new ImageButton(this);
        b.setImageResource(R.drawable.back);

        String tag = p.x+","+p.y;
        b.setTag(R.id.position,tag);

        b.setTag(R.id.pair,"notpair");

        b.setId(cardID);
        cardID +=1;

        b.setOnClickListener(this);
        return b;
    }




    public void onClick(View view)
    {

        String position = view.getTag(R.id.position).toString();
        String ispair = view.getTag(R.id.pair).toString();
        int ButtonID = view.getId();
        String cardIdPair = view.getTag(R.id.cardId).toString();


          String[] posi = position.split(",");
          Position p = new Position(Integer.valueOf(posi[0]),Integer.valueOf(posi[1]));
          field.play(p,buttons);

        Snackbar snackbar = Snackbar.make(view, "Card "+position+" is clicked and is "+ispair+" and has number " + ButtonID + " and has cardID " + cardIdPair, Snackbar.LENGTH_LONG);
        snackbar.show();



    }


    private void closeCards(Position pos1, Position pos2)
    {
        class CloseTask extends TimerTask
        {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    buttons[pos1.x][pos1.y].setImageResource(R.drawable.back);
                    buttons[pos2.x][pos2.y].setImageResource(R.drawable.back);
                });
            }
        }

        Timer timer = new Timer();
        timer.schedule(new CloseTask(),1000);
    }
}