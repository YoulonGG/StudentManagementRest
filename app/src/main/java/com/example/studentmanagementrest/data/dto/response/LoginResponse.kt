package com.example.studentmanagementrest.data.dto.response

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
data class LoginResponse(

    @SerializedName("access_token")
    val accessToken: String? = null,
    @SerializedName("refresh_token")
    val refreshToken: String? = null,

) : Parcelable