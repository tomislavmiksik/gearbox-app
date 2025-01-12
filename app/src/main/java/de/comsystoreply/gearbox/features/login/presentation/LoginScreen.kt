package de.comsystoreply.gearbox.features.login.presentation

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import de.comsystoreply.gearbox.R


@Composable
fun LoginScreen(
    onBackPressed: () -> Unit,
    onLoginPressed: () -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            value = email,
            onValueChange = { email = it },
            label = stringResource(R.string.login_email),
            placeholder = stringResource(R.string.login_email_hint),
            keyboardType = KeyboardType.Email,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        GearboxTextField(
            value = password,
            onValueChange = { password = it },
            label = stringResource(R.string.login_password),
            placeholder = stringResource(R.string.login_password_hint),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        GearboxButton(
            text = stringResource(R.string.login_button),
            onClick = onLoginPressed,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        GearboxOutlinedButton(
            text = stringResource(R.string.login_google),
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        GearboxOutlinedButton(
            text = stringResource(R.string.login_apple),
            onClick = { },
            backgroundColor = Color.Black,
            textColor = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
    }
}