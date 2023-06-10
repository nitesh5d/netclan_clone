package in.fivedegree.netclanclone.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import in.fivedegree.netclanclone.ExploreTabPageAdapter;
import in.fivedegree.netclanclone.R;

public class ExploreFragment extends Fragment {

    TabLayout tabLayout;
    TabItem tabPersonal, tabBusiness, tabMerchant;
    ViewPager viewPager;
    ExploreTabPageAdapter adapter;
    int tabPosition;

    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

//        ==============================
//        TAB LAYOUT START
//        ==============================

        tabLayout = view.findViewById(R.id.tab_layout);
        tabPersonal = view.findViewById(R.id.tab_personal);
        tabBusiness = view.findViewById(R.id.tab_business);
        tabMerchant = view.findViewById(R.id.tab_merchant);
        viewPager = view.findViewById(R.id.view_pager);

        viewPager.setAdapter(adapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabPosition = tab.getPosition();
                viewPager.setCurrentItem(tabPosition);
                if(tabPosition == 0/2){ adapter.notifyDataSetChanged(); }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return view;
    }
}