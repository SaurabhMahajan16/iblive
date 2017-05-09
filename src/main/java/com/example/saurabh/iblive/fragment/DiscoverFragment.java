package com.example.saurabh.iblive.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabh.iblive.R;
import com.example.saurabh.iblive.activity.HomeActivity;
import com.example.saurabh.iblive.appConstants.Constants;

import java.util.ArrayList;

/**
 * class that contains discover toolbar that contains 5 buttons and search toolbar
 */

public class DiscoverFragment extends Fragment implements View.OnClickListener, Constants {
    private TextView tvDiscover, tvRequest, tvPosts, tvMaps, tvNetwork, tvTitle;
    private ImageButton ibInfo, ibgrid, ibBar;
    private ViewPager vpSwipe;
    private MapFragment mapFragment = new MapFragment();
    private RequestFragment requestFragment = new RequestFragment();
    private ArrayList<String> places = new ArrayList<>();
    private LinearLayout layoutSearchBar;
    private Toolbar toolbar;
    private ArrayList<String> placeList = new ArrayList<String>();

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        places.add((String) getText(R.string.place));
        places.add(getText(R.string.london).toString());
        places.add(getText(R.string.rome).toString());
        places.add(getText(R.string.frankfurt).toString());

        for (int i = 0; i <= 5; i++) {
            placeList.add(getText(R.string.london).toString());
            placeList.add(getText(R.string.place).toString());
            placeList.add(getText(R.string.frankfurt).toString());
            placeList.add(getText(R.string.rome).toString());
        }

        init(view);
        layoutSearchBar = (LinearLayout) view.findViewById(R.id.ll_searchbar);


        tvRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                changeButtonColor(REQUEST);
                vpSwipe.setCurrentItem(REQUEST);
                tvTitle.setText(getText(R.string.myrequests).toString());
                layoutSearchBar.setVisibility(View.GONE);
                ibgrid.setVisibility(View.INVISIBLE);
                ibBar.setImageResource(R.drawable.ic_local_bar_black_24dp);
            }
        });
        tvNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                changeButtonColor(NETWORK);
                vpSwipe.setCurrentItem(NETWORK);
                tvTitle.setText(getText(R.string.mynetwork).toString());
                layoutSearchBar.setVisibility(View.GONE);
                ibgrid.setVisibility(View.INVISIBLE);
                ibBar.setImageResource(R.drawable.ic_local_bar_black_24dp);
            }
        });
        tvMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                vpSwipe.setCurrentItem(MAPS);
                changeButtonColor(MAPS);
                tvTitle.setText(getText(R.string.map).toString());
                layoutSearchBar.setVisibility(View.GONE);
                ibgrid.setVisibility(View.INVISIBLE);
                ibBar.setImageResource(R.drawable.ic_local_bar_black_24dp);
            }
        });
        tvPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                vpSwipe.setCurrentItem(MYPOST);
                changeButtonColor(MYPOST);
                tvTitle.setText(getText(R.string.my_posts).toString());
                layoutSearchBar.setVisibility(View.VISIBLE);
                ibgrid.setVisibility(View.VISIBLE);
                ibBar.setImageResource(R.drawable.sorti);
            }
        });
        tvDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                vpSwipe.setCurrentItem(DISCOVER);
                changeButtonColor(DISCOVER);
                layoutSearchBar.setVisibility(View.VISIBLE);
                tvTitle.setText(getText(R.string.discover).toString());
                ibgrid.setVisibility(View.VISIBLE);
                ibBar.setImageResource(R.drawable.sorti);
            }
        });
        ibInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(getActivity(), "Information not available",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                vpSwipe.setCurrentItem(DISCOVER);
                changeButtonColor(DISCOVER);
                layoutSearchBar.setVisibility(View.VISIBLE);
                tvTitle.setText(getText(R.string.discover).toString());
                ibgrid.setVisibility(View.VISIBLE);
                ibBar.setImageResource(R.drawable.sorti);
            }
        });

        ibgrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               vpSwipe.setCurrentItem(GRID);
                layoutSearchBar.setVisibility(View.VISIBLE);
                tvTitle.setText(getText(R.string.discover).toString());
                ibgrid.setVisibility(View.VISIBLE);
                ibBar.setImageResource(R.drawable.sorti);

            }
        });
        vpSwipe.setOffscreenPageLimit(6);
        vpSwipe.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == DISCOVER) {
                    layoutSearchBar.setVisibility(View.VISIBLE);
                    ibgrid.setVisibility(View.VISIBLE);
                    ibBar.setImageResource(R.drawable.sorti);
                    return MyPostFragment.getInstance(DISCOVER, places);

                } else if (position == MAPS) {
                    ibgrid.setVisibility(View.INVISIBLE);
                    layoutSearchBar.setVisibility(View.GONE);
                    ibBar.setImageResource(R.drawable.ic_local_bar_black_24dp);
                    return mapFragment;
                } else if (position == MYPOST) {
                    layoutSearchBar.setVisibility(View.VISIBLE);
                    ibgrid.setVisibility(View.VISIBLE);
                    ibBar.setImageResource(R.drawable.sorti);
                    return MyPostFragment.getInstance(MYPOST, places);
                } else if (position == REQUEST) {
                    layoutSearchBar.setVisibility(View.GONE);
                    ibgrid.setVisibility(View.INVISIBLE);
                    ibBar.setImageResource(R.drawable.ic_local_bar_black_24dp);
                    return requestFragment;
                } else if (position == NETWORK) {
                    layoutSearchBar.setVisibility(View.GONE);
                    ibgrid.setVisibility(View.INVISIBLE);
                    ibBar.setImageResource(R.drawable.ic_local_bar_black_24dp);
                    return new NetworkFragment();
                }
                else if(position == GRID){
                    layoutSearchBar.setVisibility(View.VISIBLE);
                    ibgrid.setVisibility(View.VISIBLE);
                    ibBar.setImageResource(R.drawable.sorti);
                    return MyPostFragment.getInstance(GRID, placeList);
                }
                    else
                 return null;
            }


            @Override
            public int getCount() {
                return 6;
            }
        });

        vpSwipe.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int state) {

            }

            @Override
            public void onPageScrolled(final int position, final float positionOffset,
                                       final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                if (position == DISCOVER) {
                    changeButtonColor(DISCOVER);

                } else if (position == MAPS) {
                    changeButtonColor(MAPS);

                } else if (position == MYPOST) {
                    changeButtonColor(MYPOST);

                } else if (position == REQUEST) {
                    changeButtonColor(REQUEST);
                } else if (position == NETWORK) {
                    changeButtonColor(NETWORK);
                }
            }
        });


        return view;
    }

    private void changeButtonColor(final int i) {
        if (i == DISCOVER) {
            tvDiscover.setBackgroundResource(R.color.greeny_blue);
            tvRequest.setBackgroundResource(R.color.dark_green_blue);
            tvPosts.setBackgroundResource(R.color.dark_green_blue);
            tvNetwork.setBackgroundResource(R.color.dark_green_blue);
            tvMaps.setBackgroundResource(R.color.dark_green_blue);
        } else if (i == MAPS) {
            tvMaps.setBackgroundResource(R.color.greeny_blue);
            tvDiscover.setBackgroundResource(R.color.dark_green_blue);
            tvRequest.setBackgroundResource(R.color.dark_green_blue);
            tvPosts.setBackgroundResource(R.color.dark_green_blue);
            tvNetwork.setBackgroundResource(R.color.dark_green_blue);
        } else if (i == MYPOST) {
            tvPosts.setBackgroundResource(R.color.greeny_blue);
            tvDiscover.setBackgroundResource(R.color.dark_green_blue);
            tvRequest.setBackgroundResource(R.color.dark_green_blue);
            tvMaps.setBackgroundResource(R.color.dark_green_blue);
            tvNetwork.setBackgroundResource(R.color.dark_green_blue);
        } else if (i == NETWORK) {
            tvNetwork.setBackgroundResource(R.color.greeny_blue);
            tvDiscover.setBackgroundResource(R.color.dark_green_blue);
            tvRequest.setBackgroundResource(R.color.dark_green_blue);
            tvPosts.setBackgroundResource(R.color.dark_green_blue);
            tvMaps.setBackgroundResource(R.color.dark_green_blue);
        } else {
            tvRequest.setBackgroundResource(R.color.greeny_blue);
            tvDiscover.setBackgroundResource(R.color.dark_green_blue);
            tvMaps.setBackgroundResource(R.color.dark_green_blue);
            tvPosts.setBackgroundResource(R.color.dark_green_blue);
            tvNetwork.setBackgroundResource(R.color.dark_green_blue);
        }

    }

    /**
     * this is used to find ids
     *
     * @param view to access views
     */
    private void init(View view) {
        tvDiscover = (TextView) view.findViewById(R.id.tv_discover);
        tvRequest = (TextView) view.findViewById(R.id.tv_requests);
        tvMaps = (TextView) view.findViewById(R.id.tv_map);
        tvNetwork = (TextView) view.findViewById(R.id.tv_network);
        tvPosts = (TextView) view.findViewById(R.id.tv_posts);
        ibInfo = (ImageButton) view.findViewById(R.id.ib_info);
        vpSwipe = (ViewPager) view.findViewById(R.id.vp_swipe);
        toolbar = ((HomeActivity) getActivity()).getToolbar();
        ibgrid = (ImageButton) toolbar.findViewById(R.id.ib_grid);
        tvTitle = (TextView) toolbar.findViewById(R.id.tv_title);
        ibBar = (ImageButton) toolbar.findViewById(R.id.ib_bar);
    }

    @Override
    public void onClick(final View v) {
        int id = v.getId();


    }

    @Override
    public void myFunc() {

    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvTitle.setText(getText(R.string.discover).toString());
        layoutSearchBar.setVisibility(View.VISIBLE);
        ibgrid.setVisibility(View.VISIBLE);
        ibgrid.setImageResource(R.drawable.grid_view);
        ibBar.setImageResource(R.drawable.sorti);
    }
}
