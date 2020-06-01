package com.example.intent2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;


public class minus extends Activity {
    EditText txt;
    Button end;

    View.OnClickListener cl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minus);

        txt = (EditText) findViewById(R.id.text);
        end = (Button) findViewById(R.id.end);

        String s1,s2;
        int n1, n2, n3;
        Intent i;

        i = getIntent();
        s1 = i.getStringExtra("cc");
        s2 = i.getStringExtra("dd");
        n1 = Integer.parseInt(s1);
        n2 = Integer.parseInt(s2);
        n3 = n1 - n2;
        txt.setText("빼기 = " + n3);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.end :
                        finish();
                        break;
                }
            }
        };
        end.setOnClickListener(cl);
    }
}
