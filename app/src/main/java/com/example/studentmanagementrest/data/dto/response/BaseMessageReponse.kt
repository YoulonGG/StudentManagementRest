package com.example.studentmanagementrest.data.dto.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

@Keep
@Parcelize
data class BaseMessageResponse(
    @SerializedName("message")
    val message: String? = null
) : Parcelable