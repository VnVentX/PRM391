package com.example.foodshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodshop.R;
import com.example.foodshop.model.Store;

import java.util.List;

public class StoreListViewAdapter extends BaseAdapter {
    List<Store> listStore;

    public StoreListViewAdapter(List<Store> listStore) {
        this.listStore = listStore;
    }
    @Override
    public int getCount() {
        return listStore.size();
    }

    @Override
    public Object getItem(int i) {
        return listStore.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.fragment_item_course, viewGroup,false);
        }
        Store store = listStore.get(i);
        ImageView imageView = view.findViewById(R.id.courseImage);
        TextView courseName = view.findViewById(R.id.courseName);
        TextView coureseAddress = view.findViewById(R.id.courseAddress);
        Glide.with(view).load(store.getImageUrl()).into(imageView);
        courseName.setText(store.getName());
        coureseAddress.setText(store.getDescription());
        return view;
    }
}
