package de.comsystoreply.gearbox.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.common.presentation.composable.OnboardingHeader
import de.comsystoreply.gearbox.ui.theme.White


@Composable
fun FirstOnboardingScreen(onNextPressed: () -> Unit) {
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }


    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, White),
        startY = (sizeImage.height.toFloat() * 0.75).toFloat(),
        endY = sizeImage.height.toFloat()
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .onGloballyPositioned {
                    sizeImage = it.size
                },
            painter = painterResource(id = R.drawable.onboarding_picture_first),
            contentScale = ContentScale.Crop,
            contentDescription = "Picture representing two man next to a car"
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .background(gradient)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                OnboardingHeader(
                    title = stringResource(R.string.onboarding_welcome),
                    currentStep = 1
                )
                Button(
                    onClick = onNextPressed,
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text(text = stringResource(R.string.onboarding_next))
                }
            }
        }
    }
}