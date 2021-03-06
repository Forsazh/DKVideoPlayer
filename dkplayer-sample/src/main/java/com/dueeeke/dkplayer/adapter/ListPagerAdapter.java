package com.dueeeke.dkplayer.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.dueeeke.dkplayer.fragment.TikTokListFragment;

import java.util.List;

/**
 * Created by dueeeke on 2018/1/3.
 */
public class ListPagerAdapter extends FragmentStatePagerAdapter {

    private final List<String> mTitles;
    private final SparseArrayCompat<Fragment> mFragments = new SparseArrayCompat<>();

    public ListPagerAdapter(FragmentManager fm, List<String> titles) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mTitles = titles;
    }

    @Override
    @NonNull
    public Fragment getItem(int position) {
        Fragment fragment = mFragments.get(position);
        if (fragment == null) {
            fragment = new TikTokListFragment();
            mFragments.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
