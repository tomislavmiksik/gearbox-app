package de.comsystoreply.gearbox.features.blogs.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import de.comsystoreply.gearbox.ui.components.buttons.GearboxButton
import de.comsystoreply.gearbox.ui.components.text.GearboxTitle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import de.comsystoreply.gearbox.R

@Composable
fun BlogScreen(
    onNavigateToProfile: () -> Unit = {}
) {
    Scaffold { ip ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(ip)
        ) {
            GearboxTitle(text = stringResource(R.string.blogs_title))
            GearboxButton(
                text = "Go to Profile",
                onClick = onNavigateToProfile
            )
        }
    }
}