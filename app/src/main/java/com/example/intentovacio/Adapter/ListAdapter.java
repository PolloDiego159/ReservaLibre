package com.example.intentovacio.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intentovacio.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Viewholder> {
    ArrayList<ListAdapter> items;
    Context context;

    public ListAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView titleTex, Stock, Estado;
        ImageView pic;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            titleTex=itemView.findViewById(R.id.titleTex);
            Stock=itemView.findViewById(R.id.Stock);
            Estado=itemView.findViewById(R.id.Estado);
            pic=itemView.findViewById(R.id.pic);



        }
    }

}
