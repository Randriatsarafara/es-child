package com.example.eschild.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eschild.R;
import com.example.eschild.utils.DownLoadImageTask;
import com.example.eschild.utils.Helper;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class CourAdapter extends  RecyclerView.Adapter<CourAdapter.ViewHolder> {
    List<Cour> cour;
    Context context;
    public CourAdapter(List<Cour> cour,CourActivity activity){
        this.cour = cour;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cour_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Cour cour_list = (Cour)this.cour.get(position);
        holder.descCour.setText(cour_list.getSousTitre());
        String [] image = {Helper.URL+"images/cours/"+cour_list.getImage()};
        new DownLoadImageTask(holder.imageCour).execute(image);
        holder.titleCour.setText(cour_list.getTitle());
        holder.vue.setText(cour_list.getVueString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(HomeActivity.EXTRA_MESSAGE, cour_list.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.cour.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageCour;
        TextView titleCour;
        TextView descCour;
        TextView vue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCour = itemView.findViewById(R.id.cour_image);
            titleCour = itemView.findViewById(R.id.cour_title);
            descCour = itemView.findViewById(R.id.cour_description);
            vue = itemView.findViewById(R.id.cour_vu);
        }
    }
}
