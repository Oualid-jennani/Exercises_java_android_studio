package com.example.walid.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String log = getResources().getString(R.string.Login);
        String[] job = getResources().getStringArray(R.array.jobs);
    }

    public void StarLogin(View view) {
        EditText Name = (EditText)findViewById(R.id.name);
        EditText Passw = (EditText)findViewById(R.id.pasw);

        Intent GOpage3 = new Intent(this,com.example.walid.app3.Page3.class);

        Bundle b = new Bundle();
        b.putString("username",Name.getText().toString());
        b.putString("password",Passw.getText().toString());

        GOpage3.putExtras(b);
        //or
        //GOpage3.putExtra("username",Name.getText().toString());
        //GOpage3.putExtra("Password",Passw.getText().toString());


        startActivity(GOpage3);
    }
}
