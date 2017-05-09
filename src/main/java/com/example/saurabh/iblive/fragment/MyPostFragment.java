package com.example.saurabh.iblive.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.adapter.PostAdapter;
import com.example.saurabh.iblive.appConstants.Constants;

import java.util.ArrayList;

/**
 * class contains recycler view
 */

public class MyPostFragment extends Fragment implements Constants {
    private TextView tvDiscover, tvRequest, tvPosts, tvMaps, tvNetwork;
    private ImageButton ibInfo;
    private RecyclerView recyclerView;

    /**
     * @param mode of int type tells which type of obhect will be returned
     * @return fragment
     */
    public static Fragment getInstance(int mode, final ArrayList<String> postlist) {
        MyPostFragment myPostFragment = new MyPostFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(String.valueOf(R.string.mode), mode);
        bundle.putStringArrayList(String.valueOf(R.string.data), postlist);
        myPostFragment.setArguments(bundle);
        return myPostFragment;

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypost, container, false);
        init(view);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int mode;
            mode = bundle.getInt(String.valueOf(R.string.mode));
            if (mode == DISCOVER || mode == MYPOST) {

                ArrayList<String> postList = bundle.getStringArrayList(String.valueOf(R.string.data));
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                PostAdapter postAdapter = new PostAdapter(mode, postList);
                recyclerView.setAdapter(postAdapter);

            }
            else {
                ArrayList<String> postList = bundle.getStringArrayList(String.valueOf(R.string.data));
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),GRID));
                PostAdapter postAdapter = new PostAdapter(mode, postList);
                recyclerView.setAdapter(postAdapter);

            }
        }
        return view;
    }

    /**
     * this is used to find ids
     *
     * @param view this is to access methods of activity
     */
    private void init(View view) {
        tvDiscover = (TextView) view.findViewById(R.id.tv_discover);
        tvRequest = (TextView) view.findViewById(R.id.tv_request);
        tvMaps = (TextView) view.findViewById(R.id.tv_map);
        tvNetwork = (TextView) view.findViewById(R.id.tv_network);
        tvPosts = (TextView) view.findViewById(R.id.tv_posts);
        ibInfo = (ImageButton) view.findViewById(R.id.ib_info);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_posts);
    }

    @Override
    public void myFunc() {

    }

}
