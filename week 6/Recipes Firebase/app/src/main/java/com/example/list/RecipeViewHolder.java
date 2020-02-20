package com.example.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeViewHolder extends RecyclerView.ViewHolder{
    private TextView mTextView;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.textView);
    }

    public void setRecipeName(String name){
        mTextView.setText(name);
    }
}

