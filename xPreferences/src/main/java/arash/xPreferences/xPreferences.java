package arash.xPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Map;
import java.util.Set;

public class xPreferences {
    private static SharedPreferences pref;
    private static volatile xPreferences prefHelper;

    public xPreferences(Context context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void initialize(Context appContext) {
        if (appContext == null) {
            throw new NullPointerException("xPreferences | Provided application context is null");
        }
        if (prefHelper == null) {
            synchronized (xPreferences.class) {
                if (prefHelper == null) {
                    prefHelper = new xPreferences(appContext);
                }
            }
        }
    }

    public static xPreferences getInstance() {
        if (prefHelper == null) {
            throw new IllegalStateException("xPreferences | SharedPrefsManager is not initialized!, call initialize(applicationContext) static method first");
        }
        return prefHelper;
    }

    public Boolean containsKey(String key) {
        return pref.contains(key);
    }

    public static void removeKey(String key) {
        pref.edit().remove(key).apply();
    }

    public void clearPrefs() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String defValue) {
        return pref.getString(key, defValue);
    }

    public void setBoolean(String key, Boolean isBoolean) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, isBoolean);
        editor.apply();
    }

    public Boolean getBoolean(String key, boolean defValue) {
        return pref.getBoolean(key, defValue);
    }

    public void setInt(String key, int value) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key, int defValue) {
        return pref.getInt(key, defValue);
    }

    public void setLong(String key, long value) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public long getLong(String key, long defValue) {
        return pref.getLong(key, defValue);
    }

    public void setFloat(String key, float value) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public float getFloat(String key, float defValue) {
        return pref.getFloat(key, defValue);
    }

    public void setStringSet(String key, Set<String> value) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    public Set<String> getStringSet(String key, Set<String> defValue) {
        return pref.getStringSet(key, defValue);
    }

    public Map<String, ?> getAllPrefs() {
        return pref.getAll();
    }
}