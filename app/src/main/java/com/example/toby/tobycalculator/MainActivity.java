package com.example.toby.tobycalculator;


import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.value;
import static com.example.toby.tobycalculator.R.id.button1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnAdd, btnSub, btnMult, btnDiv;
    private TextView tvResult;
    private EditText etFirst, etSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnAdd = (Button) findViewById(R.id.button1);
        btnSub = (Button) findViewById(R.id.button2);
        btnMult = (Button) findViewById(R.id.button3);
        btnDiv = (Button) findViewById(R.id.button4);
        etFirst = (EditText) findViewById(R.id.editText3);
        etSecond = (EditText) findViewById(R.id.editText4);
        tvResult = (TextView) findViewById(R.id.textView8);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        String num1 = etFirst.getText().toString();
        String num2 = etSecond.getText().toString();
        Intent i = new Intent(this, Main2Activity.class);
        switch(view.getId()){
            case R.id.button1:
                int addition = Integer.parseInt(num1) + Integer.parseInt(num2);
                i.putExtra("data", String.valueOf(addition));
                startActivity(i);

                break;
            case R.id.button2:
                int subtraction = Integer.parseInt(num1) - Integer.parseInt(num2);
                i.putExtra("data", String.valueOf(subtraction));
                startActivity(i);
                break;
            case R.id.button3:
                int multiplication = Integer.parseInt(num1) * Integer.parseInt(num2);
                i.putExtra("data", String.valueOf(multiplication));
                startActivity(i);
                break;
            case R.id.button4:
                try {
                    int division = Integer.parseInt(num1) / Integer.parseInt(num2);
                    i.putExtra("data", String.valueOf(division));
                    startActivity(i);
                }catch(Exception e){
                    i.putExtra("data", "Cannot divide by zero");
                    startActivity(i);
                }
                break;
        }
    }


}
