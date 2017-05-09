package com.example.saurabh.iblive.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.iblive.R;

/**
 * Created by saurabh on 8/5/17.
 */

public class NetworkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.network_recyclercontent, parent, false);


        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        NetworkAdapter.ViewHolder viewHolder = (NetworkAdapter.ViewHolder) holder;
        if (position == 0){

            viewHolder.view.setBackgroundResource(R.drawable.recyclerview_upper_row);
        }
        else if (position == 9){
            viewHolder.view.setBackgroundResource(R.drawable.recyclerview_lower_row);
        }
        else{
            viewHolder.view.setBackgroundResource(R.drawable.recyclerview_middle_rows);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }
    }
}
