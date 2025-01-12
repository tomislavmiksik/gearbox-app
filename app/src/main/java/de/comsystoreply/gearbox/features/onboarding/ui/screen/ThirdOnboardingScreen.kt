package de.comsystoreply.gearbox.features.onboarding.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.ui.components.onboarding.OnboardingScreen

@Composable
fun ThirdOnboardingScreen(onGetStartedPressed: () -> Unit) {
    OnboardingScreen(
        title = stringResource(R.string.onboarding_title_3),
        description = stringResource(R.string.onboarding_desc_3),
        imageRes = R.drawable.onboarding_picture_third,
        buttonText = stringResource(R.string.onboarding_get_started),
        currentPage = 3,
        onButtonClick = onGetStartedPressed
    )
}