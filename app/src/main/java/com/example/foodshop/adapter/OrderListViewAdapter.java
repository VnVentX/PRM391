package com.example.foodshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.foodshop.R;
import com.example.foodshop.model.OrderDetailList;

import java.util.List;

public class OrderListViewAdapter extends BaseAdapter {
    List<OrderDetailList> productList;

    public OrderListViewAdapter(List<OrderDetailList> productList) {
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.layout_cart_product, viewGroup,false);
        }
        OrderDetailList product = productList.get(i);
        TextView txtProductName = view.findViewById(R.id.txtProdcut);
        TextView qp = view.findViewById(R.id.txtQP);

        txtProductName.setText(product.getProductName());
        qp.setText(product.getQuantity() + "x " + product.getUnitPrice() + "VND");
        return view;
    }
}
