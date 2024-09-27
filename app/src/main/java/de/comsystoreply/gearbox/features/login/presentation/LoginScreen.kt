package de.comsystoreply.gearbox.features.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun LoginScreen(
    onButtonPressed: () -> Unit,
    onLoginPressed: () -> Unit,
) {
    Scaffold { ip ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(ip)
        ) {
            Text(text = "login")
            TextButton(onButtonPressed) {
                Text("Back")
            }
            ElevatedButton(onLoginPressed) {
                Text(text = "Go to Home Screen")
            }
        }
    }
}