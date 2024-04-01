package com.example.bookingsapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hotel_booking.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng Hotels
        db.execSQL("CREATE TABLE Hotels (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "address TEXT," +
                "rating REAL)");

        // Tạo bảng Customer
        db.execSQL("CREATE TABLE Customer (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT," +
                "email TEXT)");

        // Tạo bảng Bookings
        db.execSQL("CREATE TABLE Bookings (" +
                "id INTEGER PRIMARY KEY," +
                "hotel_id INTEGER," +
                "customer_id INTEGER," +
                "check_in_date TEXT," +
                "check_out_date TEXT," +
                "FOREIGN KEY(hotel_id) REFERENCES Hotels(id)," +
                "FOREIGN KEY(customer_id) REFERENCES Customer(id))");

        // Tạo bảng Rooms
        db.execSQL("CREATE TABLE Rooms (" +
                "id INTEGER PRIMARY KEY," +
                "hotel_id INTEGER," +
                "room_number TEXT," +
                "type TEXT," +
                "price REAL," +
                "availability INTEGER," +
                "FOREIGN KEY(hotel_id) REFERENCES Hotels(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng cũ nếu tồn tại
        db.execSQL("DROP TABLE IF EXISTS Hotels");
        db.execSQL("DROP TABLE IF EXISTS Customer");
        db.execSQL("DROP TABLE IF EXISTS Bookings");
        db.execSQL("DROP TABLE IF EXISTS Rooms");
        // Tạo lại cơ sở dữ liệu
        onCreate(db);
    }
}

