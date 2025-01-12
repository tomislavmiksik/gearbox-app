package de.comsystoreply.gearbox.features.onboarding.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.ui.components.onboarding.OnboardingScreen

@Composable
fun SecondOnboardingScreen(onNextPressed: () -> Unit) {
    OnboardingScreen(
        title = stringResource(R.string.onboarding_title_2),
        description = stringResource(R.string.onboarding_desc_2),
        imageRes = R.drawable.onboarding_picture_second,
        buttonText = stringResource(R.string.onboarding_next),
        currentPage = 2,
        onButtonClick = onNextPressed
    )
}