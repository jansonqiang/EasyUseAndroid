package com.qinag.easyuseandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qinag.easyuseandroid.R;
import com.qinag.easyuseandroid.adapter.SimplePageAdapter;
import com.qinag.easyuseandroid.widget.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment
 * Created by qiang on 2016/4/27.
 */
public class MyFragment1 extends Fragment {

    public static final String TAG = MyFragment1.class.getSimpleName();

    @Bind(R.id.tx)
    TextView tx;
    @Bind(R.id.pager_tabstrip)
    PagerSlidingTabStrip pagerTabstrip;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private View rootView;

    int tabCout = 4;


    SimplePageAdapter pageAdapter ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       // if(rootView!=null) return rootView;

        rootView = inflater.inflate(R.layout.fragment_my, container, false);

        ButterKnife.bind(this, rootView);

        tx.setText("1");

        Log.d(TAG, "运行了onCreateView");

        initPageView();

        return rootView;
    }

    @OnClick(R.id.tx)
    void clickTopTx (View view){


    }


    private void initPageView(){



        List<Fragment> fragments  = new ArrayList<>();

        for (int i = 0; i < tabCout; i++) {

            //当使用scroll 不会保存scroll的滚动位置 当使用listView 切换fragment保存list的状态
            if(i==0){
                ScrollItemFragment scrollItemFragment  = new ScrollItemFragment();
                fragments.add(scrollItemFragment);
            } else{
                ListItemFragment itemFragment =    new ListItemFragment();
                fragments.add(itemFragment);
            }


        }

        if(pageAdapter==null)
         pageAdapter = new SimplePageAdapter(getChildFragmentManager(),fragments);

        viewPager.setAdapter(pageAdapter);

        View[] topTabs = new View[tabCout];

        for (int i = 0; i < tabCout; i++) {
            View topTab =  View.inflate(getContext(),R.layout.top_tab,null);
            TextView textView = (TextView) topTab.findViewById(R.id.tv);
            textView.setText(String.format("第%d页" , i+1));
            topTabs[i] = topTab;
        }

      //  viewPager.setOffscreenPageLimit(5); //设置缓存数目


        pagerTabstrip.addTab(topTabs);
        pagerTabstrip.setViewPager(viewPager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
