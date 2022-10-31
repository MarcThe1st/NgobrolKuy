package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    CardView register;
    TextView sudah;
    EditText pass;
    EditText konpass;
    EditText Asmane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Asmane=findViewById(R.id.jeneng);
        pass=findViewById(R.id.pas);
        konpass=findViewById(R.id.konpas);
        register=findViewById(R.id.register);
        sudah=findViewById(R.id.sudahpunyaakun);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Register = new Intent(RegisterActivity.this, ProfilePicActivity.class);
                if (pass==konpass){
                    Register.putExtra("nama", Asmane.getText().toString());
                    Register.putExtra("pass", pass.getText().toString());
                    startActivity(Register);
                }else{
                    Snackbar.make(findViewById(R.id.conslay),R.string.konpassword, Snackbar.LENGTH_SHORT)
                            .show();
                }
            }
        });
        sudah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sudah = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(Sudah);
            }
        });
    }
}