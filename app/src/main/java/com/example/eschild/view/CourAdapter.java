package com.example.eschild.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eschild.R;

public class CourAdapter extends  RecyclerView.Adapter<CourAdapter.ViewHolder> {
    Cour[] cour;
    Context context;
    public CourAdapter(Cour[] cour,CourActivity activity){
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
        final Cour cour_list = this.cour[position];
        holder.descCour.setText(cour_list.getDescription());
        holder.imageCour.setImageResource(cour_list.getImage());
        holder.titleCour.setText(cour_list.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                context.startActivity(intent);
                //Toast.makeText(context,cour_list.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.cour.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageCour;
        TextView titleCour;
        TextView descCour;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCour = itemView.findViewById(R.id.cour_image);
            titleCour = itemView.findViewById(R.id.cour_title);
            descCour = itemView.findViewById(R.id.cour_description);
        }
    }
}
