package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAllBooks, btnCurrentlyReading, btnAlreadyRead, btnWishlist, btnFav, btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAllBooks = findViewById(R.id.btnSeeAllBooks);
        btnCurrentlyReading = findViewById(R.id.BtnCurrentReading);
        btnAlreadyRead = findViewById(R.id.BtnAlreadyReady);
        btnWishlist = findViewById(R.id.BtnWishlist);
        btnFav = findViewById(R.id.BtnFav);
        btnAbout = findViewById(R.id.BtnAbout);

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my = new Intent(MainActivity.this, SeeAllBooks.class);
                startActivity(my);
            }
        });
    }
}