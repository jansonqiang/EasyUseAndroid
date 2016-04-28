package com.qinag.easyuseandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qinag.easyuseandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * pageView 里面的星系
 * Created by qiang on 2016/4/27.
 */
public class ItemFragment extends Fragment {

    @Bind(R.id.layout)
    LinearLayout layout;


    final static int imageCout = 20;

    int tagNum ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.item_fragment, container, false);
        ButterKnife.bind(this, view);
        for (int i = 0; i < imageCout; i++) {
            ImageView imageView = new ImageView(getContext());

            imageView.setImageResource(R.mipmap.ic_launcher);
            layout.addView(imageView);
        }

        Log.d(this.getClass().getSimpleName()+" "+tagNum,"运行了onCreateView");


        return view;


    }


    public void setNum(int tagNum){
        this.tagNum = tagNum;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
