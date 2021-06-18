package com.example.radiokoubi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    //private ViewFlipper viewFlipper;
    private ImageView imageView;
    private Button showButton,contactButton,followButton,liveButton,downloadButton,homeButton,reminderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //int[] images = {R.drawable.bettermujib,R.drawable.campus,R.drawable.cloudy,R.drawable.coutre,
                //R.drawable.flower,R.drawable.justbuildings,R.drawable.minar,R.drawable.sunset};

        //viewFlipper = findViewById(R.id.view_id);
        imageView = findViewById(R.id.imageHome_id);

        //Finding Buttons
        //showButton = findViewById(R.id.nextShowsButton_id);
        contactButton = findViewById(R.id.contactButton_id);
        liveButton = findViewById(R.id.liveButton_id);
        followButton = findViewById(R.id.followButton_id);
        //homeButton = findViewById(R.id.homeButton_id);
        downloadButton = findViewById(R.id.downloadButton_id);
        reminderButton = findViewById(R.id.reminderButton_id);

        /*for(int image: images)
            flipperImages(image);*/

        listeners();

    }

    public void onBackPressed()
    {
        showAlertDialog();
    }

    /*public  void flipperImages(int image)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }*/

    public void listeners()
    {
        /*homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
                finish();
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NextShows.class));
                finish();
            }
        });*/

        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Contact.class));
                finish();
            }
        });

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebook("285334755271050");
            }
        });

        liveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Live.class));
                finish();
            }
        });

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Download.class));
                finish();
            }
        });

        reminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NotifyUsers.class));
                finish();
            }
        });

    }

    public void showAlertDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle(R.string.title);
        builder.setMessage(R.string.message);
        builder.setIcon(R.drawable.questionmark);

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    public void goToFacebook(String s)
    {
        try
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+s));
            startActivity(intent);
        }catch (ActivityNotFoundException e)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/"+s));
            startActivity(intent);
        }
    }
}
