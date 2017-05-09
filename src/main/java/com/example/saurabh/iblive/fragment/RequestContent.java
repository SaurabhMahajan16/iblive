package com.example.saurabh.iblive.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.adapter.PostAdapter;
import com.example.saurabh.iblive.adapter.RequestAdapter;

/**
 * contains recycler view in request fragment.
 */

public class RequestContent extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request_recycler, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_requests);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RequestAdapter requestAdapter = new RequestAdapter();
        recyclerView.setAdapter(requestAdapter);
        return view;
    }
}
