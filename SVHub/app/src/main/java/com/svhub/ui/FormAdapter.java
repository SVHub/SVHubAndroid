package com.svhub.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.joanzapata.android.iconify.IconDrawable;
import com.svhub.R;
import com.svhub.base.FormItemHolder;

import java.util.Vector;
import java.util.zip.Inflater;

/**
 * Created by Martin on 26.04.2015.
 */
public class FormAdapter extends BaseAdapter {
    private Vector<FormItemHolder> items;
    private Activity context;

    public FormAdapter(Vector<FormItemHolder> items, Activity context){
        this.items = items;
        this.context = context;
    }


    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = convertView;
        if(root == null){
            root = LayoutInflater.from(context).inflate(R.layout.formview,null,false);
        }
        ((ImageView)root.findViewById(R.id.iv_form_icon)).setImageDrawable(
                new IconDrawable(context,items.get(position).getIcon()));
        ((TextView)root.findViewById((R.id.tv_form_input))).setText(items.get(position).getText());
        ((TextView)root.findViewById((R.id.tv_form_input))).setHint(items.get(position).getHint());
        return root;
    }
}
