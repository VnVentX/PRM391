package com.example.foodshop;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.Account;
import com.example.foodshop.model.ResponseLoginDTO;
import com.example.foodshop.model.User;
import com.example.foodshop.repository.AccountRepositoryImpl;
import com.example.foodshop.repository.UserRespositoryImpl;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    UserRespositoryImpl userRepo = new UserRespositoryImpl();
    AccountRepositoryImpl accountRepo = new AccountRepositoryImpl();
    ResponseLoginDTO user;
    User userDetail;
    List<Account> list;
    TextView txtName, txtEmail, txtBalance;
    Button btnEdit, btnLogout;
    double balance;
    private GoogleSignInClient signInClient;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        signInClient = GoogleSignIn.getClient(view.getContext(), signInOptions);
        list = new ArrayList<>();
        final MainActivity mainActivity = (MainActivity) view.getContext();
        user = mainActivity.userInfo();

        txtName = view.findViewById(R.id.txtName);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtBalance = view.findViewById(R.id.txtBalance);
        btnEdit = view.findViewById(R.id.btnEdit);
        btnLogout = view.findViewById(R.id.btnLogout);

        userRepo.fetchUserDetail(user.getIdUser(), new CallbackData<User>() {
            @Override
            public void onSuccess(User user) {
                userDetail = user;
                txtName.setText(userDetail.getFirstName() + " " + userDetail.getLastName());
                txtEmail.setText("Email: " + userDetail.getEmail());
                balance = userDetail.getBalance();
            }

            @Override
            public void onFail(String msg) {

            }
        });

        accountRepo.fetchAccountByUserID(user.getIdUser(), new CallbackData<List<Account>>() {
            @Override
            public void onSuccess(List<Account> accounts) {
                list = accounts;
                for(Account a: list) {
                    balance = balance + a.getBalance();
                }
                txtBalance.setText("Balance: " + balance + "VND");
            }

            @Override
            public void onFail(String msg) {

            }
        });


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                signInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(view.getContext(), LoginActivity.class);
                        startActivity(intent);

                    }
                });
                mainActivity.finish();
            }
        });
        return view;
    }

}
