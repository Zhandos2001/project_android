package com.example.wew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<MainData> dataArrayList;
    private Activity activity;


    //create constructor
    public MainAdapter(Activity activity, ArrayList<MainData> dataArrayList){

        this.activity = activity;
        this.dataArrayList = dataArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MainData data = dataArrayList.get(position);

        Glide.with(activity).load(data.getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
        // Glide.with(activity).load(data.getImage().into(holder.imageView);
        holder.textView.setText(data.getName());
        holder.textView1.setText(data.getBirthday());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity , DetailActivity.class);

                Bundle bundle = new Bundle();

                bundle.putString("img" ,data.getImage());
                bundle.putString("name" ,data.getName());
                bundle.putString("birthday" ,data.getBirthday());


                intent.putExtras(bundle);

                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
            textView1 = itemView.findViewById(R.id.text_view1);
            cardView = itemView.findViewById(R.id.main_layout);

        }
    }
}
