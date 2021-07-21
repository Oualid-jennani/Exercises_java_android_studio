package com.example.walid.app6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
    }

    int index;
    int[] TableIMG = new int[]{R.drawable.im1,R.drawable.im2,R.drawable.im3};

    public void btNext(View view) {
        ImageView pic = (ImageView) findViewById(R.id.imageView);
        pic.setImageResource(TableIMG[index]);
        index++;
        if(index==TableIMG.length){index=0;}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mymenu = getMenuInflater();
        mymenu.inflate(R.menu.menu_activity_2,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView txt =(TextView) findViewById(R.id.TXT);

        int id = item.getItemId();

        if(id==R.id.googleplus){
            txt.setText("Google plus");
        }
        if(id==R.id.whatsap){
            txt.setText("whatsap");
        }

        if(id==R.id.file){
            txt.setText("file");
        }

        return super.onOptionsItemSelected(item);
    }

}
