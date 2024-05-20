package com.example.intentovacio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.intentovacio.Domain.ListDomain;
import com.example.intentovacio.Helper.ChangeCodeItemsListener;

import com.example.intentovacio.R;

import java.util.ArrayList;

public class ReservaListAdapter extends RecyclerView.Adapter<ReservaListAdapter.ViewHolder> {
    ArrayList<ListDomain> listItemSelected;

    ChangeCodeItemsListener changeCodeItemsListener;

    public ReservaListAdapter(ArrayList<ListDomain> listItemSelected, Context context, ChangeCodeItemsListener changeCodeItemsListener) {
        this.listItemSelected = listItemSelected;

        this.changeCodeItemsListener = changeCodeItemsListener;
    }

    @NonNull
    @Override
    public ReservaListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_reservas_list, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservaListAdapter.ViewHolder holder, int position) {
        holder.title.setText(listItemSelected.get(position).getTitle());
        holder.code.setText(listItemSelected.get(position).getTitle());

        int drawableResourceId = holder. itemView.getContext().getResources()
                .getIdentifier(listItemSelected.get(position).getPicUrl(), "drawable", holder.itemView.getContext().getOpPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,30,30))
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return listItemSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, code;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleTex);
            code=itemView.findViewById(R.id.Codigo);
            pic=itemView.findViewById(R.id.pic);
        }
    }
}
