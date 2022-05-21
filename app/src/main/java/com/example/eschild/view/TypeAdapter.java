package com.example.eschild.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.eschild.R;

public class TypeAdapter extends ArrayAdapter<String> {
    Context context;

    public TypeAdapter(Context context) {
        super(context, R.layout.activity_type);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_type,parent,false);

        ImageView image = view.findViewById(R.id.type_image);
        TextView title = view.findViewById(R.id.type_title);
        image.setImageResource(R.drawable.childlogo);
        title.setText("Carton");

        return view;
    }
}