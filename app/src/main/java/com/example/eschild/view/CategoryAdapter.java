package com.example.eschild.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.eschild.R;

public class CategoryAdapter  extends ArrayAdapter<String> {
    Context context;
    String title [];
    String desc [];

    public CategoryAdapter(Context context, String[] title, String[] desc) {
        super(context, R.layout.activity_category,R.id.title_category,title);
        this.context = context;
        this.title = title;
        this.desc = desc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_category,parent,false);
        TextView vtitle = view.findViewById(R.id.title_category);
        TextView vdesc = view.findViewById(R.id.desc_category);

        vtitle.setText(title[position]);
        vdesc.setText(desc[position]+" Completed");

        return view;
    }
}
