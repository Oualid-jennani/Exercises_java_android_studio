package com.example.walid.appstandart;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    Context context;
    int res;




    public UserAdapter(@NonNull Context context,@LayoutRes int resource, @NonNull ArrayList<User> objects) {
        super(context, resource, objects);
        this.context=context;
        this.res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(res,parent,false);

        TextView txtName = (TextView) convertView.findViewById(R.id.idName);

        TextView txtFone = (TextView) convertView.findViewById(R.id.idJob);

        User currentUser = getItem(position);

        txtName.setText(currentUser.getFirstname()+" "+currentUser.getLastname());
        txtFone.setText(currentUser.getFhone());


        return convertView;


    }
}
