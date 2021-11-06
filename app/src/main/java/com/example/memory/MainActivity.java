package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static int[] pics;
    private Playground field;
    private Position previouseCard;
    private ImageButton[][] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateGrid(4,4);

    }



    private void generateGrid(int nrCols, int nrRows)
    {

        TableLayout table = findViewById(R.id.cardTable);

        for (int i = 1; i <= nrRows;i++)
        {
            TableRow row = new TableRow(this);
            for (int j = 1; j <= nrCols; j++)
            {
                Button b = new Button(this);
                b.setGravity(Gravity.CENTER_HORIZONTAL);
                b.setTag(new Point(i,j));
                b.setText(String.format("(%d,%d)", i,j));
                b.setOnClickListener((View.OnClickListener) this);
                row.addView(b);
            }
            table.addView(row);
        }


    }



    private void generateAndAddRows(int row, int nrCols)
    {

    }


    private ImageButton generateButton(Position pos)
    {
        ImageButton b = new ImageButton(this);
        b.setImageResource(R.drawable.i000);
        b.setTag(pos);
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
        Point p = (Point)view.getTag();
        String pStr = p.x + " , " + p.y;

    }


    private void closeCards(Position pos1, Position pos2)
    {
        class CloseTask extends TimerTask
        {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    buttons[pos1.y][pos1.x].setImageResource(R.drawable.back);
                    buttons[pos2.y][pos2.x].setImageResource(R.drawable.back);
                });
            }
        }

        Timer timer = new Timer();
        timer.schedule(new CloseTask(),1000);
    }
}