package com.example.studentmanagementrest.presentation.auth.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentmanagementrest.domain.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
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

    fun onAction(event: SignUpAction) {
        when (event) {
            is SignUpAction.SignUp -> {
                signupAdmin(event.firstName, event.lastName, event.email, event.password)
            }
        }
    }

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    private fun signupAdmin(firstName: String, lastName: String, email: String, password: String) {
        val map = HashMap<String, Any>()
        map["first_name"] = firstName
        map["last_name"] = lastName
        map["email"] = email
        map["password"] = password

        viewModelScope.launch {
            try {
                repository.signUpAdmin(map)
            } catch (e: Exception) {
                Log.e("", "Login Failed")
            }
        }
    }

}