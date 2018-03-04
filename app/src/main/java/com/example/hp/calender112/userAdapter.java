package com.example.hp.calender112;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by navidha on 03-03-2018.
 */

public class userAdapter extends ArrayAdapter {

    TextView DATE;
    Activity activity;
    List<user> list;

    public userAdapter(Activity activity, List<user> list) {
        super( activity,R.layout.custom_layout, list);
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        convertView = layoutInflater.inflate( R.layout.custom_layout,null,true );

        DATE =(TextView) convertView.findViewById( R.id.date_here );

        user uu= list.get(position);
        DATE.setText( uu.getUser2() );

        return convertView ;
    }
}
