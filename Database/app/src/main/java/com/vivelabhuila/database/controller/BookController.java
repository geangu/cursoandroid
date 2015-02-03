package com.vivelabhuila.database.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vivelabhuila.database.conf.DataSource;
import com.vivelabhuila.database.domain.Book;

import java.util.ArrayList;

public class BookController {

    Context context;

    public BookController(Context context) {
        this.context = context;
    }

    public Book create(Book book) {

        DataSource dataSource = new DataSource(context);
        SQLiteDatabase database = dataSource.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", book.getTitle());

        long id = database.insert("Book", null, values);

        database.close();
        dataSource.close();

        return findByPrimaryKey(id);
    }

    public Book update(Book book) {

        DataSource dataSource = new DataSource(context);
        SQLiteDatabase database = dataSource.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", book.getTitle());

        String table = "Book";
        String where = "id = " + book.getId();

        database.update(table, values, where, null);

        database.close();
        dataSource.close();

        return findByPrimaryKey(book.getId());

    }

    public Book findByPrimaryKey(long id) {

        DataSource dataSource = new DataSource(context);
        SQLiteDatabase database = dataSource.getReadableDatabase();

        String table = "Book";
        String[] columns = {"id", "title"};
        String where = "id = " + id;

        Cursor cursor = database.query(table, columns, where, null, null, null, null);
        cursor.moveToFirst();

        Book book = cursorToBook(cursor);

        return book;
    }

    public boolean delete(Book book) {

        DataSource dataSource = new DataSource(context);
        SQLiteDatabase database = dataSource.getWritableDatabase();

        String table = "Book";
        String where = "id = " + book.getId();

        int deleted = database.delete(table, where, null);

        return deleted > 0 ? true : false;
    }

    private Book cursorToBook(Cursor cursor) {
        Book book = new Book();
        book.setId(cursor.getLong(0));
        book.setTitle(cursor.getString(1));
        return book;
    }

    public ArrayList<Book> findAll() {

        DataSource dataSource = new DataSource(context);
        SQLiteDatabase database = dataSource.getReadableDatabase();

        String table = "Book";
        String[] columns = {"id", "title"};

        Cursor cursor = database.query(table, columns, null, null, null, null, null);
        ArrayList<Book> list = new ArrayList<>();
        while(cursor.moveToNext()) {
            Book book = cursorToBook(cursor);
            list.add(book);
        }

        return list;

    }
}
