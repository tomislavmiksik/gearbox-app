package de.comsystoreply.gearbox.features.login.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import de.comsystoreply.gearbox.ui.components.buttons.GearboxButton
import de.comsystoreply.gearbox.ui.components.buttons.GearboxOutlinedButton
import de.comsystoreply.gearbox.ui.components.inputs.GearboxTextField
import de.comsystoreply.gearbox.ui.components.text.GearboxTitle
import de.comsystoreply.gearbox.ui.components.text.GearboxSubtitle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.features.login.ui.viewmodel.LoginViewModel
import de.comsystoreply.gearbox.features.login.ui.viewmodel.LoginIntent
import org.koin.androidx.compose.koinViewModel


@Composable
fun LoginScreen(
    onBackPressed: () -> Unit,
    onLoginPressed: () -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    LaunchedEffect(uiState.isLoginSuccessful) {
        if (uiState.isLoginSuccessful) {
            onLoginPressed()
            viewModel.resetLoginSuccess()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        GearboxTitle(
            text = stringResource(R.string.login_title),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        GearboxSubtitle(
            text = stringResource(R.string.login_subtitle),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(40.dp))

        GearboxTextField(
            value = uiState.email,
            onValueChange = { viewModel.handleIntent(LoginIntent.EmailChanged(it)) },
            label = stringResource(R.string.login_email),
            placeholder = stringResource(R.string.login_email_hint),
            keyboardType = KeyboardType.Email,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        GearboxTextField(
            value = uiState.password,
            onValueChange = { viewModel.handleIntent(LoginIntent.PasswordChanged(it)) },
            label = stringResource(R.string.login_password),
            placeholder = stringResource(R.string.login_password_hint),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        GearboxButton(
            text = stringResource(R.string.login_button),
            onClick = { viewModel.handleIntent(LoginIntent.LoginClicked) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        GearboxOutlinedButton(
            text = stringResource(R.string.login_google),
            onClick = { viewModel.handleIntent(LoginIntent.GoogleLoginClicked) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        GearboxOutlinedButton(
            text = stringResource(R.string.login_apple),
            onClick = { viewModel.handleIntent(LoginIntent.AppleLoginClicked) },
            backgroundColor = Color.Black,
            textColor = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
    }
}