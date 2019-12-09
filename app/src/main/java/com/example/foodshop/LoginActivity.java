package com.example.foodshop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodshop.api_util.CallbackData;
import com.example.foodshop.model.RequestLogin;
import com.example.foodshop.model.ResponseLoginDTO;
import com.example.foodshop.repository.UserRepository;
import com.example.foodshop.repository.UserRespositoryImpl;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private GoogleSignInClient signInClient;
    private int RC_SIGN_IN = 0;
    Button loginGG;

    private UserRepository userRepo = new UserRespositoryImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        loginGG = findViewById(R.id.loginGG);

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        signInClient = GoogleSignIn.getClient(this, signInOptions);

        loginGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    @Override
    protected void onStart() {
        GoogleSignInAccount currentUser = GoogleSignIn.getLastSignedInAccount(LoginActivity.this);
        if(currentUser != null) {
            RequestLogin login = new RequestLogin(currentUser.getEmail(), null, currentUser.getId());
            Log.d("TOKEN", "token: " + currentUser.getIdToken());
            userRepo.checkLogin(login, true, new CallbackData<ResponseLoginDTO>() {
                @Override
                public void onSuccess(ResponseLoginDTO responseLoginDTO) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("user", responseLoginDTO);
                    startActivity(intent);
                }

                @Override
                public void onFail(String msg) {

                }
            });
        }
        super.onStart();
    }

    private void signIn() {
        Intent intent = signInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completeTask) {
        try {
            GoogleSignInAccount account = completeTask.getResult(ApiException.class);
            RequestLogin login = new RequestLogin(account.getEmail(), null, account.getId());
            userRepo.checkLogin(login, true, new CallbackData<ResponseLoginDTO>() {
                @Override
                public void onSuccess(ResponseLoginDTO responseLoginDTO) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("user", responseLoginDTO);
                    startActivity(intent);
                }

                @Override
                public void onFail(String msg) {

                }
            });
        } catch (ApiException e) {
            Toast.makeText(this, "Error!!!", Toast.LENGTH_SHORT).show();
            Log.w("MainActivity", "signInResult: failed code=" + e.getStatusCode());
        }
    }

    public void clickToLogin(View view) {
    }

    public void clickToRegister(View view) {
    }
}
