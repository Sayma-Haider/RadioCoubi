package com.example.radiocoubi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Context.ALARM_SERVICE;


public class NxtShows extends Fragment {

    View view;

    Button reminderButton;

    public NxtShows() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.next_shows,container,false);

        reminderButton = view.findViewById(R.id.notififyButton_id);

        reminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlarm();
            }

        });

        return view;
    }

    private void startAlarm() {

        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(this.getContext(),AlarmReceiverClass.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getContext(),0,intent,0);

        alarmManager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+3000,pendingIntent);

        Toast.makeText(this.getContext(),"Reminder is set!",Toast.LENGTH_SHORT).show();
    }

}
