package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

public class ProfilePicActivity extends AppCompatActivity {

    public static final int request_code = 69;
    public static final int camera_code = 69;
    TextView lewati;
    ImageView ambil;
    ImageView profil;
    CardView lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);
        String nama = getIntent().getExtras().getString("nama");
        String pass = getIntent().getExtras().getString("pass");
        lanjut=findViewById(R.id.lanjut);
        lewati=findViewById(R.id.lewati);
        ambil=findViewById(R.id.pinkCircle);
        profil=findViewById(R.id.profilePic);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profil.buildDrawingCache();
                Bitmap bmp = ((BitmapDrawable)profil.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 50, baos);
                byte[] byteArray = baos.toByteArray();
                Intent lanjut = new Intent(ProfilePicActivity.this, Main.class);
                lanjut.putExtra("img", byteArray);
                lanjut.putExtra("nama", nama.getBytes().toString());
                lanjut.putExtra("pass", pass.getBytes().toString());
                startActivity(lanjut);
            }
        });
        ambil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent foto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(foto, camera_code);
                lewati.setVisibility(View.INVISIBLE);
                lanjut.setVisibility(View.VISIBLE);
            }
        });
        lewati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profil.buildDrawingCache();
                Bitmap bmp = ((BitmapDrawable)profil.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 50, baos);
                byte[] byteArray = baos.toByteArray();
                Intent Lewat = new Intent(ProfilePicActivity.this, Main.class);
                Lewat.putExtra("img", byteArray);
                Lewat.putExtra("nama", nama.getBytes().toString());
                Lewat.putExtra("pass", pass.getBytes().toString());
                startActivity(Lewat);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == camera_code){
                Bitmap cameraimage = (Bitmap) data.getExtras().get("data");
                profil.setImageBitmap(cameraimage);
            }
        }
    }
}