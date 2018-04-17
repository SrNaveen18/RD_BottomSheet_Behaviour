package com.example.naveen.designprt.business;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.naveen.designprt.MainActivity;
import com.example.naveen.designprt.R;
import com.example.naveen.designprt.Second;

import java.util.List;


public class Adapter1 extends RecyclerView.Adapter<ViewHolder1> {
    private List<String> list;
    private MainActivity mainActivity;

    public Adapter1(MainActivity mainActivity, List<String> list) {
        this.list = list;
        this.mainActivity = mainActivity;
    }

    public Adapter1(Second second, List<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adp1, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder1 holder, int position) {
        //   Glide.with(mainActivity).load(list.get(0)).centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ViewHolder1 extends RecyclerView.ViewHolder {
    ImageView imageView;

    ViewHolder1(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
