package com.example.studentmanagementrest

import android.app.Application
import android.content.SharedPreferences
import com.example.studentmanagementrest.core.utils.InternetUtil
import com.example.studentmanagementrest.data.local.StudentManagementAppPreference
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@HiltAndroidApp
class StudentManagementApp : Application(){

    @Inject
    lateinit var sharePreferences : SharedPreferences

    override fun onCreate() {
        super.onCreate()
        StudentManagementAppPreference.init(sharePreferences)
        InternetUtil.init(this)
        Timber.plant(Timber.DebugTree())
    }
}