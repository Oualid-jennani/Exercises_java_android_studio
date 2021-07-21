package com.example.walid.app2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int ProgresState = 0;
    //------------------
    int year,month,day;
    EditText editDate;
    //------------------
    EditText editTime;
    int hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //---------------------------------------------------------------------------------------------------
        Button btnProgressDiaolog =  (Button) findViewById(R.id.BtnShowDialog);
        btnProgressDiaolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
            }
        });
        //---------------------------------------------------------------------------------------------------
        Button btnProgressBar =  (Button) findViewById(R.id.BtnBrogressBar);
        btnProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressBar();
            }
        });
        //---------------------------------------------------------------------------------------------------

        Button BtnAlert =  (Button) findViewById(R.id.Alert);
        BtnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        //---------------------------------------------------------------------------------------------------
        editDate =  (EditText) findViewById(R.id.editDate);
        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);

        editDate.setText(year+"-"+month+"-"+day);

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        //---------------------------------------------------------------------------------------------------
        editTime = (EditText)findViewById(R.id.editTime);

        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        editTime.setText(hour+":"+minute);

        editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });



    }



    //************************************************************************************************************************************************
    private void showProgressDialog() {
        ProgressDialog Pd = new ProgressDialog(this);
        Pd.setMessage("Loading Data ...");
        Pd.setCancelable(true);
        Pd.show();
    }
    //********************************************************
    private void showProgressBar() {
        final ProgressDialog Pb = new ProgressDialog(this);
        Pb.setMessage("Loading Data ...");
        Pb.setCancelable(false);
        Pb.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        Pb.setProgress(0);
        Pb.setMax(100);
        Pb.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ProgresState < 100){
                    ProgresState += 10;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Pb.setProgress(ProgresState);

                }

                if(ProgresState >= 100) Pb.dismiss();
            }
        }).start();

    }
    //********************************************************
    private void showAlertDialog() {
        AlertDialog.Builder builser = new AlertDialog.Builder(this);
        builser.setTitle("Exit")
                .setMessage("Click yes to exit !")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alert = builser.create();
        alert.show();
        /*
        AlertDialog alert2 = new AlertDialog.Builder(this).create();
        alert.setTitle("Error");
        alert.setMessage("Sorry, your device doesn't support flash light!");
        alert.setButton(Dialog.BUTTON_POSITIVE,"OK",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alert2.show();
        */
    }

    //********************************************************
    private void showDateDialog() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                editDate.setText(year+"-"+month+"-"+dayOfMonth);
            }
        };

        DatePickerDialog DpD = new DatePickerDialog(this,listener,year,month,day);
        DpD.show();
    }

    //********************************************************
    private void showTimeDialog() {
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                editTime.setText(hourOfDay+":"+minute);
            }
        };

        TimePickerDialog DtD = new TimePickerDialog(this,listener,hour,minute,false);
        DtD.show();
    }



}
