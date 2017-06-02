package com.example.rohma.secureit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AnonymousAuth extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authListener;
//    private Button btnLogin;
//    private Button btnLogout;
//    private Button btnPermanent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymous_auth);
//        btnLogin = (Button) findViewById(R.id.btnLogin);
        mAuth = FirebaseAuth.getInstance();
        authListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    Log.d("Auth:", user.getUid());
                    Toast.makeText(getApplicationContext(), user.getUid(), Toast.LENGTH_LONG).show();

                }
            }
        };

//        btnLogin.setOnClickListener((v -> {
//            Task<AuthResult> resultTask = mAuth.signInAnonymously();
//            resultTask.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                @Override
//                public void onSuccess(AuthResult authResult) {
//                    Intent intent1 = new Intent(AnonymousAuth.this, MainActivity.class);
//                    startActivity(intent1);
//                }
//            });
//        }));


    }

    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(authListener);

    }

    @Override
    protected void onStop(){
        super.onStop();
        mAuth.removeAuthStateListener(authListener);
    }

    public void buSignIn(View view){
        mAuth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Log.w("Auth:", task.getException());
                }
                else{
                    Intent intent1 = new Intent(AnonymousAuth.this, MainActivity.class);
                    startActivity(intent1);
                }
            }
        });
    }
}
