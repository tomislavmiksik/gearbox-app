package de.comsystoreply.gearbox.features.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

const val route: String = "login"

@Destination(route = route)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, navigator: DestinationsNavigator) {
    Scaffold { ip ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(ip)
        ) {
            val widthModifier = Modifier.fillMaxWidth()
            Text(text = "login")
            TextButton(onClick = {
                navigator.navigate("welcome")
            }) {
                Text("Back")
            }
        }
    }
}