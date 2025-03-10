package org.cheva.miniprojecttodolist.login

import org.cheva.miniprojecttodolist.register.RegisterEvent

data class LoginState (
    val name: String = "",
    val password: String = "",
    val passwordVisibility: Boolean = false,
    val successLogin: Boolean = false,
    val message: String = ""
)