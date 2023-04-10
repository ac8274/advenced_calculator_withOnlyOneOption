package com.example.advenced_calculator_withonlyoneoption;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import java.lang.Math;

import android.view.View;
import android.widget.TextView;

public class SHOW_RESULT extends AppCompatActivity {
    private double x_1 =0;
    private double x_2 =0;
    private int ok =0;
    private Intent gi = getIntent();;
    private TextView part1;
    private TextView part2;
    private TextView solution1;
    private TextView solution2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        part1 = findViewById(R.id.part1);
        part2 = findViewById(R.id.part2);
        solution1 = findViewById(R.id.solution1);
        solution2 = findViewById(R.id.solution2);
        gi = getIntent();
        double A = gi.getDoubleExtra("Ai",1);
        double B = gi.getDoubleExtra("Bi",1);
        double C = gi.getDoubleExtra("Ci",1);
        double part1_1 = (B*B)-(4*A*C);
        try {
            double square_root = Math.sqrt((double) part1_1);
            x_1 = (-1*B+square_root)/2.0;
            x_2 = (-1*B-square_root)/2.0;
            part1.setText("Part 1:\n"+B+"*"+B+" -4*"+A+"*"+C+" =\n"+B*B+" -"+-4*A*C+" = "+part1_1+"");
            part2.setText("Part 2:\n"+"square root("+part1_1+") = "+square_root+"");
            solution1.setText("Solution 1:\n" +"("+(-1*B)+" + "+square_root+")/2 = "+x_1);
            solution2.setText("Solution 2:\n" +"("+(-1*B)+" - "+square_root+")/2 = "+x_2);
        }
        catch(Exception e)
        {
            part1.setText("Part 1:\n"+B+"*"+B+" -4*"+A+"*"+C+" =\n"+B*B+" -"+-4*A*C+" = "+part1_1+"");
            part2.setText("Part 2:\n"+"square root("+part1_1+") = "+"Error can't square root negative >:(");
            ok = 1;
        }
    }

    public void Return(View view) {
        if(ok ==1)
        {
            gi.putExtra("n","Error");
        }
        else
        {
            gi.putExtra("n","Solutions: \n"+"1: "+x_1+"\n2: "+x_2);
        }
        setResult(RESULT_OK,gi);
        finish();
    }
}