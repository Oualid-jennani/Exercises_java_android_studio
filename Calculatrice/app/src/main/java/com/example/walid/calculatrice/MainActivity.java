package com.example.walid.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {


    TextView display ;

    String op;
    double number1,number2;
    double r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display) ;

        Button btn0 = (Button) findViewById(R.id.btn1);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button adition = (Button) findViewById(R.id.aditioan);
        Button sustraction = (Button) findViewById(R.id.sustraction);
        Button division = (Button) findViewById(R.id.division);
        Button multip = (Button) findViewById(R.id.multip);
        Button egal = (Button) findViewById(R.id.egal);
        Button AC = (Button) findViewById(R.id.ac);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        adition.setOnClickListener(this);
        sustraction.setOnClickListener(this);
        division.setOnClickListener(this);
        multip.setOnClickListener(this);
        egal.setOnClickListener(this);
        AC.setOnClickListener(this);



    }



    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.poin:
                display.setText(display.getText()+".");
                break;

            case R.id.btn0:
                display.setText(display.getText()+"0");
                break;

            case R.id.btn1:
                display.setText(display.getText()+"1");
                break;

            case R.id.btn2:
                display.setText(display.getText()+"2");
                break;

            case R.id.btn3:
                display.setText(display.getText()+"3");
                break;

            case R.id.btn4:
                display.setText(display.getText()+"4");
                break;

            case R.id.btn5:
                display.setText(display.getText()+"5");
                break;

            case R.id.btn6:
                display.setText(display.getText()+"6");
                break;

            case R.id.btn7:
                display.setText(display.getText()+"7");
                break;

            case R.id.btn8:
                display.setText(display.getText()+"8");
                break;

            case R.id.btn9:
                display.setText(display.getText()+"9");
                break;

            case R.id.aditioan:
                op="+";
                number1 = Double.parseDouble(display.getText().toString());
                display.setText("");
                break;

            case R.id.sustraction:
                op="-";
                number1 = Double.parseDouble(display.getText().toString());
                display.setText("");
                break;

            case R.id.division:
                op="/";
                number1 = Double.parseDouble(display.getText().toString());
                display.setText("");
                break;

            case R.id.multip:
                op="*";
                number1 = Double.parseDouble(display.getText().toString());
                display.setText("");
                break;

            case R.id.ac:
                display.setText("");
                op="";
                break;

            case R.id.egal:

                number2 = Double.parseDouble(display.getText().toString());

                if(op=="+"){
                    r=number1+number2;
                }
                else if(op=="-"){
                    r=number1-number2;
                }
                else if(op=="/"){
                    r=number1/number2;
                }
                else if(op=="*"){
                    r=number1*number2;
                }

                display.setText(Double.toString(r));
                break;

        }


    }
}
