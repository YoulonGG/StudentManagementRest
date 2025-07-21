package com.example.studentmanagementrest.core.ui_components

import androidx.annotation.Keep
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentmanagementrest.core.extentions.nonScaledSp
import com.example.studentmanagementrest.core.resource.errorColor
import com.example.studentmanagementrest.core.resource.hintColor
import com.example.studentmanagementrest.core.utils.getColor

/**
 * @Author: John Youlong.
 * @Date: 6/28/25.
 * @Email: johnyoulong@gmail.com.
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    inputData: TextFieldValue,
    hint: String,
    singleLine :Boolean= true,
    leadingIcon: @Composable ((Color) -> Unit)? = null,
    trailingButton: @Composable (() -> Unit)? = null,
    keyBoardType: KeyBoardType = KeyBoardType.NONE,
    isPassword: Boolean = false,
    isError: Pair<Boolean, String> = Pair(false, ""),
    onValueChanged: (TextFieldValue) -> Unit = {},
    isEnabled: Boolean = true,
    fontSize: TextUnit = 12.sp.nonScaledSp,
    maxLine: Int? = null,
    height: Dp = 48.dp
) {
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val colors = OutlinedTextFieldDefaults.colors(
        unfocusedBorderColor = getColor(
            isError = isError.first, isFocused = isFocused, isEmpty = inputData.text.isEmpty()
        ),
        focusedBorderColor = getColor(
            isError = isError.first, isFocused = isFocused, isEmpty = inputData.text.isEmpty()
        ),
//        cursorColor = LMSAppThemeColors.onPrimary,
//        disabledBorderColor = Color.Gray,
//        focusedTextColor = defaultLabelColor,
//        errorBorderColor = errorLabelColor,
//        unfocusedContainerColor = Color.White,
//        focusedContainerColor = Color.White,
//        selectionColors = TextSelectionColors(
//            handleColor = LMSAppThemeColors.error,
//            backgroundColor = LMSAppThemeColors.error.copy(alpha = 0.4f)
//        )

    )
    var passwordVisible by remember { mutableStateOf(false) }
    val visualTransformation =
        if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None
    val keyboardType = when {
        isPassword -> KeyboardType.Password
        keyBoardType == KeyBoardType.NumberOnly -> KeyboardType.Number
        keyBoardType == KeyBoardType.EMAIL -> KeyboardType.Email
        else -> KeyboardType.Text
    }

    Column {
        BasicTextField(
            maxLines = maxLine ?: Int.MAX_VALUE,
            readOnly = !isEnabled,
            value = inputData,
            onValueChange = { textFieldValue ->
                onValueChanged.invoke(textFieldValue)
            },
            interactionSource = interactionSource,
            enabled = isEnabled,
            singleLine = singleLine,
//            textStyle = LMSAppThemeTypography.bodySmall.copy(
//                color = LMSAppThemeColors.scrim,
//                fontSize = FontSize.NORMAL.sp,
//                fontWeight = MaterialTheme.modifier.fontWeight400,
//                lineHeight = MaterialTheme.modifier.lineHeight18
//            ),
            cursorBrush = SolidColor(hintColor),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.None,
            ),
            visualTransformation = visualTransformation,
            modifier = modifier
                .fillMaxWidth()
                .height(height)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
                .focusRequester(focusRequester)
                .onFocusChanged {
                    isFocused = it.isFocused
                },

            ) { innerTextField ->
            if (isPassword) {
                OutlinedTextFieldDefaults.DecorationBox(
                    value = inputData.text,
                    innerTextField = innerTextField,
                    visualTransformation = visualTransformation,
                    interactionSource = interactionSource,
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                            Icon(
//                                painter = if (passwordVisible) painterResource(AppIcons.icEye) else painterResource(
//                                    AppIcons.icEyeSlash
//                                ),
//                                contentDescription = if (passwordVisible) "Hide password" else "Show password",
//                                tint = Color.LightGray
//                            )
                        }
                    },
                    contentPadding = OutlinedTextFieldDefaults.contentPadding(
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                    singleLine = true,
                    enabled = isEnabled,
                    colors = colors,
                    container = {
                        OutlinedTextFieldDefaults.ContainerBox(
                            enabled = true,
                            colors = colors,
                            interactionSource = interactionSource,
                            isError = false,
                            shape = RoundedCornerShape(10.dp),
                        )
                    })
            } else {
                OutlinedTextFieldDefaults.DecorationBox(
                    value = inputData.text,
                    innerTextField = innerTextField,
                    visualTransformation = visualTransformation,
                    interactionSource = interactionSource,
                    contentPadding = OutlinedTextFieldDefaults.contentPadding(
                        top = if(singleLine) 8.dp else 12.dp,
                        bottom = 8.dp
                    ),
                    singleLine = singleLine,
                    enabled = isEnabled,
                    colors = colors,
                    container = {
                        OutlinedTextFieldDefaults.ContainerBox(
                            enabled = true,
                            colors = colors,
                            interactionSource = interactionSource,
                            isError = false,
                            shape = RoundedCornerShape(10.dp),
                        )
                    })
            }

            if (inputData.text.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        modifier = Modifier.padding( start = 16.dp, end = 16.dp, top = 16.dp),
                        text = hint,
                        color = Color.LightGray,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.W400,
                        lineHeight = 16.sp,
                        letterSpacing = 0.sp,
                    )
                }
            }
        }

        if (isError.first) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                text = isError.second,
                textAlign = TextAlign.Start,
                color = errorColor,
                fontWeight = FontWeight.W400,
                fontSize = 10.sp,
                lineHeight = 15.sp,
                maxLines = 2
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Keep
sealed class KeyBoardType {
    data object NumberOnly : KeyBoardType()
    data object LetterOnly : KeyBoardType()
    data object LetterNumber : KeyBoardType()
    data object NONE : KeyBoardType()
    data object EMAIL : KeyBoardType()
}