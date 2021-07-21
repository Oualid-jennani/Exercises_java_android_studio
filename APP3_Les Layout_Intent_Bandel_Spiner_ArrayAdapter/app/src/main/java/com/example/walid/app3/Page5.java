package com.example.walid.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
    }

    public void GoPage6(View view) {

        Button GoPage6 = (Button) findViewById(R.id.GoPage6);
        final Intent Page6 = new Intent(this,Page6.class);

        GoPage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Page6);
            }
        });
    }
}
