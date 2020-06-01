package com.example.intent2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class division extends Activity {
    EditText txt;
    Button end2;
    View.OnClickListener cl;
    Double i1, i2, i3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.division);

        txt = (EditText) findViewById(R.id.text2);
        end2 = (Button) findViewById(R.id.end2);

        Intent i;
        i = getIntent();
        i1 = i.getDoubleExtra("gg",0);
        i2 = i.getDoubleExtra("hh",0);
        i3 = i1 / i2;
        txt.setText("나누기=" + i3);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.end2 :
                        Intent ii;
                        ii = new Intent();
                        ii.putExtra("m_res1", i3);
                        setResult(600, ii);
                        finish();
                        break;
                }
            }
        };
        end2.setOnClickListener(cl);
    }
}
