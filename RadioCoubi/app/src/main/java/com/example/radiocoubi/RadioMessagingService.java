package com.example.radiokoubi;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class RadioMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public void showNotification(String title,String message)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"radionotifications")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.logo)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(555,builder.build());
    }
}
