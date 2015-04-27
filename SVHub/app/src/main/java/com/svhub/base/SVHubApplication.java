package com.svhub.base;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.parse.Parse;

/**
 * Created by Martin on 26.04.2015.
 */
public class SVHubApplication extends Application{
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public void onCreate() {
        super.onCreate();
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
        Parse.enableLocalDatastore(this);
        // ParseUser.enableAutomaticUser();
        //ParseCrashReporting.enable(this);
        Parse.initialize(getApplicationContext(), "UfPEiaABWyAhkthWHZgEuXWIJan06UqV1B8zFXxV", "vZXQmUUHjGjN41XDkrPwsexZkIkJSHrHG9GDDBdG");
    }
}
