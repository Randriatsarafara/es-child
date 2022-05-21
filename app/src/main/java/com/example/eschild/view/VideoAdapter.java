package com.example.eschild.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eschild.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class VideoAdapter extends  RecyclerView.Adapter<VideoAdapter.ViewHolder>{
    String [] videoId;
    Context context;
    public VideoAdapter(String [] id,VideoActivity activity){
        videoId = id;
        this.context = activity;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.video_item,parent,false);
        VideoAdapter.ViewHolder viewHolder = new VideoAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, final int position) {
        holder.video.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                // loading the selected video into the YouTube Player
                youTubePlayer.loadVideo(videoId[position], 0);
            }

            @Override
            public void onStateChange(@NonNull YouTubePlayer youTubePlayer,
                                      @NonNull PlayerConstants.PlayerState state) {
                // this method is called if video has ended,
                super.onStateChange(youTubePlayer, state);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.videoId.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        YouTubePlayerView video;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            video = itemView.findViewById(R.id.youtube_player_view);
        }
    }
}
