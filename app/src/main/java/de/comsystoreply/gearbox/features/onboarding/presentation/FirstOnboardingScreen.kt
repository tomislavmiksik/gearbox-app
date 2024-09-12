package de.comsystoreply.gearbox.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import de.comsystoreply.gearbox.R


@Composable
fun FirstOnboardingScreen(onNextPressed: () -> Unit) {
    val image = painterResource(id = R.drawable.onboarding_picture_first)
    Scaffold { ip ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                painter = image,
                contentScale = ContentScale.Crop,
                contentDescription = "Picture representing two man next to a car"
            )
            TextButton(onNextPressed) {
                Text(text = "Go to Second Onboarding")
            }
        }
    }
}