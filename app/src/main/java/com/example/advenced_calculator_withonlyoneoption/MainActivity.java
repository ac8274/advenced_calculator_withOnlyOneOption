package com.example.advenced_calculator_withonlyoneoption;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Random_button;
    private Button Result_button;
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView Result_text;
    private EditText inputA;
    private EditText inputB;
    private EditText inputC;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random_button = findViewById(R.id.Random_button);
        Result_button= findViewById(R.id.Result_button);
        A = findViewById(R.id.A);
        B = findViewById(R.id.B);
        C = findViewById(R.id.C);
        Result_text = findViewById(R.id.Result_text);
        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        inputC = findViewById(R.id.inputC);
    }

    public void Randomize(View view) {
        Random rand = new Random();
        inputA.setText(""+rand.nextInt(100));
        inputB.setText(""+rand.nextInt(100));
        inputC.setText(""+rand.nextInt(100));
    }

    public void Ori_Brain_Activate(View view) {
        Intent si = new Intent(this,SHOW_RESULT.class);
        si.putExtra("Ai", Double.parseDouble(inputA.getText().toString()));
        si.putExtra("Bi", Double.parseDouble(inputB.getText().toString()));
        si.putExtra("Ci", Double.parseDouble(inputC.getText().toString()));
        startActivityForResult(si,1);


    }
    protected void onActivityResult(int source, int good, @Nullable Intent data) {
        super.onActivityResult(source, good, data);
        if (data != null) {
            Result_text.setText(data.getStringExtra("n"));
        }
    }
}