package com.example.saurabh.iblive.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.appConstants.Constants;

import java.util.ArrayList;

/**
 * contains content recycler view in grid layout
 */

public class DiscoverGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        Constants {
private ArrayList<String> mpostList;


/**
 * @param mpostList arraylist of string type
 */
public DiscoverGridAdapter(final ArrayList<String> mpostList) {
        this.mpostList = mpostList;
        }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent,final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                discover_gridcontent, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        String places = mpostList.get(position);
        DiscoverGridAdapter.ViewHolder viewHolder = (DiscoverGridAdapter.ViewHolder) holder;
        viewHolder.tvplaces.setText(places);


    }

    @Override
    public int getItemCount() {
        return mpostList.size();
    }

    @Override
    public void myFunc() {

    }
    private class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvplaces;

        /**
         * constructor
         * @param itemView to access items
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvplaces = (TextView) itemView.findViewById(R.id.tv_city);

        }
    }
}
