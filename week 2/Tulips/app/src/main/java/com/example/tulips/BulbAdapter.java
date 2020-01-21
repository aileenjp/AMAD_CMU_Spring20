package com.example.tulips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tulips.model.Bulb;
import com.example.tulips.sample.SampleData;

import java.util.List;

public class BulbAdapter extends RecyclerView.Adapter<BulbAdapter.ViewHolder> {
    private List<Bulb> mBulbs;
    private Context mContext;
    private ItemClickListener mItemClickListener;

    public interface ItemClickListener{
        void onItemClick(int position);
    }

    public BulbAdapter(List<Bulb> mBulbs, Context mContext, ItemClickListener mItemClickListener) {
        this.mBulbs = mBulbs;
        this.mContext = mContext;
        this.mItemClickListener = mItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView bulbTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bulbTextView = itemView.findViewById(R.id.textView);
            bulbTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mItemClickListener.onItemClick(getAdapterPosition());

        }
    }

    @NonNull
    @Override
    public BulbAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BulbAdapter.ViewHolder holder, int position) {
        Bulb bulb = mBulbs.get(position);
        holder.bulbTextView.setText(bulb.getName());
    }


    @Override
    public int getItemCount() {
        return mBulbs.size();
    }
}
