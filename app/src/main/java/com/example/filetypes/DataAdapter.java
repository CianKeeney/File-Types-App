package com.example.filetypes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private Context context;
    private int rowID;
    private File[] files;

    // Data Adapter Constructor
    public DataAdapter(Context context, int rowID, File[] files) {
        this.context = context;
        this.rowID = rowID;
        this.files = files;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(this.rowID, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Insert Data
        holder.name.setText(files[position].getImage());
        String file_image = files[position].getImage();
        Integer id = context.getResources().getIdentifier(file_image, "drawable", context.getPackageName());
        holder.file_picture.setImageResource(id);

        // Used for intent and bundling for other activities
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // switch to another activity
                Intent intent = new Intent(context, ActivityTwo.class);
                File file = files[holder.getAdapterPosition()];
                intent.putExtra("file_name", file.getName());
                intent.putExtra("file_image", file.getImage());
                intent.putExtra("file_description", file.getDescription());
                intent.putExtra("file_url", file.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return files.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView file_picture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.textView);
            this.file_picture = itemView.findViewById(R.id.imageView);
        }
    }
}
