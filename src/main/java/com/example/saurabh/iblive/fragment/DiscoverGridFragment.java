package com.example.saurabh.iblive.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.adapter.DiscoverGridAdapter;
import com.example.saurabh.iblive.adapter.PostAdapter;
import com.example.saurabh.iblive.appConstants.Constants;

import java.util.ArrayList;

/**
 *contains grid fragment
 */

public class DiscoverGridFragment extends Fragment implements Constants {
    private RecyclerView recyclerView;
    private ArrayList<String> postList = new ArrayList<>();
    public DiscoverGridFragment(){

    }
    public void setArraylist(ArrayList<String> postList){
        this.postList = postList;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_discovergrid);


            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), REQUEST));
           DiscoverGridAdapter postAdapter = new DiscoverGridAdapter(postList);
            recyclerView.setAdapter(postAdapter);


        return view;
    }

    @Override
    public void myFunc() {

    }

    /**
     * used to intantiate object
     * @param mode value passed
     * @return fragment
     */
    public Fragment getObjectInstance(int mode) {
        DiscoverGridFragment discoverGridFragment = new DiscoverGridFragment();
        Bundle bundle = new Bundle();
        ArrayList<String> placeList = new ArrayList<String>();
        for(int i = 0; i<=5; i++) {
            placeList.add(getText(R.string.london).toString());
            placeList.add(getText(R.string.place).toString());
            placeList.add(getText(R.string.frankfurt).toString());
            placeList.add(getText(R.string.rome).toString());
        }
        bundle.putStringArrayList(String.valueOf(R.string.data), placeList);
        discoverGridFragment.setArguments(bundle);
        return discoverGridFragment;
    }
}
