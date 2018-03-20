package com.example.prabhat.raj.UtilsApp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by prabhat on 6/2/18.
 */

public class MyPreference {


    private Context context;
    private static final String PREF_FILE_NAME = "user";
    public static final String USER_OBJECT = "user_ob";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public MyPreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public boolean saveString(String key, String value) {
        editor.putString(key, value);
        return editor.commit();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "null");
    }

    public boolean clearPreferences() {
        editor.clear();
        return editor.commit();
    }
}
