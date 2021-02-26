package com.dueeeke.dkplayer.fragment;

import androidx.viewpager.widget.ViewPager;

import com.dueeeke.dkplayer.R;
import com.dueeeke.dkplayer.adapter.ListPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView() {
        super.initView();
        ViewPager viewPager = findViewById(R.id.view_pager);
        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.str_tiktok));
        titles.add(getString(R.string.str_tiktok));
        viewPager.setAdapter(new ListPagerAdapter(getChildFragmentManager(), titles));
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
