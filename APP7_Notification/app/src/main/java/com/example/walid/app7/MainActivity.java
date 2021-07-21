package com.example.walid.app7;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    NotificationManager noManager;
    static int Notification_id =1;
    public void addClick(View view) {
        NotificationCompat.Builder Nb = new NotificationCompat.Builder(this)
                .setContentTitle("Denger")
                .setContentText("The raining is coming soon")
                .setSmallIcon(R.drawable.twitter1);

        Intent resultIntent = new Intent(this,Page2.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        stackBuilder.addParentStack(Page2.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        Nb.setContentIntent(resultPendingIntent);
        Nb.addAction(R.drawable.read,"read it",resultPendingIntent);
        Nb.addAction(R.drawable.fb,"Link it",resultPendingIntent);




        noManager.notify(Notification_id,Nb.build());
        Notification_id++;
    }

    public void removeClick(View view) {
        noManager.cancelAll();
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    NewMessageNotification notF = new NewMessageNotification();
    public void addClick2(View view) {
        notF.notify(this,"Good morning",123);
        notF.notify(this,"Good after nood",124);
    }


    public void removeClick2(View view) {
        notF.cancel(this);
    }



}
