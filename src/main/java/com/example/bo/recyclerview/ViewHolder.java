package com.example.bo.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder{
    CircleImageView imageView;
    TextView name;
    RelativeLayout item;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        Log.e("Create Holder", "ViewHolder");
        imageView = itemView.findViewById(R.id.image);
        name = itemView.findViewById(R.id.image_name);
        item = itemView.findViewById(R.id.item);
    }
}
