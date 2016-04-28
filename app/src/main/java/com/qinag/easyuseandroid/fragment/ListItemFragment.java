package com.qinag.easyuseandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.orhanobut.logger.Logger;
import com.qinag.easyuseandroid.R;
import com.qinag.easyuseandroid.adapter.SimpleTextAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by qiang on 2016/4/28.
 */
public class ListItemFragment extends Fragment {

    @Bind(R.id.listview)
    ListView listview;

    SimpleTextAdapter adapter ;

    final int itemCount = 20;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_listview, container, false);
        Logger.init(this.getClass().getName());



        Logger.d("运行到onCreate");


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            list.add(String.format("第%d页" , i+1));
        }

        adapter = new SimpleTextAdapter(list);
        listview.setAdapter(adapter );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
