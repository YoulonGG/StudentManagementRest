package com.example.studentmanagementrest.presentation.auth.signup

import androidx.lifecycle.ViewModel
import com.example.studentmanagementrest.domain.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: John Youlong.
 * @Date: 6/27/25.
 * @Email: johnyoulong@gmail.com.
 */

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    fun onAction(event: SignUpAction){
        when (event) {
            is SignUpAction.SignUp -> {}
        }
    }

}