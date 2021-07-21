package com.example.walid.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button BTNAge = (Button) findViewById(R.id.Age);
        BTNAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BTNAge.setText("You Clecked my");
                GetAge();
            }
        });



        Button btn1 = (Button) findViewById(R.id.Btn1);
        Button btn2 = (Button) findViewById(R.id.Btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    public void CallAge(View view){
        GetAge();
    }

    public void GetAge(){
        EditText year = (EditText) findViewById(R.id.Year);
        int Age = 2018 - Integer.parseInt(year.getText().toString());
        Toast.makeText(this,"your age is :"+String.valueOf(Age),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.Btn1){
            Toast.makeText(this,"hello Btn1",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.Btn2){
            Toast.makeText(this,"hello Btn2",Toast.LENGTH_SHORT).show();
        }
    }
}
