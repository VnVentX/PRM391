package com.example.foodshop;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foodshop.model.Category;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemCategoryFragment extends Fragment {
    Category category;

    public ItemCategoryFragment() {
        // Required empty public constructor
    }

    public ItemCategoryFragment(Category category) {
        this.category = category;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_category, container, false);
        TextView txtCategory = view.findViewById(R.id.txtCategory);
        txtCategory.setText(category.getName());
        txtCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListStoreActivity.class);
                intent.putExtra("idCategory", category.getIdCategory());
                intent.putExtra("categoryName", category.getName());
                startActivity(intent);
            }
        });
        return view;
    }

}
