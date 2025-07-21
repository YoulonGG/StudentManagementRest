package com.example.studentmanagementrest.presentation.auth.signup

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.studentmanagementrest.core.base.BaseViewModel
import com.example.studentmanagementrest.domain.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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
) : BaseViewModel<SignUpUiState, SignUpAction>() {

    /**
     * This function is called to set the initial state of the ViewModel.
     * It initializes the UI state with default values.
     */
    override fun setInitialState(): SignUpUiState = SignUpUiState()

    override fun onAction(event: SignUpAction) {
        when (event) {
            is SignUpAction.SignUp -> {
                signupAdmin(
                    firstName = event.firstName,
                    lastName = event.lastName,
                    email = event.email,
                    password = event.password
                )
            }
        }
    }

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







