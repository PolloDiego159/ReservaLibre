package com.example.intentovacio.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.intentovacio.Activity.DetailActivity;
import com.example.intentovacio.Domain.ListDomain;
import com.example.intentovacio.R;



import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Viewholder> {
    ArrayList<ListDomain> items;
    Context context;

    public ListAdapter(ArrayList<ListDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pop_list, parent,false);
        context=parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder (@NonNull ListAdapter.Viewholder holder, int position) {

        holder.titleTex.setText(items.get(position).getTitle());
        holder.Stock.setText(items.get(position).getStock());
        holder.Estado.setText(items.get(position).getEstado());

        int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).transform(new GranularRoundedCorners(30,30,0,0)).into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object", items.get(position));
            holder.itemView.getContext().startActivity(intent);

        });

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
