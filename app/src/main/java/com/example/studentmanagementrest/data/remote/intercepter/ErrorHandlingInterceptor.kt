package com.example.studentmanagementrest.data.remote.intercepter

import com.example.studentmanagementrest.data.remote.common.ApiExceptionConstants
import com.example.studentmanagementrest.data.remote.util.CustomErrorException
import com.example.studentmanagementrest.data.remote.util.getErrorMessage
import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */


class ErrorHandlingInterceptor @Inject constructor() : Interceptor {
    @Throws(Throwable::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (response.isSuccessful) return response

        val title = "Error"
        var message: String
        response.body.string().let { errorBody ->
            Timber.e("Error Body : $errorBody")
            when {
                //                errorBody.startsWith("<") -> {
                //                    // Handle HTML/XML responses
                //                    message = if(getMessageFromErrorResponse(errorBody)?.contains("403") == true){
                //                        LMSLanguageProvider.translate(StringRes.FORBIDDEN_ERROR)
                //                    } else {
                //                        getMessageFromErrorResponse(errorBody) ?: CommonStringRes.SOMETHING_WENT_WRONG
                //                    }
                //                }

                isValidJson(errorBody) -> {
                    try {
                        val jObject = JSONObject(errorBody)
                        message = jObject.getString("message")
                    } catch (e: JSONException) {
                        message = "Something went wrong"
                    }
                }

                else -> {
                    // Handle plain text responses
                    message = when {
                        errorBody.isBlank() -> "Something went wrong"
                        errorBody.equals("Error", ignoreCase = true) -> "Something went wrong"
                        else -> errorBody.take(200)
                    }
                }
            }
        }
//        if (response.code == 401) {
//            CoroutineScope(Dispatchers.IO).launch {
//                secureStorage.clearAllSaveData()
//                UserManager.setTokenSavedFlag(false)
//            }
//        }

        val apiErrorCode = when (response.code) {
            in 301..308 -> ApiExceptionConstants.SERVER_MOVED_ERROR
            400 -> ApiExceptionConstants.BAD_REQUEST_ERROR
            401 -> ApiExceptionConstants.UNAUTHORIZED_ERROR
            403 -> ApiExceptionConstants.REQUEST_FORBIDDEN_ERROR
            404 -> ApiExceptionConstants.WRONG_URL_ERROR
            408 -> ApiExceptionConstants.REQUEST_TIMEOUT_ERROR
            413 -> ApiExceptionConstants.LARGE_FILE_SIZE_ERROR
            422 -> ApiExceptionConstants.UNABLE_TO_RESPONSE_ERROR
            429 -> ApiExceptionConstants.TOO_MANY_REQUEST_ERROR
            500 -> ApiExceptionConstants.INTERNAL_SERVER_ERROR
            502 -> ApiExceptionConstants.BAD_GATEWAY_ERROR
            503 -> ApiExceptionConstants.SERVICE_UNAVAILABLE_ERROR
            504 -> ApiExceptionConstants.GATEWAY_TIMEOUT_ERROR
            else -> ApiExceptionConstants.UNKNOWN_ERROR
        }

        throw CustomErrorException(getErrorMessage(response.code, title, message, apiErrorCode))
    }


    private fun isValidJson(jsonString: String): Boolean {
        return try {
            JSONObject(jsonString)
            true
        } catch (e: JSONException) {
            try {
                org.json.JSONArray(jsonString)
                true
            } catch (e: JSONException) {
                false
            }
        }
    }

}
