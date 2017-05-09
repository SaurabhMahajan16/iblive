package com.example.saurabh.iblive.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.adapter.PostAdapter;
import com.example.saurabh.iblive.appConstants.Constants;

import java.util.ArrayList;

/**
 * contains text view, to show viewpager works
 */

public class InnerRequestFragment extends Fragment implements Constants {
    private TextView tvChange;

    public static Fragment getInstance(int mode) {
        InnerRequestFragment innerfragment = new InnerRequestFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(String.valueOf(R.string.mode), mode);
        innerfragment.setArguments(bundle);
        return innerfragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_innerrequest_one, container, false);
        tvChange = (TextView) view.findViewById(R.id.tv_change);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int mode;
            mode = bundle.getInt(String.valueOf(R.string.mode));
            if (mode == MAPS) {
                tvChange.setText(getText(R.string.my_posts).toString());
                tvChange.setBackgroundResource(R.color.greeny_blue);
            } else if (mode == MYPOST) {
                tvChange.setText(getText(R.string.mynetwork).toString());
                tvChange.setBackgroundResource(R.color.colorPrimary);
            }
        }
        return view;
    }

    @Override
    public void myFunc() {

    }
}
