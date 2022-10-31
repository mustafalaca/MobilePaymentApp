package com.example.mobilepaymentapplication.shared_preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class RecordAmount {

    static String PREF_TL = "tl";
    static String PREF_MEP_TOKEN = "mep_token";
    static String PREF_MEP_TOKEN_TO_TL = "mep_token_to_tl";
    static String PREF_TOTAL = "total";

    public static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setTl(Context ctx, float tl) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putFloat(PREF_TL, tl);
        editor.apply();
    }

    public static float getTl(Context ctx) {
        return getSharedPreferences(ctx).getFloat(PREF_TL, 0);
    }

    public static void setMepToken(Context ctx, float mepToken) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putFloat(PREF_MEP_TOKEN, mepToken);
        editor.apply();
    }

    public static float getMepToken(Context ctx) {
        return getSharedPreferences(ctx).getFloat(PREF_MEP_TOKEN, 0);
    }

    public static void setMepTokenToTl(Context ctx, float mepTokenToTl) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putFloat(PREF_MEP_TOKEN_TO_TL, mepTokenToTl);
        editor.apply();
    }

    public static float getMepTokenToTl(Context ctx) {
        return getSharedPreferences(ctx).getFloat(PREF_MEP_TOKEN_TO_TL, 0);
    }

    public static void setTotal(Context ctx, float total) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putFloat(PREF_TOTAL, total);
        editor.apply();
    }

    public static float getTotal(Context ctx) {
        return getSharedPreferences(ctx).getFloat(PREF_TOTAL, 0);
    }
}
