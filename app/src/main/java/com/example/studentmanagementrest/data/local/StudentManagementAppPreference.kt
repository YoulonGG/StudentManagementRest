package com.example.studentmanagementrest.data.local

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */

object PreferencesKeys {
    const val TOKEN = "token"
}

object StudentManagementAppPreference {

    const val PREFS_NAME = "student_management_app_preferens"

    private lateinit var sharedPreferences: SharedPreferences

    fun init(prefs: SharedPreferences) {
        sharedPreferences = prefs
    }

    fun clearUserInfo(key: String) {
        sharedPreferences.edit() { clear() }
    }

    fun getPrefs(): SharedPreferences = sharedPreferences

    // Save a string value
    fun putString(key: String, value: String) {
        sharedPreferences.edit() { putString(key, value) }
    }

    // Retrieve a string value
    fun getString(key: String, defaultValue: String? = null): String? {
        return sharedPreferences.getString(key, defaultValue)
    }


    fun putObject(key: String, obj: Any) {
        val gson = Gson()
        val json = gson.toJson(obj)
        sharedPreferences.edit() { putString(key, json) }
    }

    inline fun <reified T> getObject(key: String): T? {
        val gson = Gson()
        val json = getString(key, null)
        return if (json != null) gson.fromJson(json, T::class.java) else null
    }

    // Save an integer value
    fun putInt(key: String, value: Int) {
        sharedPreferences.edit() { putInt(key, value) }
    }

    // Retrieve an integer value
    fun getInt(key: String, defaultValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    // Save a boolean value
    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit() { putBoolean(key, value) }
    }

    // Retrieve a boolean value
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    // Save a long value
    fun putLong(key: String, value: Long) {
        sharedPreferences.edit() { putLong(key, value) }
    }

    // Retrieve a long value
    fun getLong(key: String, defaultValue: Long = 0L): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    // Save a float value
    fun putFloat(key: String, value: Float) {
        sharedPreferences.edit() { putFloat(key, value) }
    }

    // Retrieve a float value
    fun getFloat(key: String, defaultValue: Float = 0f): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    // Clear all preferences
    fun clear() {
        sharedPreferences.edit() { clear() }
    }

    fun clearSpecificData(key: String) {
        sharedPreferences.edit {
            remove(key)
        }
    }


}