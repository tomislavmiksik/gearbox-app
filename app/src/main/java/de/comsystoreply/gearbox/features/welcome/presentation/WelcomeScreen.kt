package de.comsystoreply.gearbox.features.welcome.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


const val route: String = "welcome"

@Destination(start = true, route = route)
@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, destinationsNavigator: DestinationsNavigator) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextButton(onClick = {
            destinationsNavigator.navigate("login")
        }) {
            Text(text = "Navigate")
        }
    }
}