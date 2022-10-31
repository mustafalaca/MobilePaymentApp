package com.example.mobilepaymentapplication.shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class RecordLoginData {

    static String PREF_TOKEN_ID = "token_id";
    static String PREF_REMEMBER_ME_ID = "remember_me_id";
    static String PREF_IS_LOGGED_IN = "is_logged_in";
    static String PREF_PHONE_NUMBER = "phone_number";
    static String PREF_PASSWORD = "password";
    static String PREF_DARK_MODE = "dark_mode";


    public static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setIsLoggedIn(Context ctx, boolean loggedIn) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putBoolean(PREF_IS_LOGGED_IN, loggedIn);
        editor.apply();
    }

    public static boolean getIsLoggedIn(Context ctx) {
        return getSharedPreferences(ctx).getBoolean(PREF_IS_LOGGED_IN, false);
    }


    public static void setDarkMode(Context ctx, boolean isDarkMode) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putBoolean(PREF_DARK_MODE, isDarkMode);
        editor.apply();
    }

    public static boolean getDarkMode(Context ctx) {
        return getSharedPreferences(ctx).getBoolean(PREF_DARK_MODE, false);
    }

    public static void setTokenData(Context ctx, String tokenId) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_TOKEN_ID, tokenId);
        editor.apply();
    }

    public static String getTokenData(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_TOKEN_ID, "");
    }

    public static void setRememberMeChecked(Context ctx, boolean rememberMe) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putBoolean(PREF_REMEMBER_ME_ID, rememberMe);
        editor.apply();
    }

    public static boolean getRememberMeChecked(Context ctx) {
        return getSharedPreferences(ctx).getBoolean(PREF_REMEMBER_ME_ID, false);
    }

    public static void setPhoneNumber(Context ctx, String phoneNumber) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_PHONE_NUMBER, phoneNumber);
        editor.apply();
    }

    public static String getPhoneNumber(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_PHONE_NUMBER, "");
    }

    public static void setPassword(Context ctx, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_PASSWORD, password);
        editor.apply();
    }

    public static String getPassword(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_PASSWORD, "");
    }




}
