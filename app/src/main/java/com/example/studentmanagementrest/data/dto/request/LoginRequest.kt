package com.example.studentmanagementrest.data.dto.request

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * @Author: John Youlong.
 * @Date: 7/22/25.
 * @Email: johnyoulong@gmail.com.
 */

@Keep
@Parcelize
data class LoginRequest(

    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null,

) : Parcelable