package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class Main extends AppCompatActivity {

    ImageView titik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extra = getIntent().getExtras();
        byte[] byteArray = extra.getByteArray("img");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        String nama = getIntent().getExtras().getString("nama");
        String pass = getIntent().getExtras().getString("pass");
        titik = findViewById(R.id.titiktelu);
        titik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 50, baos);
                byte[] byteArray = baos.toByteArray();
                Intent peraturan = new Intent(Main.this, setting.class);
                peraturan.putExtra("img", byteArray);
                peraturan.putExtra("name", nama.getBytes().toString());
                peraturan.putExtra("sandi", pass.getBytes().toString());
                startActivity(peraturan);
            }
        });
    }
}