package de.comsystoreply.gearbox.features.login.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.features.login.ui.viewmodel.LoginIntent
import de.comsystoreply.gearbox.features.login.ui.viewmodel.LoginViewModel
import de.comsystoreply.gearbox.ui.components.buttons.GearboxButton
import de.comsystoreply.gearbox.ui.components.buttons.GearboxOutlinedButton
import de.comsystoreply.gearbox.ui.components.inputs.GearboxTextField
import de.comsystoreply.gearbox.ui.components.text.GearboxSubtitle
import de.comsystoreply.gearbox.ui.components.text.GearboxTitle
import org.koin.androidx.compose.koinViewModel


@Composable
fun LoginScreen(
    onLoginPressed: () -> Unit,
    viewModel: LoginViewModel = koinViewModel(),
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isLoginSuccessful) {
        if (uiState.isLoginSuccessful) {
            onLoginPressed()
            viewModel.resetLoginSuccess()
        }
    }

    LaunchedEffect(uiState.error) {
        uiState.error?.let {
            snackBarHostState.showSnackbar(
                it
            )
        }
    }

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState,
                snackbar = {
                    Snackbar(
                        it,
                        containerColor = colorResource(R.color.dark_blue)
                    )
                }
            )
        }
    ) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .background(Color.White)
                .padding(26.dp),
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            GearboxTitle(
                text = stringResource(R.string.login_title),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            GearboxSubtitle(
                text = stringResource(R.string.login_subtitle),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(40.dp))
            GearboxTextField(
                value = uiState.email,
                onValueChange = { viewModel.handleIntent(LoginIntent.EmailChanged(it)) },
                label = stringResource(R.string.login_email),
                placeholder = stringResource(R.string.login_email_hint),
                keyboardType = KeyboardType.Email,
                isError = !uiState.isEmailValid,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            GearboxTextField(
                value = uiState.password,
                onValueChange = { viewModel.handleIntent(LoginIntent.PasswordChanged(it)) },
                label = stringResource(R.string.login_password),
                placeholder = stringResource(R.string.login_password_hint),
                keyboardType = KeyboardType.Password,
                isError = !uiState.isPasswordValid,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            GearboxButton(
                text = if (uiState.isLoading) "Signing in..." else stringResource(R.string.login_button),
                onClick = { viewModel.handleIntent(LoginIntent.LoginClicked) },
                enabled = !uiState.isLoading && uiState.email.isNotBlank() && uiState.password.isNotBlank(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            GearboxOutlinedButton(
                text = stringResource(R.string.login_google),
                onClick = { viewModel.handleIntent(LoginIntent.GoogleLoginClicked) },
                enabled = !uiState.isLoading,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            GearboxOutlinedButton(
                text = stringResource(R.string.login_apple),
                onClick = { viewModel.handleIntent(LoginIntent.AppleLoginClicked) },
                enabled = !uiState.isLoading,
                backgroundColor = Color.Black,
                textColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}