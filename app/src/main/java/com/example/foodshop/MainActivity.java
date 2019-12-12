package com.example.foodshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodshop.model.ResponseLoginDTO;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ResponseLoginDTO user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBar);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = new HomeFragment();
        transaction.replace(R.id.fragContainer,fragment);
        transaction.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_bill:
                        fragment = new BillFragment();
                        break;
                    case R.id.nav_frofile:
                        fragment = new ProfileFragment();
                        break;
                }
                transaction.replace(R.id.fragContainer, fragment);
                transaction.commit();
                return true;
            }
        });

        Intent intent = getIntent();
        user = (ResponseLoginDTO) intent.getSerializableExtra("user");
    }

    public ResponseLoginDTO userInfo() {
        return user;
    }
}
