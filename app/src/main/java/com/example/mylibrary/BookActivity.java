package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if (null != incomingBook){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToReadingBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }
//        setData(book);
    }

    private void handleFavoriteBooks(Book incomingBook) {
        ArrayList<Book> FavBooks = Utils.getInstance(this).getFavoriteBooks();

        boolean existInFavBooks = false;

        for (Book b: FavBooks){
            if (b.getId() == incomingBook.getId()){
                existInFavBooks = true;
            }
        }

        if (existInFavBooks) {
            btnAddToFav.setEnabled(false);
        } else {
            btnAddToFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToFav(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: navigate the user
                        Intent intent = new Intent(BookActivity.this, FavBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(Book incomingBook) {
        ArrayList<Book> currentlyReadBooks = Utils.getInstance(BookActivity.this).getCurrentlyReadingBooks();

        boolean existIntCurrentlyReadingBooks = false;

        for (Book b: currentlyReadBooks){
            if (b.getId() == incomingBook.getId()){
                existIntCurrentlyReadingBooks = true;
            }
        }

        if (existIntCurrentlyReadingBooks) {
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToCurrentlyReading(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: navigate the user
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadingBooks(final Book incomingBook) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(BookActivity.this).getWantToReadBooks();

        boolean existIntWantToReadBooks = false;

        for (Book b: wantToReadBooks){
            if (b.getId() == incomingBook.getId()){
                existIntWantToReadBooks = true;
            }
        }

        if (existIntWantToReadBooks) {
            btnAddToWantToRead.setEnabled(false);
        } else {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToWantToRead(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: navigate the user
                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Enable and Disable button,
     * Add the book to Already Read Book ArrayList
     * @param incomingBook
     */
    private void handleAlreadyRead(Book incomingBook) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(BookActivity.this).getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for (Book b: alreadyReadBooks){
            if (b.getId() == incomingBook.getId()){
                existInAlreadyReadBooks = true;
            }
        }

        if (existInAlreadyReadBooks) {
            btnAddToAlreadyRead.setEnabled(false);
        } else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToAlreadyRead(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: navigate the user
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBook.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
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