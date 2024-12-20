package de.comsystoreply.gearbox.features.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import de.comsystoreply.gearbox.R

@Composable
fun ProfileScreen(
    onNavigateToBlogs: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold { ip ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(ip)
        ) {
            Text(text = stringResource(R.string.profile_title))
            Button(
                onClick = onNavigateToBlogs
            ) {
                Text(text = "Go to Blogs")
            }
        }
    }
}