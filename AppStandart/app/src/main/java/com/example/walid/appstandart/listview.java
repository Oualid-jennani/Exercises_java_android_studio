package com.example.walid.appstandart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listview extends AppCompatActivity {

    ListView lsv , listu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lsv = (ListView) findViewById(R.id.lsv);

        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = parent.getItemAtPosition(position).toString();

                Toast.makeText(listview.this,selectedItem,Toast.LENGTH_SHORT).show();

            }
        });

        listu = (ListView) findViewById(R.id.listusers);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("walid","jennani","0635316658"));
        users.add(new User("alae","jennani","00000000000"));
        users.add(new User("oumayma","jennani","000000000"));
        users.add(new User("anas","saidi","0635316658"));
        users.add(new User("youssef","mossawi","555555555555"));

        UserAdapter adapter = new UserAdapter(this,R.layout.item_user,users);

        listu.setAdapter(adapter);

    }
}
