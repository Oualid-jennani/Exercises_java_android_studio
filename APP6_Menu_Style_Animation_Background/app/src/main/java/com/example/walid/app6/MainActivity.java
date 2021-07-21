package com.example.walid.app6;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt ;
    int count=0;
    counter ct ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.txtcounter);
    }

    public void nextPage(View view) {
        Intent go = new Intent(this,Page2.class);
        startActivity(go);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_activity,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.googleplus){
            Toast.makeText(this,"you clicked button google plus",Toast.LENGTH_LONG).show();
        }
        if(id==R.id.whatsap){
            Toast.makeText(this,"you clicked button whatsap",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


    //---------------------------------------------------------------------------------------------


    public void starT(View view) {
        starTime();
    }

    public void stopT(View view) {
        ct.cancel();
        txt.setText("Stoped!");
    }

    public void starTime(){
        ct=new counter(10000,1000);
        ct.start();
    }

    public class counter extends CountDownTimer{

        public counter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            txt.setText(String.valueOf(count));
            count++;
        }

        @Override
        public void onFinish() {
            starTime();
        }
    }
}
