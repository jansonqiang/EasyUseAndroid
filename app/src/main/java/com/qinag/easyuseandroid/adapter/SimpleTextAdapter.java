package com.qinag.easyuseandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qinag.easyuseandroid.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by qiang on 2016/4/28.
 */
public class SimpleTextAdapter extends BaseAdapter {


    List<String> stringList;


    public SimpleTextAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public int getCount() {
        if (stringList == null) return 0;

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

        ViewHolder holder ;

        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_text, parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv.setText(stringList.get(position));



        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv)
        TextView tv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
