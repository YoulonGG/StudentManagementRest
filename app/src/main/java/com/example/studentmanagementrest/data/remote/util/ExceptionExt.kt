package com.example.studentmanagementrest.data.remote.util

import com.example.studentmanagementrest.data.dto.response.BaseMessageResponse
import com.example.studentmanagementrest.data.remote.common.ApiExceptionConstants.SUCCESS_ERROR
import com.example.studentmanagementrest.data.remote.common.ApiResult
import com.example.studentmanagementrest.data.remote.common.getSomethingWentWrongError
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */


fun <T> Exception.toApiError(): ApiResult.Error<T> {
    return when (this) {
        is CustomErrorException -> ApiResult.Error(error = this)
        else -> ApiResult.Error(error = getSomethingWentWrongError())
    }
}

fun <T> String?.toApiResult(response: T): ApiResult<T> {
    return if ((response as? BaseMessageResponse)?.message.isNullOrBlank()) {
        ApiResult.Success(response)
    } else {

        val defaultTitle = "Error"
        val defaultMessage = "Something went wrong"
        try {
            val jObject = Gson().toJson(response as? BaseMessageResponse)
            val jsonObject = JSONObject(jObject)
            val messageObject = jsonObject.getJSONObject("message")
//            val errorTitle = LMSLanguageProvider.translateAPIKey(messageObject.optString("title", defaultTitle))
//            val errorDescription = LMSLanguageProvider.translateAPIKey(messageObject.optString("description", defaultMessage))
            ApiResult.Error(
                CustomErrorException(
                    getErrorMessage(
                        -1,
                        messageObject.optString("message", defaultTitle),
                        messageObject.getString("message"),
                        SUCCESS_ERROR
                    )
                )
            )
        } catch (e: Exception) {
            ApiResult.Error(
                CustomErrorException(
                    getErrorMessage(-1, defaultTitle, defaultMessage, SUCCESS_ERROR)
                )
            )
        }
    }
}

private fun String.sanitize(): String {
    return replace("\"", "")
}

//fun getErrorMessage(code: Int?, title: String?, message: String?, type: Int?): String {
//    return "{" + "\"code\":$code,\"title\":\"$title\",\"message\":\"${message?.sanitize()}\",\"type\":$type" + "}"
//}

fun getErrorMessage(code: Int?, title: String?, message: String?, type: Int?): String {
    return "$message"
}

class CustomErrorException(override val message: String = "Something went wrong!") :
    IOException(message)
