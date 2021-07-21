package com.example.walid.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Page3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        TextView txtInfo = (TextView)findViewById(R.id.TextINFO);

        Bundle b = getIntent().getExtras();

        String name =  b.getString("username");
        String Passw =  b.getString("password");

        txtInfo.setText("User : " + name + "     Password : " + Passw);

        Button go = (Button) findViewById(R.id.Go);
        final Intent Page5 = new Intent(this,Page5.class);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Page5);
            }
        });


        //-----------------------------------------------------------------------------------
        Spinner sp = (Spinner)findViewById(R.id.spinner1);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String nameIten = parent.getItemAtPosition(position).toString();
                Toast.makeText(Page3.this, nameIten, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Page3.this, "", Toast.LENGTH_SHORT).show();
            }
        });

        //-----------------------------------------------------------------------------------
        //add items in java code

        Spinner sp2 = (Spinner)findViewById(R.id.spinner2);
        ArrayList<String> myarray = new ArrayList<>();
        myarray.add("Element 1");
        myarray.add("Element 2");
        myarray.add("Element 3");
        myarray.add("Element 4");
        myarray.add("Element 5");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myarray);
        sp2.setAdapter(adapter);

    }
}
