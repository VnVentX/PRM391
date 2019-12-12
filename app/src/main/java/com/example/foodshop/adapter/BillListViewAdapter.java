package com.example.foodshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.foodshop.R;
import com.example.foodshop.model.OrderDetail;

import java.util.List;

public class BillListViewAdapter extends BaseAdapter {
    List<OrderDetail> list;

    public BillListViewAdapter(List<OrderDetail> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.layout_bill_item, viewGroup,false);
        }

        OrderDetail detail = list.get(i);
        TextView txtStoreName = view.findViewById(R.id.storeName);
        TextView txtTime = view.findViewById(R.id.txtTime);
        TextView txtStatus = view.findViewById(R.id.status);

        txtStoreName.setText(detail.getStoreName());
        txtTime.setText(detail.getCreateAt());
        txtStatus.setText(detail.getStatus());

        return view;
    }
}
