package com.qinag.easyuseandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qinag.easyuseandroid.R;
import com.qinag.easyuseandroid.widget.BadgeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**Fragment
 * Created by qiang on 2016/4/27.
 */
public class MyFragment4 extends Fragment {



    @Bind(R.id.iamgeView)
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.view_test_badge, container, false);

        ButterKnife.bind(this, rootView);

        BadgeView badgeView = new BadgeView(getContext() , imageView);

        badgeView.show();
        badgeView.setText("12");


        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
