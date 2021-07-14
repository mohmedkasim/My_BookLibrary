package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadyBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils() {
        if (null == allBooks){
            allBooks = new ArrayList<>();
            initData();
        }

        if (null == alreadyReadBooks){
            alreadyReadBooks = new ArrayList<>();
        }

        if (null == wantToReadyBooks){
            wantToReadyBooks = new ArrayList<>();
        }

        if (null == currentlyReadingBooks){
            currentlyReadingBooks = new ArrayList<>();
        }

        if (null == favoriteBooks){
            favoriteBooks = new ArrayList<>();
        }
    }

     private void initData(){
        // TODO: add initial data

         allBooks.add(new Book(1,"The Da Vinci Code","Dave", 100,"https://upload.wikimedia.org/wikipedia/en/thumb/e/e9/The_da_vinci_code_final.jpg/220px-The_da_vinci_code_final.jpg","short Description","Long Description"));

     }

    public static Utils getInstance() {
        if (null != instance) {
            return instance;
        } else {
            instance = new Utils();
            return instance;
        }

    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadyBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b: allBooks){
            if (b.getId() == id){
                return b;
            }
        }

        return null;
    }

    public boolean addToAlreadyRead(Book book){

        return alreadyReadBooks.add(book);
    }

    public boolean addToWantToRead (Book book){

        return wantToReadyBooks.add(book);
    }

    public boolean addToCurrentlyReading(Book book){
        return currentlyReadingBooks.add(book);
    }

    public boolean addToFav(Book book){
        return favoriteBooks.add(book);
    }

    public boolean removeFromAlreadyRead(Book book){

        return alreadyReadBooks.remove(book);
    }

    public boolean removeFromFav(Book book){

        return favoriteBooks.remove(book);
    }

     public boolean removeFromCurrentlyRead(Book book){
        return currentlyReadingBooks.remove(book);
     }

     public boolean removeFromWantToRead(Book book){
        return wantToReadyBooks.remove(book);
     }
}
