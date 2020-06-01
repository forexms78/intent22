package com.example.intent2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class mult extends Activity {

    EditText txt;
    Button end;
    View.OnClickListener cl;
    int i1, i2, i3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mult);

        txt = (EditText) findViewById(R.id.text1);
        end = (Button) findViewById(R.id.end1);

       String s1, s2;
        int n1, n2, n3;
        Intent i;

        i = getIntent();
        s1 = i.getStringExtra("ee");
        s2 = i.getStringExtra("ff");
        n1 = Integer.parseInt(s1);
        n2 = Integer.parseInt(s2);
        n3 = n1 * n2;
        txt.setText("곱하기 =" + n3);

        i = getIntent();
        i1 = i.getIntExtra("ee",0);
        i2 = i.getIntExtra("ff",0);
        i3 = i1 * i2;
        txt.setText("곱하기=" + i3);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.end1 :
                        Intent ii;
                        ii = new Intent();
                        ii.putExtra("m_res", i3);
                        setResult(500, ii);
                        finish();
                        break;
                }
            }
        };
        end.setOnClickListener(cl);
    }
}
