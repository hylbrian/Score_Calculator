package com.example.brianhyland.score_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int cpoints = 0;
    private int wbpoints = 0;
    private int nearBallPoints = 0;
    private int farBallPoints = 0;
    private int robotHomePoints = 0;


    private TextView colourPoints;
    private TextView wbPoints;
    private TextView totalPoints;
    private TextView nBallPoints;
    private TextView fBallPoints;
    private TextView rHomePoints;


    private EditText nearBallDistance;
    private EditText farBallDistance;
    private EditText robotHomeDistance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colourPoints = findViewById(R.id.col_points);
        wbPoints = findViewById(R.id.wbpoints);
        totalPoints = findViewById(R.id.total);

        nBallPoints = findViewById(R.id.nearball_points);
        fBallPoints = findViewById(R.id.farball_points);
        rHomePoints = findViewById(R.id.robothome_points);

        nearBallDistance = findViewById(R.id.nearball_distance);
        farBallDistance =  findViewById(R.id.farball_distance);
        robotHomeDistance = findViewById(R.id.robot_home_distance);

        Button update = findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nearBallPoints = Integer.parseInt(nearBallDistance.getText().toString());

                if(nearBallPoints <= 5){
                    nearBallPoints = 110;
                }else{
                    if(nearBallPoints <= 10){
                        nearBallPoints = 100;
                    }else{
                        if(nearBallPoints <= 20){
                            nearBallPoints = 80;
                        }else{
                            if(nearBallPoints <= 30){
                                nearBallPoints = 50;
                            }else{
                                if(nearBallPoints <= 45){
                                    nearBallPoints = 10;
                                }else{
                                    nearBallPoints = 0;
                                }
                            }
                        }
                    }
                }
                //nearBallPoints += 5;

                farBallPoints = Integer.parseInt(farBallDistance.getText().toString());
                farBallPoints += 5;

                robotHomePoints = Integer.parseInt(robotHomeDistance.getText().toString());
                //robotHomePoints += 5;
                if(robotHomePoints <= 5){
                    robotHomePoints = 110;
                }else{
                    if(robotHomePoints <= 10){
                        robotHomePoints = 100;
                    }else{
                        if(robotHomePoints <= 20){
                            robotHomePoints = 80;
                        }else{
                            if(robotHomePoints <= 30){
                                robotHomePoints = 50;
                            }else{
                                if(robotHomePoints <= 45){
                                    robotHomePoints = 10;
                                }else{
                                    robotHomePoints = 0;
                                }
                            }
                        }
                    }
                }


                //nBallPoints.setText(getString(R.string.near_ball_points, nearBallPoints));
                //colourPoints.setText(getString(R.string.colour_points, cpoints));

                updateView();
            }
        });



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
                wbpoints = 0;
                nearBallPoints = 0;
                farBallPoints = 0;
                robotHomePoints = 0;
                nearBallDistance.setText("");
                farBallDistance.setText("");
                robotHomeDistance.setText("");
                updateView();
            }
        });

        Button wbfailure = findViewById(R.id.wbfailure);
        wbfailure.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                wbpoints = 0;
                updateView();
            }
        });

        Button wbsuccess = findViewById(R.id.wbsuccess);
        wbsuccess.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                wbpoints = 60;
                updateView();
            }
        });
    }
    public void updateView(){
        colourPoints.setText(getString(R.string.colour_points, cpoints));
        wbPoints.setText(getString(R.string.wb_points, wbpoints));
        nBallPoints.setText(getString(R.string.near_ball_points, nearBallPoints));
        fBallPoints.setText(getString(R.string.far_ball_points, farBallPoints));
        rHomePoints.setText(getString(R.string.robot_home_points, robotHomePoints));
        totalPoints.setText(getString(R.string.points_total, wbpoints+cpoints+nearBallPoints+farBallPoints+robotHomePoints));



    }
}
