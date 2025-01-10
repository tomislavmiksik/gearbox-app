package de.comsystoreply.gearbox.features.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ElevatedButton
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import de.comsystoreply.gearbox.R


@Composable
fun LoginScreen(
    onBackPressed: () -> Unit,
    onLoginPressed: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.login_title))
            
            TextButton(onClick = onBackPressed) {
                Text(stringResource(R.string.login_back))
            }
            
            ElevatedButton(
                onClick = onLoginPressed,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = stringResource(R.string.login_button))
            }
        }
    }
}