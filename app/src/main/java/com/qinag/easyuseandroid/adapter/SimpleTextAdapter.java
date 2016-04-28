package com.qinag.easyuseandroid.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by qiang on 2016/4/28.
 */
public class SimpleTextAdapter extends BaseAdapter{


    List<String> stringList ;


    public SimpleTextAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public int getCount() {
        if(stringList==null) return 0;

        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
