package com.example.radiocoubi;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private Button showButton,aboutButton,contactButton,followButton,liveButton;
    int[] images={R.drawable.bettermujib,R.drawable.bjustbuildings,R.drawable.campus,R.drawable.cloudy,
            R.drawable.coutre,R.drawable.flower,R.drawable.minar,R.drawable.sunset};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewFlipper = findViewById(R.id.view_id);

        //Finding Buttons
        showButton = findViewById(R.id.showsButton_id);
        contactButton = findViewById(R.id.contactButton_id);
        liveButton = findViewById(R.id.liveButton_id);
        followButton = findViewById(R.id.followButton_id);

        for(int i=0;i<images.length;i++)
        {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            viewFlipper.addView(imageView);
        }

        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);


        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);

        viewFlipper.setFlipInterval(5000);

        viewFlipper.setAutoStart(true);

        listeners();

    }

    public void onBackPressed()
    {
        showAlertDialog();
    }

    public void listeners()
    {
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Shows.class));
                finish();
            }
        });

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
