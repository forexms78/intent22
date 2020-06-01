package com.example.intent2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class plus extends Activity {

    EditText res;
    Button end;
    View.OnClickListener cl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus);

        res = (EditText) findViewById(R.id.result);
        end = (Button) findViewById(R.id.end);

        int a,b,c;
        Intent i;
        i = getIntent();
        a = i.getIntExtra("aa", -1);
        b = i.getIntExtra("bb", -2);
        c = a + b;
        res.setText("합계 = " + c);

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
