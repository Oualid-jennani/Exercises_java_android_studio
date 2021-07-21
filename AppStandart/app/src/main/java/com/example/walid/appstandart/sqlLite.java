package com.example.walid.appstandart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class sqlLite extends AppCompatActivity {

    DbSql db = new DbSql(this);
    EditText name , price,id;
    ListView LS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite);

        LS = (ListView) findViewById(R.id.ListMenu) ;

        name= (EditText) findViewById(R.id.name);
        price= (EditText) findViewById(R.id.price);
        id = (EditText)findViewById(R.id.idEtim);

        showdata();
    }

    public void funAdd(View view) {
        String N = name.getText().toString();
        float P = Float.parseFloat(price.getText().toString());


        Boolean result = db.insertMenuItem(N,P);

        if(result){
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            name.setText("");
            price.setText("");
            showdata();
        }
        else {
            Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show();
        }
    }

    public void showdata() {


        ArrayList<String> Menu = db.getAllMenuItems();

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.activity_list_item,Menu);

        LS.setAdapter(adapter);

    }

    public void FunEdit(View view) {
        String N = name.getText().toString();
        float P = Float.parseFloat(price.getText().toString());

        int idEtim = Integer.parseInt(id.getText().toString());

        Boolean result = db.updateMenuItem(idEtim,N,P);

        if(result){
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            name.setText("");
            price.setText("");
            showdata();
        }
        else {
            Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show();
        }


    }

    public void funDelete(View view) {
        id = (EditText)findViewById(R.id.idEtim);

        int idEtim = Integer.parseInt(id.getText().toString());

        db.deleteMenuItem(idEtim);
        showdata();
    }



}
