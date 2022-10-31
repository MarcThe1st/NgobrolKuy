package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class cekemail extends AppCompatActivity {

    CardView back;
    ImageView mundur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cekemail);
        mundur = findViewById(R.id.mundur);
        back = findViewById(R.id.kembali);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kembali = new Intent(cekemail.this, LoginActivity.class);
                startActivity(kembali);
            }
        });
        mundur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mundur = new Intent(cekemail.this, pulihkanpassword.class);
                startActivity(mundur);
            }
        });
    }
}