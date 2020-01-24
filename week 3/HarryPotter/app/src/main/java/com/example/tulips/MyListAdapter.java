package com.example.tulips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tulips.model.Character;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private List<Character> mCharacterList;
    private Context mContext;
    private ItemClickListener mItemClickListener;

    public interface ItemClickListener{
        void onItemClick(int position);
    }

    public MyListAdapter(List<Character> mCharacterList, Context mContext, ItemClickListener mItemClickListener) {
        this.mCharacterList = mCharacterList;
        this.mContext = mContext;
        this.mItemClickListener = mItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
            mTextView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        Character character = mCharacterList.get(position);
        holder.mTextView.setText(character.getName());
    }

    @Override
    public int getItemCount() {
        return mCharacterList.size();
    }
}
