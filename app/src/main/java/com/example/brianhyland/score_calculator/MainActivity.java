package com.example.brianhyland.score_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int cpoints = 0;
    private TextView colourPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colourPoints = findViewById(R.id.col_points);

        Button b0_fixes = findViewById(R.id.b0_fixes);
        b0_fixes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cpoints = 150;
                updateView();
            }
        });

        Button b1_fixes = findViewById(R.id.b1_fixes);
        b1_fixes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cpoints = 75;
                updateView();
            }
        });

        Button b2_fixes = findViewById(R.id.b2_fixes);
        b2_fixes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cpoints = 50;
                updateView();
            }
        });

        Button b3_fixes = findViewById(R.id.b3_fixes);
        b3_fixes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cpoints = 0;
                updateView();
            }
        });

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cpoints = 0;
                updateView();
            }
        });

    }
    public void updateView(){
        colourPoints.setText(getString(R.string.colour_points, cpoints));
    }
}
