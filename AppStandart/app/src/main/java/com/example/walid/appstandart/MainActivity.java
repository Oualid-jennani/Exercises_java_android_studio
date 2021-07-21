package com.example.walid.appstandart;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    RatingBar Rb;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//-----------------------------------------------------------------------------------------------
        Rb = (RatingBar) findViewById(R.id.ratingBar);
        txt = (TextView) findViewById(R.id.myResult);

        Rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txt.setText("Result : "+rating);
            }
        });

//-----------------------------------------------------------------------------------------------
        final CheckBox checkAndroid = (CheckBox) findViewById(R.id.checkAndroid);
        final CheckBox checkIOS = (CheckBox) findViewById(R.id.checkIOS);
        Button send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAndroid.isChecked()) Toast.makeText(MainActivity.this,"We love Android <3",Toast.LENGTH_SHORT).show();
                else if(checkIOS.isChecked())Toast.makeText(MainActivity.this,"Try Android :D",Toast.LENGTH_SHORT).show();
            }
        });
//-----------------------------------------------------------------------------------------------
        final RadioGroup RadioGroup = (RadioGroup) findViewById(R.id.radioG);
        Button send2 = (Button) findViewById(R.id.send2);

        send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedID = RadioGroup.getCheckedRadioButtonId();

                RadioButton SelectedRadio = (RadioButton) findViewById(selectedID);



                Toast.makeText(MainActivity.this,SelectedRadio.getText(),Toast.LENGTH_SHORT).show();
            }
        });
//-----------------------------------------------------------------------------------------------
        ToggleButton toggleBtn = (ToggleButton) findViewById(R.id.toggleBtn);
        final LinearLayout myLayout  = (LinearLayout) findViewById(R.id.myLayout);

        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    myLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }else{
                    myLayout.setBackgroundColor(Color.BLACK);
                }
            }
        });


    }

    public void goUser(View view) {
        Intent goSql = new Intent(this,sqlLite.class);
        startActivity(goSql);
    }
}
