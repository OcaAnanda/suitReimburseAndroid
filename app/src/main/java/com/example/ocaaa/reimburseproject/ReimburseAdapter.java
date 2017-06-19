package com.example.ocaaa.reimburseproject;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 6/19/2017.
 */

public class ReimburseAdapter extends ArrayAdapter<Reimburse> {

    public ReimburseAdapter(Context context, List<Reimburse> object) {
        super(context, 0, object);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_reimburse,parent,false);

        Reimburse current = getItem(position);

        TextView title = (TextView)convertView.findViewById(R.id.tvReimburseTitle);
        title.setText("Reimburse ID #"+current.getId());

        TextView date = (TextView)convertView.findViewById(R.id.tvReimburseDate);
        date.setText(current.getDate());

        TextView name = (TextView)convertView.findViewById(R.id.tvReimburseName);
        name.setText(current.getProject());

        int no = current.getTotal();
        String str = String.format("%,d", no).replace(",", ".");
        TextView amount = (TextView)convertView.findViewById(R.id.tvReimburseAmount);
        amount.setText("Rp. "+str);

        TextView status = (TextView)convertView.findViewById(R.id.tvReimburseStatus);
        status.setText(current.getStatusText());
        status.setTextColor(status.getResources().getColor(current.getColor()));

        ImageView icon = (ImageView)convertView.findViewById(R.id.ivReimburseIcon);
        icon.setImageResource(current.getIcon());
        icon.setBackgroundColor(icon.getResources().getColor(R.color.white));

        return convertView;
    }
}
