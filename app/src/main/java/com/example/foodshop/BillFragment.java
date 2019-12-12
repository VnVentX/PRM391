package com.example.foodshop;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.foodshop.adapter.BillListViewAdapter;
import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.OrderDetail;
import com.example.foodshop.model.ResponseLoginDTO;
import com.example.foodshop.repository.OrderRepository;
import com.example.foodshop.repository.OrderRepositoryImpl;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BillFragment extends Fragment {
    OrderRepositoryImpl orderRepo = new OrderRepositoryImpl();
    BillListViewAdapter billListViewAdapter;
    List<OrderDetail> listBill;
    ResponseLoginDTO user;
    ListView billContainer;

    public BillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bill, container, false);
        listBill = new ArrayList<>();
        MainActivity mainActivity = (MainActivity) view.getContext();
        user = mainActivity.userInfo();
        billContainer = view.findViewById(R.id.billContainer);
        orderRepo.fetchAllOrder(user.getIdUser(), new CallbackData<List<OrderDetail>>() {
            @Override
            public void onSuccess(List<OrderDetail> list) {
                listBill = list;
                if(listBill != null) {
                    billListViewAdapter = new BillListViewAdapter(listBill);
                    billListViewAdapter.notifyDataSetChanged();
                    billContainer.setAdapter(billListViewAdapter);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
        billContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                OrderDetail orderDetail = listBill.get(i);
                Intent intent = new Intent(getActivity(), ViewOrderActivity.class);
                intent.putExtra("orderDetail", orderDetail);
                startActivity(intent);
            }
        });
        return view;
    }

}
