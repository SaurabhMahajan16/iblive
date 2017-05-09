package com.example.saurabh.iblive.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.adapter.NetworkAdapter;

/**
 * Created by saurabh on 8/5/17.
 */

public class NetworkFragment extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_network, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_network);
        NetworkAdapter networkAdapter = new NetworkAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(networkAdapter);

        return view;
    }
}
