package com.example.walid.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Page6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        final EditText n1 = (EditText) findViewById(R.id.N1);
        final EditText n2 = (EditText) findViewById(R.id.N2);
        final EditText res = (EditText) findViewById(R.id.REZ);

        Button Calcul = (Button) findViewById(R.id.btnRez);
        Calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int N1 = Integer.parseInt(n1.getText().toString());
                int N2 = Integer.parseInt(n2.getText().toString());

                res.setText(String.valueOf(N1+N2));

            }
        });
    }
}
