package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


    public static int[] getPicsArray() {
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


    public void onClick(View view)
    {

        String tag = view.getTag(R.id.position).toString();
        String tagset = view.getTag(R.id.pair).toString();
        int cardID = view.getId();
        String randomID = view.getTag(R.id.cardId).toString();


        String[] poss = view.getTag(R.id.position).toString().split(",");
        Position pos = new Position( Integer.parseInt(poss[0]) , Integer.parseInt(poss[1]));
        field.play(pos, buttons);

        Snackbar snackbar = Snackbar.make(view, "Card "+tag+" is clicked and is "+tagset+" and has number " + cardID + " and has randomNR " + randomID, Snackbar.LENGTH_LONG);
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