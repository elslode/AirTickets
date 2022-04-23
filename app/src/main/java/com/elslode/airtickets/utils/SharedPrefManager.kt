package com.elslode.airtickets.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefManager @Inject constructor(
    private val context: Context
) {

    companion object {
        val PREFS_NAME = "TICKET_APP_SHARED"
    }

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveToken(KEY_NAME: String, token: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_NAME, token)
        editor.commit()
    }

    fun getTokenSP(): String? {
        return sharedPref.getString(PREFS_NAME, "")
    }
}