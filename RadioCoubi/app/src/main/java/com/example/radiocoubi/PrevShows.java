package com.example.radiocoubi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PrevShows extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<OldShows> listShows;
    public PrevShows() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.previous_shows,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView_id);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),listShows);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listShows = new ArrayList<>();
        listShows.add(new OldShows("Campus Adda with RJ Shihab","8 to 10PM"));
        listShows.add(new OldShows("Campus Adda with RJ Annana","8 to 10PM"));
        listShows.add(new OldShows("Campus Adda with RJ Touhida","8 to 10PM"));
    }
}
