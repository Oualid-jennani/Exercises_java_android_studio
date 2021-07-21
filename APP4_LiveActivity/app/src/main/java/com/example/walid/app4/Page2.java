package com.example.walid.app4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
    }

    public void btBACK(View view) {
        this.finish();
    }
}
