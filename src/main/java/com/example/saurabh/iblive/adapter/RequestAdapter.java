package com.example.saurabh.iblive.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.appConstants.Constants;

/**
 * contains maps posts networks
 */

public class RequestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        Constants {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.request_recycler_content,
                        parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return NETWORK;
    }

    @Override
    public void myFunc() {

    }
    private class ViewHolder extends RecyclerView.ViewHolder
    {
        /**
         *
         * @param itemView to access items
         */
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
