package com.example.final_zerocry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;



import java.util.ArrayList;

public class ThreeColumnAdapter extends ArrayAdapter<com.example.final_zerocry.User>
{
    private LayoutInflater mInflater;
    private ArrayList<com.example.final_zerocry.User> users;
    private int mViewResourceId;

    public ThreeColumnAdapter(Context context, int textViewResourceId, ArrayList<com.example.final_zerocry.User> users) {
        super(context, textViewResourceId, users);
        this.users = users;

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        com.example.final_zerocry.User user = users.get(position);

        if (user != null) {
            TextView firstName = (TextView) convertView.findViewById(R.id.info_textView);
            TextView lastName = (TextView) convertView.findViewById(R.id.role_textView);
            TextView favFood = (TextView) convertView.findViewById(R.id.res_textView);
            if (firstName != null) {
                firstName.setText(user.getinfo());
            }
            if (lastName != null) {
                lastName.setText((user.getrole()));
            }
            if (favFood != null) {
                favFood.setText((user.getres()));
            }
        }

        return convertView;
    }

}