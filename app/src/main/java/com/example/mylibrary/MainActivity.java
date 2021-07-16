package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
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
        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(MainActivity.this, AlreadyReadBook.class);
                  startActivity(intent);
              }
          });
        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingBooksActivity.class);
                startActivity(intent);
            }
        });
        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavBooksActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("My Library");
                builder.setMessage("This is made with love Mohamed Kasim");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                        intent.putExtra("url","https://www.google.com/");
                        startActivity(intent);
                    }
                });
                builder.setCancelable(true);
                builder.create().show();
            }
        });
        Utils.getInstance(this);
    }
}