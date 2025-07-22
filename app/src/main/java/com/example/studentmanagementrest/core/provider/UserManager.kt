package com.example.studentmanagementrest.core.provider

import com.example.studentmanagementrest.data.local.PreferencesKeys
import com.example.studentmanagementrest.data.local.StudentManagementAppPreference

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */


object UserManager {

    private var token: String? = null

    fun saveToken(token: String) {
        StudentManagementAppPreference.putString(PreferencesKeys.TOKEN, token)
    }

    fun getToken() = StudentManagementAppPreference.getString(PreferencesKeys.TOKEN)

}