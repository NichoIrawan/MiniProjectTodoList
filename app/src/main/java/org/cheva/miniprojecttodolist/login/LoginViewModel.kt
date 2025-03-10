package org.cheva.miniprojecttodolist.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.cheva.miniprojecttodolist.DataClass.Driver

class LoginViewModel: ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.onNameChanged -> changeName(event.name)
            is LoginEvent.onPasswordChanged -> changePassword(event.password)
            is LoginEvent.onPasswordVisibilityChanged -> changePasswordVisibility(event.isVisible)
            LoginEvent.onLoginClicked -> login()
            LoginEvent.OnDismissDialog -> dismissDialog()
        }
    }

    private fun dismissDialog() {
        _state.update { it.copy(message = "", successLogin = false) }
    }

    private fun changeName(name: String) {
        _state.update { it.copy(name = name) }
    }

    private fun changePassword(password: String) {
        _state.update { it.copy(password = password) }
    }

    private fun changePasswordVisibility(isVisible: Boolean) {
        _state.update { it.copy(passwordVisibility = isVisible) }
    }

    private fun login() {
        if (Driver.checkCredential(state.value.name, state.value.password)) {
            _state.update { it.copy(message = "Login Success", successLogin = true) }
        } else {
            _state.update { it.copy(message = "Username atau password salah") }
        }
    }
}
