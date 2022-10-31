package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class pulihkanpassword extends AppCompatActivity {

    CardView submit;
    ImageView mundur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulihkanpassword);
        mundur = findViewById(R.id.mundur);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(pulihkanpassword.this, cekemail.class);
                startActivity(submit);
            }
        });
        mundur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mundur = new Intent(pulihkanpassword.this, LoginActivity.class);
                startActivity(mundur);
            }
        });
    }
}