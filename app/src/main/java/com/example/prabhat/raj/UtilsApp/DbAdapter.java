package com.example.prabhat.raj.UtilsApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by prabhat on 7/2/18.
 */

public class DbAdapter {
    private Context context;
    private SQLiteDatabase sqLiteDatabase ;
    ContentValues contentValues;
    DbHelper dbHelper;
    UserDetail user = null;

    public DbAdapter(Context context) {
        this.context = context;
         dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();

    }

    // insert data in database
    public boolean insertData(String name, String email,String password, String contact) {
        contentValues = new ContentValues();

        contentValues.put(DbHelper.NAME, name);
        contentValues.put(DbHelper.EMAIL, email);
        contentValues.put(DbHelper.PASSWORD, password);
        contentValues.put(DbHelper.CONTACT, contact);
        long result = sqLiteDatabase.insert(DbHelper.TABLE_NAME,null,contentValues);
        return result > 0;
    }



    // show UserDetail by Id
     public UserDetail showUserDetailById(int userId){
      // String columns[] = {DbHelper._ID,DbHelper.NAME,DbHelper.EMAIL,DbHelper.PASSWORD,DbHelper.CONTACT};
       String selection = DbHelper._ID +" =?";
       String selectionArgs[] = {String.valueOf(userId)};
       Cursor cursor = sqLiteDatabase.query(DbHelper.TABLE_NAME, null,selection, selectionArgs,null, null, null);
        if(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DbHelper._ID));
            String name = cursor.getString(cursor.getColumnIndex(DbHelper.NAME));
            String email = cursor.getString(cursor.getColumnIndex(DbHelper.EMAIL));
            String password = cursor.getString(cursor.getColumnIndex(DbHelper.PASSWORD));
            String contact = cursor.getString(cursor.getColumnIndex(DbHelper.CONTACT));
            user = new UserDetail(id,name,email,password,contact);

        }
        return user;
     }

    // show data

    public ArrayList<UserDetail> showData(){
           ArrayList<UserDetail> userDetailArrayList= new ArrayList<>();
        //String column[] = {DbHelper._ID,DbHelper.NAME,DbHelper.EMAIL,DbHelper.PASSWORD,DbHelper.CONTACT};
        Cursor cursor = sqLiteDatabase.query(DbHelper.TABLE_NAME , null , null, null, null , null ,null );
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DbHelper._ID));
            String name = cursor.getString(cursor.getColumnIndex(DbHelper.NAME));
            String email = cursor.getString(cursor.getColumnIndex(DbHelper.EMAIL));
            String password = cursor.getString(cursor.getColumnIndex(DbHelper.PASSWORD));
            String contact = cursor.getString(cursor.getColumnIndex(DbHelper.CONTACT));
            user = new UserDetail(id,name,email,password,contact);
            userDetailArrayList.add(user);

        }
        return userDetailArrayList;
    }

    //validate data
    public boolean validate(String email,String password)
    {
        String column[] = {DbHelper.EMAIL,DbHelper.PASSWORD};
        String selection = " "+DbHelper.EMAIL+" = ? and "+DbHelper.PASSWORD+" = ? ";
        String selections[] = {email,password};
        Cursor cursor = sqLiteDatabase.query(DbHelper.TABLE_NAME, column,selection,selections, null, null,null);
        if(cursor.moveToNext())
            return true;
        else
            return false;

    }





class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "DbName";
    private static final String TABLE_NAME = "emp";
    private static final int DB_VERSION = 2;
    private static final String _ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String CONTACT = "contact";
    private static final String DROP_TABLE = "drop table " + TABLE_NAME + " ";
    private static final String QUERY = " create table " + TABLE_NAME + "  ( " + _ID + " integer primary key autoincrement , " + NAME
            + "  varchar(20)," + EMAIL + " varchar(40)," + PASSWORD + " varchar(20), " + CONTACT + " varchar(20));";

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


