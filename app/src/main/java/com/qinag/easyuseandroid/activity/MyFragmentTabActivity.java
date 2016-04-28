package com.qinag.easyuseandroid.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;

import com.qinag.easyuseandroid.R;
import com.qinag.easyuseandroid.fragment.MyFragment1;
import com.qinag.easyuseandroid.fragment.MyFragment2;
import com.qinag.easyuseandroid.fragment.MyFragment3;
import com.qinag.easyuseandroid.fragment.MyFragment4;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 底部TAB
 * Created by qiang on 2016/4/27.
 */
public class MyFragmentTabActivity extends FragmentActivity {

    @Bind(R.id.realtabcontent)
    FrameLayout realtabcontent;


    TabWidget tabs;
    @Bind(R.id.tabhost)
    FragmentTabHost tabhost;

    private View indicator = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tab);
        ButterKnife.bind(this);
        // id 是fragment显示的区域
        tabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);




        indicator = getIndicatorView("综合", R.drawable.tab_icon_explore);
        addTab(MyFragment1.class, indicator);

        indicator = getIndicatorView("我的", R.drawable.tab_icon_me);
        addTab(MyFragment2.class, indicator);

        indicator = getIndicatorView("新闻", R.drawable.tab_icon_new);
        addTab(MyFragment3.class,indicator);

        indicator = getIndicatorView("团队", R.drawable.tab_icon_tweet);
        addTab(MyFragment4.class,indicator);

        tabhost.getTabWidget().setShowDividers(0);//不设置dividers



    }


    private void addTab(Class clas , View view ){

        tabhost.addTab(
                tabhost.newTabSpec(clas.getName()).setIndicator(view), clas, null);

    }



    private View getIndicatorView(String name,  int drawableRes) {
        View v = getLayoutInflater().inflate(R.layout.layout_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.tab_tx);

        tv.setCompoundDrawablesWithIntrinsicBounds(0,drawableRes,0,0);
        tv.setText(name);
        return v;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        // 当 API Level > 11 调用这个方法可能导致奔溃（android.os.Build.VERSION.SDK_INT > 11）
    }

}
