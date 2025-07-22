package com.example.studentmanagementrest

import android.app.Application
import com.example.studentmanagementrest.core.utils.InternetUtil
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@HiltAndroidApp
class StudentManagementApp : Application(){
    override fun onCreate() {
        super.onCreate()
        InternetUtil.init(this)
        Timber.plant(Timber.DebugTree())
    }
}