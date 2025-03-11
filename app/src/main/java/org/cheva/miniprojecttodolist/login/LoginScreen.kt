package org.cheva.miniprojecttodolist.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.cheva.miniprojecttodolist.R
import org.cheva.miniprojecttodolist.navigation.DashboardScreen
import org.cheva.miniprojecttodolist.navigation.RegisterScreen
import org.cheva.miniprojecttodolist.ui.components.OutlinedTextField
import org.cheva.miniprojecttodolist.ui.components.ResultDialog
import org.cheva.miniprojecttodolist.ui.components.SecureTextField
import org.cheva.miniprojecttodolist.ui.theme.MiniProjectTodoListTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
    onNavigate: (Any) -> Unit
) {
    LaunchedEffect(state.successLogin) {
        if (state.successLogin){
            delay(1000)
            onNavigate(DashboardScreen(state.name))
        }
    }
    Scaffold {
        if (state.message.isNotBlank()) {
            ResultDialog(
                isSuccess = state.successLogin,
                message = state.message,
                onDismiss = { onEvent(LoginEvent.OnDismissDialog) }
            )
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.login_headline),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.login_hint),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                label = stringResource(R.string.name_label),
                value = state.name,
                onValueChange = { onEvent(LoginEvent.onNameChanged(it)) },
                keyboardType = KeyboardType.Text,
                hint = stringResource(R.string.name_hint)
            )
            Spacer(modifier = Modifier.height(8.dp))
            SecureTextField(
                label = stringResource(R.string.password_label),
                value = state.password,
                onValueChange = { onEvent(LoginEvent.onPasswordChanged(it)) },
                keyboardType = KeyboardType.Password,
                isVisible = state.passwordVisibility,
                onVisibilityChange = { onEvent(LoginEvent.onPasswordVisibilityChanged(it)) },
                hint = stringResource(R.string.password_hint)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onEvent(LoginEvent.onLoginClicked)
                }
            ) {
                Text(stringResource(R.string.login_headline))
            }
            TextButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {onNavigate(RegisterScreen)}
            ) {
                Text(stringResource(R.string.to_register))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LoginScreenPrev() {
    MiniProjectTodoListTheme {
        LoginScreen(
            state = LoginState(),
            onEvent = {},
            onNavigate = {}
        )
    }
}