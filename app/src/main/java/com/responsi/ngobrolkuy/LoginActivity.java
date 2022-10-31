package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    CardView login;
    TextView belum;
    EditText nama;
    EditText pass;
    TextView lupa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lupa=findViewById(R.id.lupas);
        nama=findViewById(R.id.nama);
        pass=findViewById(R.id.pass);
        belum=findViewById(R.id.belumpunnyakun);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Login = new Intent(LoginActivity.this,Main.class);
                Login.putExtra("nama", nama.getText().toString());
                Login.putExtra("pass", pass.getText().toString());
                startActivity(Login);
            }
        });
        belum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Belum = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(Belum);
            }
        });
        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kelalen = new Intent(LoginActivity.this, pulihkanpassword.class);
                startActivity(kelalen);
            }
        });
    }
}