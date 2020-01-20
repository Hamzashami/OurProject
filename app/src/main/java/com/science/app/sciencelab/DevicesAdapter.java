package com.science.app.sciencelab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Item> deviceItems;

    DevicesAdapter(Context context, ArrayList<Item> deviceItems) {
        this.deviceItems = deviceItems;
        this.context= context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.device_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item d = deviceItems.get(position);
        holder.deviceNameTv.setText(d.getName());
        holder.devicePhotoIm.setImageResource(d.getImageId());

    }



    @Override
    public int getItemCount() {
        return deviceItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView deviceNameTv;
        ImageView devicePhotoIm;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            deviceNameTv = itemView.findViewById(R.id.deviceNameTv);
            devicePhotoIm = itemView.findViewById(R.id.devicePhotoIm);
        }
    }
    public void refresh(ArrayList<Item> items){
        this.deviceItems.clear();
        this.deviceItems.addAll(items);
        notifyDataSetChanged();
    }

}
