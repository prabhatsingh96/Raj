package com.example.prabhat.raj.UtilsApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by fluper on 21/3/18.
 */

public class RegistrationDbAdapter {

        private Context context;
        private SQLiteDatabase sqLiteDatabase ;
        private ContentValues contentValues;
        private DbHelper dbHelper;
        private UserDetailForRegistration user;


        public RegistrationDbAdapter(Context context) {
            this.context = context;
            dbHelper = new DbHelper (context);
            sqLiteDatabase = dbHelper.getWritableDatabase();

        }

        // insert data in database
        public boolean insertDataInSqlLite(String uri, String name,String address, String gender) {
            contentValues = new ContentValues();

            contentValues.put(DbHelper.URII, uri);
            contentValues.put(DbHelper.NAME, name);
            contentValues.put(DbHelper.ADDRESS, address);
            contentValues.put (DbHelper.GENDER, gender);
            long result = sqLiteDatabase.insert(DbHelper.TABLE_NAME,null,contentValues);
            return result > 0;
        }



    public ArrayList<UserDetailForRegistration> showData(){
        ArrayList<UserDetailForRegistration> userDetailArrayList= new ArrayList<>();
        //String column[] = {DbHelper._ID,DbHelper.NAME,DbHelper.EMAIL,DbHelper.PASSWORD,DbHelper.CONTACT};
        Cursor cursor = sqLiteDatabase.query(DbHelper.TABLE_NAME , null , null,
                null, null , null ,null );
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(DbHelper.NAME));
            String uri = cursor.getString(cursor.getColumnIndex(DbHelper.URII));
            String gender = cursor.getString(cursor.getColumnIndex(DbHelper.GENDER));
            String address = cursor.getString(cursor.getColumnIndex(DbHelper.ADDRESS));

            user = new UserDetailForRegistration(uri,name,address,gender);
            userDetailArrayList.add (user);

        }
        return userDetailArrayList;
    }





        class DbHelper extends SQLiteOpenHelper {
            private static final String DB_NAME = "myDatabase";
            private static final String TABLE_NAME = "user";
            private static final int DB_VERSION = 2;
            private static final String _ID = "id";
            private static final String URII = "uri";
            private static final String NAME = "name";
            private static final String ADDRESS = "address";
            private static final String GENDER = "gender";
            private static final String DROP_TABLE = "drop table " + TABLE_NAME + " ";

            private static final String QUERY = " create table " + TABLE_NAME +
                    "  ( " + _ID + " integer primary key autoincrement , " +
                    URII + "  BLOB," +
                    NAME + " varchar(40)," +
                    ADDRESS + " varchar(20),"+ GENDER+")";

            public DbHelper(Context context) {
                super(context, DB_NAME, null, DB_VERSION);


            }

            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {
                sqLiteDatabase.execSQL(QUERY);
            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                sqLiteDatabase.execSQL(DROP_TABLE);
                onCreate(sqLiteDatabase);
            }
        }
    }


