package com.example.mobilepaymentapplication.common_functions;

import android.content.Context;

public class Intent {

    public void startActivity(Context context, Class<?> cls){
        android.content.Intent intent = new android.content.Intent(context, cls);
        context.startActivity(intent);
    }

    public void finish(Context context){
        ((android.app.Activity) context).finish();
    }

    //putextra
    public void putExtra(Context context, String key, Float value){
        ((android.app.Activity) context).getIntent().putExtra(key, value);
    }

    //getextra
    public String getExtra(Context context, String key){
        return ((android.app.Activity) context).getIntent().getStringExtra(key);
    }

}
