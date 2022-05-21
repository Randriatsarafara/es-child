package com.example.eschild.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eschild.R;

public class VideoTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.tab_activity_video, parent, false);

        RecyclerView recyclerView = root.findViewById(R.id.list_video);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        String [] c = new String[]{"2Y2vuuFderY","2Y2vuuFderY"};

        VideoAdapter adapter = new VideoAdapter(c,new VideoActivity());
        recyclerView.setAdapter(adapter);
        return root;
    }
}
