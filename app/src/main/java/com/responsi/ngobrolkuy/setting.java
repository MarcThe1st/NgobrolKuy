package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class setting extends AppCompatActivity {

    ImageView back;
    TextView username;
    TextView password;
    CircleImageView imag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Bundle extra = getIntent().getExtras();
        byte[] byteArray = extra.getByteArray("img");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imag=findViewById(R.id.img);
        imag.setImageBitmap(bmp);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        String nama = getIntent().getExtras().getString("name");
        String pass = getIntent().getExtras().getString("sandi");
        back = findViewById(R.id.back);
        username.setText(nama);
        password.setText(pass);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mundur = new Intent(setting.this, Main.class);
                startActivity(mundur);
            }
        });
    }
}