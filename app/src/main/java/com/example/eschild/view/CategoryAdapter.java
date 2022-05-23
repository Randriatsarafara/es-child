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
import com.example.eschild.model.Categorie;
import com.example.eschild.utils.DownLoadImageTask;
import com.example.eschild.utils.Helper;

import java.util.List;

public class CategoryAdapter  extends ArrayAdapter<String> {
    Context context;
    List<Categorie> list;

    public static String [] title(List<Categorie> list){
        String[] res = new String[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i).getNom();
        }
        return res;
    }

    public CategoryAdapter(Context context,List<Categorie> list) {
        super(context, R.layout.activity_category,R.id.title_category,title(list));
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_category,parent,false);
        TextView vtitle = view.findViewById(R.id.title_category);
        TextView vdesc = view.findViewById(R.id.desc_category);
        ImageView vimage = view.findViewById(R.id.image_category);
        String [] image = {Helper.URL+"images/categories/"+list.get(position).getImage()};
        new DownLoadImageTask(vimage).execute(image);
        String nom = list.get(position).getNom();
        vtitle.setText(nom);
        vdesc.setText(list.get(position).getCourVue()+"/"+list.get(position).getCourTotal()+" Completed ");

        return view;
    }
}
