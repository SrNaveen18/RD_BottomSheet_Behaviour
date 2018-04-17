package com.example.naveen.designprt.business;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.naveen.designprt.MainActivity;
import com.example.naveen.designprt.R;
import com.example.naveen.designprt.Second;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<ViewHolder2>{
    private List<String> list;
    private MainActivity mainActivity;

    public Adapter2(MainActivity mainActivity, List<String> list) {
        this.list=list;
        this.mainActivity=mainActivity;
    }

    public Adapter2(Second second, List<String> list) {
        this.list=list;
    }

    @Override
    public ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adap2,parent,false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder2 holder, int position) {
     //   Glide.with(mainActivity).load(list.get(0)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ViewHolder2 extends RecyclerView.ViewHolder{
     ImageView imageView;

     ViewHolder2(View itemView) {
        super(itemView);
        imageView=(ImageView)itemView.findViewById(R.id.imageView);
    }
}