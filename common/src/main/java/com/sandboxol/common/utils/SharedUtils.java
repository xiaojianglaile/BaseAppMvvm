package com.sandboxol.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jimmy on 2017/9/27 0027.
 */
public class SharedUtils {

    private static final String DEFAULT_FILE_NAME = "data";

    public static void putString(Context context, String key, String value) {
        putString(context, DEFAULT_FILE_NAME, key, value);
    }

    public static void putString(Context context, String name, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void putInt(Context context, String key, int value) {
        putInt(context, DEFAULT_FILE_NAME, key, value);
    }

    public static void putInt(Context context, String name, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void putLong(Context context, String key, long value) {
        putLong(context, DEFAULT_FILE_NAME, key, value);
    }

    public static void putLong(Context context, String name, String key, long value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void putBoolean(Context context, String key, boolean value) {
        putBoolean(context, DEFAULT_FILE_NAME, key, value);
    }

    public static void putBoolean(Context context, String name, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void putFloat(Context context, String key, float value) {
        putFloat(context, DEFAULT_FILE_NAME, key, value);
    }

    public static void putFloat(Context context, String name, String key, float value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key) {
        return getString(context, key, null);
    }

    public static String getString(Context context, String key, String dfValue) {
        return getString(context, DEFAULT_FILE_NAME, key, dfValue);
    }

    public static String getString(Context context, String name, String key, String dfValue) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE).getString(key, dfValue);
    }

    public static int getInt(Context context, String key) {
        return getInt(context, DEFAULT_FILE_NAME, key);
    }

    public static int getInt(Context context, String name, String key) {
        return getInt(context, name, key, 0);
    }

    public static int getInt(Context context, String key, int dfValue) {
        return getInt(context, DEFAULT_FILE_NAME, key, dfValue);
    }

    public static int getInt(Context context, String name, String key, int dfValue) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE).getInt(key, dfValue);
    }

    public static long getLong(Context context, String key) {
        return getLong(context, DEFAULT_FILE_NAME, key);
    }

    public static long getLong(Context context, String name, String key) {
        return getLong(context, name, key, 0L);
    }

    public static long getLong(Context context, String key, long dfValue) {
        return getLong(context, DEFAULT_FILE_NAME, key, dfValue);
    }

    public static long getLong(Context context, String name, String key, long dfValue) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE).getLong(key, dfValue);
    }

    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, DEFAULT_FILE_NAME, key);
    }

    public static boolean getBoolean(Context context, String name, String key) {
        return getBoolean(context, name, key, false);
    }

    public static boolean getBoolean(Context context, String key, boolean dfValue) {
        return getBoolean(context, DEFAULT_FILE_NAME, key, dfValue);
    }

    public static boolean getBoolean(Context context, String name, String key, boolean dfValue) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE).getBoolean(key, dfValue);
    }

    public static float getFloat(Context context, String key) {
        return getFloat(context, DEFAULT_FILE_NAME, key);
    }

    public static float getFloat(Context context, String name, String key) {
        return getFloat(context, name, key, 0f);
    }

    public static float getFloat(Context context, String key, float dfValue) {
        return getFloat(context, DEFAULT_FILE_NAME, key, dfValue);
    }

    public static float getFloat(Context context, String name, String key, float dfValue) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE).getFloat(key, dfValue);
    }

    public static void remove(Context context, String key) {
        remove(context, DEFAULT_FILE_NAME, key);
    }

    public static void remove(Context context, String name, String key) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    public static void clear(Context context) {
        clear(context, DEFAULT_FILE_NAME);
    }

    public static void clear(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

}
