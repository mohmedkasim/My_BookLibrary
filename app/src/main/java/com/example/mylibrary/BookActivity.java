package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String BOOK_ID_KEY =  "bookId";
    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddToWantToRead, btnAddToAlreadyRead, btnAddToCurrentlyReading, btnAddToFav;
    private ImageView bookImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();
//        String longDesc = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
//        Book book = new Book(1,"The Da Vinci Code","Dave", 100,"https://upload.wikimedia.org/wikipedia/en/thumb/e/e9/The_da_vinci_code_final.jpg/220px-The_da_vinci_code_final.jpg","short Description",longDesc);

        Intent intent = getIntent();
        if (null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (null != incomingBook){
                    setData(incomingBook);
                }
            }
        }
//        setData(book);
    }
    private void initViews(){
        txtAuthor = findViewById(R.id.AuthorText);
        txtBookName = findViewById(R.id.txtBook);
        txtPages = findViewById(R.id.PageNumber);
        txtDescription = findViewById(R.id.Description);

        btnAddToAlreadyRead = findViewById(R.id.btnAddAlreadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddCurrentlyReading);
        btnAddToFav = findViewById(R.id.btnAddToFav);
        btnAddToWantToRead = findViewById(R.id.btnAddWantToRead);

        bookImage = findViewById(R.id.bookImage);

    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }
}