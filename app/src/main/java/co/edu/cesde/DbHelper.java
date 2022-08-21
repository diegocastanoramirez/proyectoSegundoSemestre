package co.edu.cesde;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "cesdeShop";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "name VARCHAR (50),email VARCHAR(50)," +
                        "identification int, password VARCHAR (16))");
        db.execSQL(
                "CREATE TABLE products (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "name VARCHAR (50)," + "price int," +
                        "reference VARCHAR(40)," + " size int)");
        /*
        db.execSQL(
                "CREATE TABLE products (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "name VARCHAR (50),email VARCHAR(50)," +
                        "identification int, password VARCHAR (16))");

         */


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS  users"  );
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS producs"  );
        onCreate(db);

    }
}
