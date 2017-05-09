package com.example.saurabh.iblive.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.appConstants.Constants;

/**
 * contains data to displayed in request button
 */

public class RequestFragment extends Fragment implements Constants {
    private Button btnMap, btnNetwork, btnPosts;
    private ViewPager viewPager;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request, container, false);

        init(view);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(DISCOVER);
            }
        });
        btnPosts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(MAPS);
            }
        });
        btnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(MYPOST);

            }
        });
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position == DISCOVER){
                    return new RequestContent();
                }
                else if(position == MYPOST){
                    return InnerRequestFragment.getInstance(MYPOST);
                }
                else
                    return InnerRequestFragment.getInstance(MAPS);


            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }


    private void init(View view) {
        btnMap = (Button) view.findViewById(R.id.btn_maps);
        btnNetwork = (Button) view.findViewById(R.id.btn_network);
        btnPosts = (Button) view.findViewById(R.id.btn_post);
        viewPager = (ViewPager) view.findViewById(R.id.vp_request);
    }

    @Override
    public void myFunc() {

    }
}
