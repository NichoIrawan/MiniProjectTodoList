package org.cheva.miniprojecttodolist.login

sealed interface LoginEvent {
    data class onNameChanged(val name: String): LoginEvent
    data class onPasswordChanged(val password: String): LoginEvent
    data class onPasswordVisibilityChanged(val isVisible: Boolean): LoginEvent
    object onLoginClicked: LoginEvent
    object OnDismissDialog : LoginEvent
}
