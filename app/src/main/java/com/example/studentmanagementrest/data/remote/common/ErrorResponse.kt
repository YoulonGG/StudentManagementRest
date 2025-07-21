package com.example.studentmanagementrest.data.remote.common

import com.example.studentmanagementrest.data.remote.util.CustomErrorException
import com.example.studentmanagementrest.data.remote.util.getErrorMessage

/**
 * @Author: John Youlong.
 * @Date: 7/21/25.
 * @Email: johnyoulong@gmail.com.
 */

fun getSomethingWentWrongError(): CustomErrorException {
    return createCustomError(
        code = ApiExceptionConstants.REQUEST_TIMEOUT_ERROR,
        title = "Error",
        message = "Something went wrong"
    )
}

private fun createCustomError(code: Int, title: String?, message: String?, type: Int = code): CustomErrorException {
    return CustomErrorException(
        getErrorMessage(
            code = code,
            title = title,
            message = message,
            type = type
        )
    )
}