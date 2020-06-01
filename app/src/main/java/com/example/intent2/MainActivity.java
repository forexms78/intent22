package com.example.intent2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add, sub, mul, div;
    View.OnClickListener cl;
    Intent i;

    Double i1, i2, i3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.subtract);
        mul = (Button) findViewById(R.id.multiply);
        div = (Button) findViewById(R.id.division);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.add :
                        i = new Intent(getApplicationContext(), plus.class);
                        int n1, n2;
                        n1 = Integer.parseInt(num1.getText().toString());
                        n2 = Integer.parseInt(num2.getText().toString());
                        i.putExtra("aa", n1);
                        i.putExtra("bb", n2);
                        startActivity(i);
                        break;
                    case R.id.subtract :
                        i = new Intent(getApplicationContext(), minus.class);
                        i.putExtra("cc", num1.getText().toString());
                        i.putExtra("dd", num2.getText().toString());
                        startActivity(i);
                        break;
                    case R.id.multiply :
                        i = new Intent(getApplicationContext(), mult.class);
                        i.putExtra("ee", num1.getText().toString());
                        i.putExtra("ff", num2.getText().toString());
                        startActivity(i);

                    i = new Intent(getApplicationContext(), mult.class);
                    n1 = Integer.parseInt(num1.getText().toString());
                    n2 = Integer.parseInt(num2.getText().toString());
                    i.putExtra("ee", n1);
                    i.putExtra("ff", n2);
                    startActivityForResult(i, 50);
                    break;

                    case R.id.division :
                        i = new Intent(getApplicationContext(), division.class);
                        i1 = Double.parseDouble(num1.getText().toString());
                        i2 = Double.parseDouble(num2.getText().toString());//                        break;

                        i.putExtra("gg", i1);
                        i.putExtra("hh", i2);
                        startActivityForResult(i, 60);
                        break;
                }
            }
        };
        add.setOnClickListener(cl);
        sub.setOnClickListener(cl);
        mul.setOnClickListener(cl);
        div.setOnClickListener(cl);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == 50 ) {
            if ( resultCode == 500 ) {
                num1.setText("곱하기 결과=" + data.getIntExtra("m_res", 0));
            }
        }
        if ( requestCode == 60 ) {
            if ( resultCode == 600 ) {
                num1.setText("나누기 결과=" + data.getDoubleExtra("m_res1", 0));
            }
        }
    }
}

//putExtra 더블로 더블파스로 나누기(소숫점은)