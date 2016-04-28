package com.qinag.easyuseandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qinag.easyuseandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**Fragment
 * Created by qiang on 2016/4/27.
 */
public class MyFragment3 extends Fragment {



    @Bind(R.id.tx)
    TextView tx;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_my, container, false);

        ButterKnife.bind(this, rootView);

        tx.setText("3");

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
