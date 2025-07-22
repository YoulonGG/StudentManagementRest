package com.example.studentmanagementrest.shared

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */

fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}

fun Context.showToast(message: String?) {
    message?.let {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}