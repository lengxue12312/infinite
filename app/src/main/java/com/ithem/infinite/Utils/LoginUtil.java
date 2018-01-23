package com.ithem.infinite.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by chh1 on 2018/1/23.
 */

public class LoginUtil {

    private static SharedPreferences sp;

    public static String getString(Context ctx, String key, String defValue) {
        if (sp == null) {
            sp = ctx.getSharedPreferences("login", Context.MODE_PRIVATE);
        }
        return sp.getString(key, defValue);
    }

    public static void putString(Context ctx, String key, String value) {
        if (sp == null) {
            sp = ctx.getSharedPreferences("login", Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).commit();
    }

    public static boolean getBoolean(Context ctx, String key, boolean defValue) {
        if (sp == null) {
            sp = ctx.getSharedPreferences("login", Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    public static void putBoolean(Context ctx, String key, boolean value) {
        if (sp == null) {
            sp = ctx.getSharedPreferences("login", Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).commit();
    }
}
