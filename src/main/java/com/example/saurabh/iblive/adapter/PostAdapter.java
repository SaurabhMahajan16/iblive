package com.example.saurabh.iblive.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.appConstants.Constants;

import java.util.ArrayList;

/**
 * recycler view adapter
 */

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Constants {
    private ArrayList<String> mpostList;
    private int mMode;

    /**
     * @param mMode     mode
     * @param mpostList arraylist of string type
     */
    public PostAdapter(final int mMode, final ArrayList<String> mpostList) {
        this.mMode = mMode;
        this.mpostList = mpostList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (mMode == DISCOVER || mMode ==MYPOST){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_discover,
                    parent, false);
            return new ViewHolder(view);}
        else {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.
                        discover_gridcontent, parent, false);

                return new ViewHolder(view);
            }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String places = mpostList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        if (mMode == DISCOVER) {
            viewHolder.tvLocationIcon.setText(places);
            viewHolder.tvEditIcon.setVisibility(View.GONE);
            viewHolder.checkBox.setVisibility(View.GONE);
            viewHolder.btnSendRequest.setVisibility(View.GONE);
    }
        else if (mMode == MYPOST) {
            viewHolder.tvEditIcon.setCompoundDrawablesRelativeWithIntrinsicBounds(0,
                    0, R.drawable.icon_edit, 0);
            viewHolder.tvLocationIcon.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    R.drawable.icon_trash, 0, 0, 0);

        }
        else{
            viewHolder.tvplace.setText(places);
        }
    }
    @Override
    public int getItemCount() {
      return mpostList.size();
    }

    @Override
    public void myFunc() {

    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox;
        private TextView tvEditIcon, tvLocationIcon, tvplace;
        private Button btnSendRequest;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.cb_postFragment);
            tvEditIcon = (TextView) itemView.findViewById(R.id.tv_editicon);
            tvLocationIcon = (TextView) itemView.findViewById(R.id.tv_location_icon);
            btnSendRequest = (Button) itemView.findViewById(R.id.btn_sendrequest);
           tvplace = (TextView) itemView.findViewById(R.id.tv_city);
        }
    }


}
