package com.dueeeke.dkplayer.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dueeeke.dkplayer.R;
import com.dueeeke.dkplayer.adapter.TikTokListAdapter;
import com.dueeeke.dkplayer.bean.TiktokBean;
import com.dueeeke.dkplayer.util.DataUtil;

import java.util.ArrayList;
import java.util.List;

public class TikTokListFragment extends BaseFragment {
    private final List<TiktokBean> data = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private TikTokListAdapter mAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tiktok_list;
    }

    @Override
    protected void initView() {
        super.initView();
        mRecyclerView = findViewById(R.id.rv_tiktok);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mAdapter = new TikTokListAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected boolean isLazyLoad() {
        return true;
    }

    @Override
    protected void initData() {
        super.initData();
        new Thread(() -> {
            List<TiktokBean> tiktokBeans = DataUtil.getTiktokDataFromAssets(getActivity());
            data.addAll(tiktokBeans);
            mRecyclerView.post(() -> mAdapter.notifyDataSetChanged());
        }).start();
    }
}
