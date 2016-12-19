package com.example.alvan.chatproject.model.sessionmanager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.alvan.chatproject.model.basic.User;
import com.google.gson.Gson;

/**
 * Created by David Bezalel Laoli on 10/28/2016.
 */
public class SessionManager {
    SharedPreferences sharedprf;
    SharedPreferences.Editor editor;

    Context context;

    private final int PRIVATEMODE = 0;

    /*
    * PREFNAME: this string will filled by the preferences you want save
    * another string is your data
    */
    public static final String PREFNAME       = "UserSession";
    public static final String KEYISPREFLOGIN = "isUserLogin";
    public static final String KEYUSERDATA    = "UserDatas";


    /*
    * @param Context context
    * TO-DO: set the SharedPreferences and Editor
    */
    public SessionManager(Context context) {
        this.context = context;
        sharedprf = context.getSharedPreferences(PREFNAME, PRIVATEMODE);
        editor = sharedprf.edit();
    }

    /*
    * @param User user
    * TO-DO: fill the editor by your data
    */
    public void doCreateSession (User user) {
        editor.putBoolean(KEYISPREFLOGIN, true);
        editor.putString(KEYUSERDATA, new Gson().toJson(user));
        editor.commit();
    }

    /*
    * @return boolean
    */
    public boolean isUserLoggedIn () {
        return sharedprf.getBoolean(KEYISPREFLOGIN, false);
    }

    /*
    * @return object: User.class
    */
    public User getUserLoggedIn () {
        return new Gson().fromJson(sharedprf.getString(KEYUSERDATA, ""), User.class);
    }

    /*
    * TO-DO: clear the editor SharedPreferences
    */
    public void doClearSession () {
        editor.clear();
        editor.commit();
    }

}
