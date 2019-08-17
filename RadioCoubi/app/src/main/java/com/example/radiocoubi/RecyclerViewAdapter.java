package com.example.radiocoubi;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    Context context;
    List<OldShows> showData;
    MediaPlayer mediaPlayer;

    public RecyclerViewAdapter(Context context, List<OldShows> showData) {
        this.context = context;
        this.showData = showData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        view = LayoutInflater.from(context).inflate(R.layout.single_show,viewGroup,false);

        final MyViewHolder myViewHolder = new MyViewHolder(view);


        myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pos = String.valueOf(myViewHolder.getAdapterPosition());

                Intent intent = new Intent(context, MediaPlayerInApp.class);
                intent.putExtra("play",pos);
                context.startActivity(intent);
                //finish();
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.showName.setText(showData.get(i).getShowName());
        myViewHolder.duration.setText(showData.get(i).getDuration());

        myViewHolder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, view);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.download:
                                Toast.makeText(context,"Coming soon",Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }

    //public void


    @Override
    public int getItemCount() {
        return showData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout linearLayout;
        Button buttonViewOption;
        TextView showName,duration;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.single_layout);
            showName = (TextView)itemView.findViewById(R.id.txtView_id);
            duration = (TextView) itemView.findViewById(R.id.txtView1_id);
            buttonViewOption = itemView.findViewById(R.id.optionsButton_id);
        }
    }
}
